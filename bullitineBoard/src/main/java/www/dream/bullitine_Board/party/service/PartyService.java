package www.dream.bullitine_Board.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.bullitine_Board.mapper.PartyMapper;
import www.dream.bullitine_Board.party.model.PartyVO;

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
