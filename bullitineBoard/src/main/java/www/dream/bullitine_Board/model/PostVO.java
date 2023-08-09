package www.dream.bullitine_Board.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
/** lombok이 작동 안해서, 수동으로 Getter 값 부여. */
public class PostVO extends ReplyVO {
	  /* 아래 속성은 게시글 일때만 활용되는 */
	private BoardVO boardVO;
	private String title;
	private int readCnt;
	private int likeCnt;
	private int dislikeCnt;
}
