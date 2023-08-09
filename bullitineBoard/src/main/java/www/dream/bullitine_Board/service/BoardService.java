package www.dream.bullitine_Board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.bullitine_Board.mapper.BoardMapper;
import www.dream.bullitine_Board.model.BoardVO;

//Container에 담기도록 지정
@Service //아키텍쳐 표준
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	public List<BoardVO> listAll() {
		return boardMapper.listAll();
		
	}
	public BoardVO findById(String id) {
		return boardMapper.findById(id);
	}
	/** public BoardVO findBydd(String dd) { // 이런 식으로 설정 가능
		return boardMapper.findBydd(dd); // Mapper Class 값.
	} */
}
