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
}
