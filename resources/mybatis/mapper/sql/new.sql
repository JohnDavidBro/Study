INSERT INTO T_reply(id, h_tier, descrim, writer_id, bb_id, content, TITLE)
		VALUES ('p001', 0, 'Post', '000e', '0003', 'dog', 'i like');
		
INSERT INTO T_reply(id, h_tier, descrim, writer_id, bb_id, content, TITLE)
		VALUES ('p002', 0, 'Post', '000e', '0003', 'cat', 'i like');
		
INSERT INTO T_reply(id, h_tier, descrim, writer_id, bb_id, content, TITLE)
		VALUES ('p003', 0, 'Post', '000e', '0003', 'emptycat', 'byebye');
		
INSERT INTO T_reply(id, h_tier, descrim, writer_id, content)
		VALUES ('p001r000', 1, 'reply', '0003', 'puppyiscute');

INSERT INTO T_reply(id, h_tier, descrim, writer_id, content)
		VALUES ('p001r000rr00', 2, 'reply', '0003', 'puppyissoute');
		
INSERT INTO T_reply(id, h_tier, descrim, writer_id, content)
		VALUES ('p001r000rr01', 2, 'reply', '0003', 'puppyissoocute');

INSERT INTO T_reply(id, h_tier, descrim, writer_id, content)
		VALUES ('p001r001', 1, 'reply', '0003', 'newgame');


INSERT INTO T_Comp_Hierarchy(id, comp_Hierarchy, kind)
		VALUES ('r000', 'p001r000', 't2b');
		
		/** bb_id없는 버전 */
INSERT INTO T_reply(id, h_tier, descrim, writer_id, content, TITLE)
		VALUES ('p003', 0, 'Post', '000e', 'emptycat', 'byebye');
		
		
		
	/** 게시판에 모든 원글 목록 조회 */
	public List<PostVO> listAllPost(String boardId);
	
	select p.*, w.id w_id, w.descrim w_descrim, w.name w_name, w.gender w_gender, w.reg_dt w_reg_dt, w.upt_dt w_upt_dt
	 from T_reply p LEFT OUTER JOIN T_party w
	  	 ON p.writer_id = w.id
	where p.bb_id = '0003';
	
	/** 원글 상세, 첨부파일 목록, 댓글 목록, 대댓글 목록이 내부 변수에 채워짐 */
	public PostVO findById(String id);
	/* '_%' = 한글자가 있고 */
	select r.*, w.*
	  from T_reply r LEFT OUTER JOIN T_party w
	  	ON r.writer_id = w.id
	 where r.id like CONCAT('p001', '%');



	/** 게시판에 원글 달기  */
	public int createPost(PostVO post);

	INSERT INTO T_reply(id, h_tier, descrim, writer_id, content, bb_id, TITLE)
			VALUES (NEXT_PK('s_reply'), 0, 'Post', '000e', 'lion' '0003', 'i like');

	/** 원글에 댓글 달기, parents의 id의 연결된 id 만들기 */
	public int createReply(@Param("parent") ReplyVO parent, @Param("reply") ReplyVO reply);
	
	INSERT INTO T_reply(id, h_tier, descrim, writer_id, content)
			VALUES (CONCAT('p001', NEXT_PK('s_reply')), 0 + 1, 'reply', '0003', 'newgame 0001');
	   
	/** id like 검색으로 지웁니다. */
	public int deleteReply(String id);
	 delete T_reply
	  where id like CONCAT('p001', '%')
	   
	   
	INSERT INTO T_reply(id, h_tier, descrim, writer_id, content, TITLE)
			VALUES ('p001', 0, 'post', '0003', 'newgame 0001', 'lilk');
	   

	

	
	