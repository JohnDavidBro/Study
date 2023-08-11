drop table T_Comp_Hierarchy;
drop table T_TGT_Tag;
drop table T_Tag;
drop table T_reply;
drop table T_party;
drop table T_bulitine_board;

/* comment 의 경우 "gender  boolean comment '0이면 여자, 1이면 남자'," 처럼 ,안에 작성  */

--T_bulintine board 만들기.
/* id, name, descrip, post_cnt */
create table T_bulitine_board(
	id			char(4) primary key,
	name		varchar(255) not null,
	descrip 	varchar(255),
	post_cnt	long default 0 comment '총 게시물 수'
);

insert into T_bulitine_board(id, name, descrip) value(NEXT_PK('S_bulitine_board'), '자유게시판', '자유로움')

--id, descrim, name, gender, reg_dt, upt_dt
create table T_party(
	id		char(4) primary key,
	descrim varchar(255) not null, /*'Manager', 'Member' */
	name	varchar(255) not null,
	gender  boolean comment '0이면 여자, 1이면 남자',
	reg_dt  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	upt_dt  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

	/* 연락처 유형 정의 */
create table T_TYPE(
   Code_type varchar(255) not null,
   code_val  varchar(255)
 );
 
insert into T_TYPE values('contect point type', 'cell phone number');
insert into T_TYPE values('contect point type', 'home address');

insert into T_TYPE values('rel target tag', 'Post');
insert into T_TYPE values('rel target tag', 'Party');

----------------------------
create table T_Contect_Point(
    Owner_id char(4),
	 Cp_Type varchar(255),
	 Cp_val  varchar(255),
	 primary key(Owner_id, Cp_Type) /* primary key는 항상 index로 적용된다. */
);

----------------
/* id, writer_id, original_id, content, reg_dt, upt_dt, TITLE, read_cnt, like_cnt, dislike_cnt */
create table T_reply(
  id		  char(4) primary key,
  writer_id	  char(4) not null,
  original_id char(4),
  content 	  TEXT(65000),
  reg_dt 	  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  upt_dt 	  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  
  /* 아래 속성은 게시글 일때만 활용되는 */
  bb_id		  char(4) not null,
  TITLE 	  varchar(255),
  read_cnt	  int,
  like_cnt	  int,
  dislike_cnt int
);
/* 태그 id, word, description(설명), df */
/* 통합검색체계 */
create table T_Tag(
  id		  char(4) primary key,
  word		  varchar(255),
  description TEXT(65000),
  df		  long comment 'document frequency, 문서빈도'
);

/* 헤쉬태그 tgt_name, tgt_id, tag_id, tf */
create table T_TGT_Tag(
  tgt_name	  varchar(255), /* Post, Party */
  tgt_id	  char(4),
  tag_id	  char(4),
  tf		  int,
  primary key(tgt_name, tag_id, tgt_id) /* 문서를 먼저 집어서 검색해서 primary key에 tag가 먼저 됨. */
);
/* Party */
/* 개인 관심사를 통해 검색해서 그 단어를 집어서 나와야 해당 포스트를 금방 찾을 수 있음. */
create index idx_tgt_tag on T_TGT_Tag(tgt_name, tgt_id, tag_id);

/* top2bottom, bottom2top */
create table T_Comp_Hierarchy(
	comp_Hierarchy	varchar(255) primary key,
	kind			char(3)	/* t2b, b2t */
);


/* 개인적관심사 party_id, tag_id, tf */
create table T_PersonalTag(
  party_id	  char(4),
  tag_id	  char(4),
  tf		  int
);

