S_bulitine_board

--ID 사전.
create table T_ID_SEED(
	SEQ integer primary key,
	SEED char(4)
);

create table T_SEQ(
	target_name varchar(255) primary key
	SEQ integer
);


--특정 테이블 레코드의 pk(primary key) 값을 char(4)체계로 채우기 위하여 해당 시퀀스로 부터 만들기.
insert into T_bulitine_board(id, name, descrip) value(NEXT_PK('S_bulitine_board'), '자유게시판', '자유로움')

REATE


--시퀀스 정보를 가지고 있는 Sequence테이블 만들기

CREATE TABLE tb_sequence (
		NAME VARCHAR(255) PRIMARY KEY,
		NUM INT NOT NULL DEFAULT 0
);



INSERT INTO tb_sequence (NAME) VALUES ('S_bulitine_board');


DELIMITER $$

CREATE FUNCTION 'fn_get_sequence'('p_seq_name' VARCHAR(255)) RETURNS char(4)
BEGIN
	DECLARE r_sequence_no INT;
	DECLARE r_sequence CHAR(4);
	
	
-- 결과적으로 Composite Pattern에 따라 객체 관계가 만들어 질 때 그 구성관계를 고성능 관리 할 수 있는 체계.
-- yyyy
-- yyyy0003
-- yyyy0003fsfs

-- tb_sequence 테이블의 sequence_no를 +1 합니다.
	UPDATE tb_sequence SET NUM = NUM + 1  WHERE NAME = p_seq_name;
--시퀀스 테이블에서 사용할 시퀀스이름에 시퀀스 번호를 조회합니다.
--조회한 값을 r_sequence_no 변수에 담아줍니다. (INTO 이용)
	SELECT NUM INTO r_sequence_no FROM tb_sequence WHERE NAME = p_seq_name;
-- CONCAT 함수를 이용하여 시퀀스이름 + 인덱스값을 추가하고 r_sequence 변수에 저장합니다.
-- LPAD 함수 왼쪽에 특정 문자를 원하는 자리수만큼 넣어줍니다. LPAD(문자, 자리수, 채울문자)
-- ex) LPAD('1', 4, '0') -> '0001'
	SELECT SEED INTO r_sequence FROM T_ID_SEED WHERE SEQ = r_sequence_no
-- r_sequence를 반환합니다.
	RETURN r_sequence;
END $$

DELIMITER;




CREATE FUNCTION fn_get_sequence(p_seq_name VARCHAR(255)) RETURNS char(4)
BEGIN
 	DECLARE r_sequence_no INT;
	RETURN NULL;
END;
$$


DELIMITER $$
CREATE Or REPLACE FUNCTION NEXT_PK(T_NAME VARCHAR(255)) RETURNS char(4)
BEGIN
	DECLARE unrecorded boolean; --기존 관리 하던 부분인지 확인 하는 부분.(관리하던 것인가, 아니면 신규인가)
	DECLARE r_sequence CHAR(4);
	
	select not exists (select num from tb_sequence where NAME = T_NAME) into unrecorded;
	
 	if (unrecorded) then
 		--새로운 것이면 새롭게 넣는다.(없다면, 이 이름으로(추가하는 이름) 하나 더 넣을거야. (신규생성))
	   INSERT INTO tb_sequence (NAME) VALUES (T_NAME);
	end if;
	
	UPDATE tb_sequence SET NUM = NUM + 1  WHERE NAME = T_NAME;
	--사전 순서의 문자열 찾기. 문자열로 변환하기.
	SELECT c.SEED INTO r_sequence
	  FROM tb_sequence s, T_ID_SEED c
	 WHERE s.NAME = T_NAME
	   and s.NUM = c.SEQ;
	
	
	RETURN r_sequence;
END;
$$

DELIMITER ;



SELECT NEXT_PK('S_post');

CREATE TABLE tb_sequence (
		NAME VARCHAR(255) PRIMARY KEY,
		NUM INT NOT NULL DEFAULT 0
);
INSERT INTO tb_sequence (NAME) VALUES ('S_bulitine_board');

select exists (select num from tb_sequence where NAME = 'S_bulitine_board');


