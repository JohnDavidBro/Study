package www.dream.bullitine_Board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import www.dream.bullitine_Board.model.BoardVO;
/** DB와 컨트롤러 사이 처리하는 DAO 역활 */
@Mapper //Container에 담기도록 지정
public interface BoardMapper {
	//STS에서 인터페이스는 빈 껍데기. => MyBatis가 XMl을 보고 자동으로 만들어줌.
	//LRCUD 순서로 함수들을 배치하여 빠르게 따라갈(추적성) 수 있도록 합니다.
	public List<BoardVO> listAll();
	public BoardVO findById(String id);
	/** public BoardVO findBydd(String dd); // 이런 식으로 가능 */
}
