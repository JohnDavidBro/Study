package www.dream.bullitine_Board.model.req;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
	  /* 이건 테스트용으로 작성된 DTO입니다 */
	private String boardId;
	private String writerId; // 게시물 작성자
	private String title; // 제목
	private String content; // 내용
	
	// VO? DTO(data Transfer Object / 데이터 전송 객체) 이건 화면에서만 쓰이는 것이에요.
	private List<String> listTag;
	
}
