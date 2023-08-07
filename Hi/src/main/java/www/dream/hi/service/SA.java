package www.dream.hi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.hi.model.MemberDTO;
import www.dream.hi.model.MemberVO;

@Service
public class SA {
	@Autowired
	private SB sb;
	public MemberVO take(MemberDTO member) {
		MemberVO ret = new MemberVO(member.getId(), member.getBal() + 888999999, member.getPwd());
		return ret;
	}
	
	
}
