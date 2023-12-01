package www.dream.bbs.party.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import www.dream.bbs.party.model.AccountabilityVO;
import www.dream.bbs.party.model.OrganizationVO;
import www.dream.bbs.party.model.RecentMovieVO;
import www.dream.bbs.party.model.ReportVO;
import www.dream.bbs.party.model.TmdbCastsVO;
import www.dream.bbs.party.model.TmdbCompanyVO;
import www.dream.bbs.party.model.TmdbCrewsVO;
import www.dream.bbs.party.model.User4PartyVO;


@Mapper		//Container에 담기도록 지정
public interface PartyMapper {
	//관리자 입장에서 회사의 발전성 보기 위하여 DAU - Daily active/new/out Member count
	//추세: 막대그래프
	//WAU, MAU
	
	//LRCUD 순서로 함수들을 배치하여 빠르게 따라갈(추적성) 수 있도록 합니다. 
	public List<User4PartyVO> listAllMember(String ownerId);
	//REPORT 하는 것.
	public List<ReportVO> listReported();
	//최근 본 영화 정보들
	public List<RecentMovieVO> listAllRecentMovies(String id);
	//최근 본 영화의 장르 정보들
	public List<String> listRecentMoviesGenre(String userId);
	//최근 본 영화 검색 기능
	public boolean findRecentMovie(RecentMovieVO watching);
	//최근 본 영화 리스트 만들기
	public int createRecentMovie(RecentMovieVO watching);
	//멤버십 업데이트하기.
	public int updateMembership(User4PartyVO user);
	//패널티 부가하는 기능(한방에 1~최대수치까지)
	public int updatePenalty(User4PartyVO user);
	//패널티 주는 기능 (무족건 1씩)
	public int givePenalty(String id);
	//레포트 보낸걸 확인하기
	public int checkReport(int movieId, String writerId);
	//어카운트 비활성화시키기. (회원탈퇴)
	public int inactiveAccount(String id);
	//최근 본 영화 업데이트하기
	public int updateRecentMovie(RecentMovieVO watching);

	
	public User4PartyVO findByNick(String nick);
	
	public boolean isValidNick(String nick);

	public int createOrganization(OrganizationVO organization);

	public int createPerson(User4PartyVO person);

	public int createAccountability(AccountabilityVO accountability);

	/** 회원 탈퇴 처리의 전략은?
	public int updateMember(PersonVO member);
	
	 * isActive !
	public int deactivateParty(PartyVO party);
	 * record delete 
	 */
	
	/**
	 * 여기서 부터는 Party로 들어가는 영화 관계자, 제작사 정보.
	 */
	//Party 쿼리에 들어가는 영화 제작사 정보.
	public int saveCompany(List<TmdbCompanyVO> listCompany);
	
	//Party 쿼리에 들어가는 영화 관계자들 정보.
	public int saveCredits(List<TmdbCastsVO> listCredits);

	public List<String> findExistings(List<String> listIdString, String descrim);

	public String changeId(int id);

	public int saveCrews(List<TmdbCrewsVO> listCrews);

}
