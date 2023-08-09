package www.dream.bullitine_Board.model;

import www.dream.framework.model.MasterEntity;
import www.dream.bullitine_Board.party.model.PartyVO;

public class ReplyVO extends MasterEntity {
	/* id, writer_id, original_id, content, reg_dt, upt_dt, TITLE, read_cnt, like_cnt, dislike_cnt */
	 private PartyVO writer; // id 값 Entity <= reg_dt, upt_dt 값 MasterEntity 상속. id와 dt값을 위해. 게시물작성자
	 private String content; // 게시물내용
}
