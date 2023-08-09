package www.dream.bullitine_Board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import www.dream.bullitine_Board.model.PostVO;
import www.dream.bullitine_Board.model.ReplyVO;
/** DB와 컨트롤러 사이 처리하는 DAO 역활 */
@Mapper //Container에 담기도록 지정
public interface PostMapper {
	//STS에서 인터페이스는 빈 껍데기. => MyBatis가 XMl을 보고 자동으로 만들어줌.
	//LRCUD 순서로 함수들을 배치하여 빠르게 따라갈(추적성) 수 있도록 합니다.
	public List<PostVO> listAllPost(String boardId); //모든 POST LIST 를 간략하게 가져온다.
	//그 중에 한개 게시물 상세조회(게시물상세) 하면 그 안에 댓글이 보인다. (댓글은 상세조회가 없으니까.)
	//게시물 상세. 첨부파일 목록. 댓글 목록, 대댓글 목록.
	public PostVO findById(String id);
	
	/** affected row counts (영향받은 행 수) */
	public int createPost(PostVO post);
	public int createReply(@Param("parent") ReplyVO parent, @Param("reply") ReplyVO reply);
	
	public int updatePost(PostVO post);
	public int updateReply(ReplyVO reply);

	public int deleteReply(String id);
	/** 
	 * // 'tttt%' 개념. 
	 * tttt		  /1
	 * tttt0000   /2
	 * tttt000044 /3
	 * 
	 * */
}
