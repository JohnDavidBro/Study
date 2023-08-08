package www.dream.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.party.model.PartyVO;
import www.dream.party.model.mapper.PartyMapper;

//Container에 담기도록 지정
@Service //아키텍쳐 표준
public class PartyService {
	@Autowired
	private PartyMapper partyMapper;
	public List<PartyVO> listAll() {
		return partyMapper.listAll();
	}
	/** public BoardVO findBydd(String dd) { // 이런 식으로 설정 가능
		return boardMapper.findBydd(dd); // Mapper Class 값.
	} */
}
