package www.dream.bbs.party.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import www.dream.bbs.party.mapper.PartyMapper;
import www.dream.bbs.party.model.AccountabilityVO;
import www.dream.bbs.party.model.OrganizationVO;
import www.dream.bbs.party.model.PersonVO;
import www.dream.bbs.party.model.TmdbCastsVO;
import www.dream.bbs.party.model.TmdbCompanyVO;

@Service
public class PartyService implements UserDetailsService {
	@Autowired
	private PartyMapper partyMapper;

	@Autowired
	private PasswordEncoder pwdEnc;

	public List<PersonVO> listAllMember(String ownerId) {
		return partyMapper.listAllMember(ownerId);
	}

	public int createOrganization(OrganizationVO organization) {
		organization.encodePwd(pwdEnc);
		return partyMapper.createOrganization(organization);
	}

	public int createManager(OrganizationVO organization, PersonVO person) {
		person.encodePwd(pwdEnc);
		int cnt = partyMapper.createPerson(person);

		partyMapper.createAccountability(new AccountabilityVO("manager", organization.getId(), person.getId()));
		return cnt;
	}

	/** 회원 가입 */
	public int createMember(PersonVO person) {
		person.encodePwd(pwdEnc);
		int cnt = partyMapper.createPerson(person);

		partyMapper
				.createAccountability(new AccountabilityVO("member", person.getOrganization().getId(), person.getId()));
		return cnt;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return partyMapper.findByNick(username);
	}

	public boolean checkNick(String nick) {
		return partyMapper.isValidNick(nick);
	}

	/**
	 * 사람과 영화 관계 (movie m : m 구조로 party에 들어가는 제작진과 제작사 정보)
	 */
	
	public String changeId(int id) {
		return partyMapper.changeId(id);
	}
	
	// Party 쿼리에 들어가는 영화 제작사 정보.
	public int saveCompany(List<TmdbCompanyVO> listCompany) {
		List<String> listIdString = listCompany.stream().map(obj -> obj.getStringId()).distinct().collect(Collectors.toList());
		List<String> listExisting = partyMapper.findExistings(listIdString, "producer");
		List<TmdbCompanyVO> listNew = listCompany.stream().filter(obj -> !listExisting.contains(obj.getStringId()))
				.collect(Collectors.toList());
		if (listNew.size() == 0) {
			return 0;
		}
		return partyMapper.saveCompany(listNew);
	}

	// Party 쿼리에 들어가는 영화 관계자들 정보.
	public int saveCredits(Set<TmdbCastsVO> listCredits) {
		List<String> listIdString = listCredits.stream().map(obj -> obj.getStringId()).collect(Collectors.toList());
		List<String> listExisting = partyMapper.findExistings(listIdString, "casts");
		List<TmdbCastsVO> listNew = listCredits.stream().filter(obj -> !listExisting.contains(obj.getStringId()))
				.collect(Collectors.toList());
		if (listNew.size() == 0) {
			return 0;
		}
		return partyMapper.saveCredits(listNew);
	}
	
	//save배우(movieId, 목록<영화관련자VO>)
	/*
	 * 영화관련자VO 중에 관리되고있던 배우면?
	 * new:
	 * duplicated:
	 * */
}
