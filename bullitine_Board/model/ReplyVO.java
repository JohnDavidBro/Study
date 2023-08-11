package www.dream.bullitine_Board.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import www.dream.bullitine_Board.party.model.PartyVO;
import www.dream.framework.model.MasterEntity;
import www.dream.framework.property.anno.TargetProperty;

@Getter
@Setter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ReplyVO extends MasterEntity {
	/**
	 * id, writer_id, original_id, content, reg_dt, upt_dt, TITLE, read_cnt,
	 * like_cnt, dislike_cnt
	 */
	@TargetProperty
	private PartyVO writer; // id 값 Entity <= reg_dt, upt_dt 값 MasterEntity 상속. id와 dt값을 위해. 게시물작성자
	@TargetProperty
	private String content; // 게시물내용
	private int hTier;
	private List<ReplyVO> listReply; // 대댓 구조 만들기는 어떻게?

	public String extractParentId() {
		String myId = super.getId();
		int len = myId.length();
		return myId.substring(0, len - ID_LENGTH);
	}

	public void appendReply(ReplyVO reply) {
		if (listReply == null) {
			listReply = new ArrayList<>();
			listReply.add(reply);
		}

	}

}
