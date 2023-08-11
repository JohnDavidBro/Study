create table T_I1(id varchar(4));
create table T_I2(id varchar(4));
create table T_I3(id varchar(4));
create table T_I4(id varchar(4));

--T_ID_SEED를 만들대, SEQ integer를 Primary key로 잡고
--SEED를 고정문자 테이블로 생성
create table T_ID_SEED(
	SEQ integer primary key,
	SEED char(4)
);


drop table T_ID_SEED;
--테이블지우기(데이터도 자동삭제)

SELECT *
FROM T_ID_SEED as a, T_ID_SEED as b;

--(카티션 프로젝트)

SELECT CONCAT(a.id, b.id) / 같은 열로 합침
FROM T_ID_SEED as a, T_ID_SEED as b; 


--3번째, 순서. 같은 열로 합쳐서 2개짜리로 만듬.
INSERT INTO T_I4(id)
SELECT CONCAT(a.id, b.id)
FROM T_I2 a, T_I2 b;
--위에 결과를 다시 입력함




INSERT INTO T_ID_SEED(id)
SELECT CONCAT(a.id, b.id)
FROM T_ID_SEED a, T_ID_SEED b;
where length(a.id) = 2
  and length(b.id) = 1
  ;






delete
FROM T_ID_SEED
where length(id) = 1;

delete
FROM T_ID_SEED
where length(id) <=2;



-- 앞에 primary key 로 번호 추가 // SQL 주석
alter table T_ID_SEED add column(num integer);
alter table T_ID_SEED drop column num;

rownum = 행번호

SELECT tid.*, @ROWNUM:=@ROWNUM+1 AS rowNum
FROM T_ID_SEED tid, (SELECT @ROWNUM:=0) AS R

--MariaDB에서 허용하는 업데이트 명령어
-- T_ID_SEED 테이블을 t1, 그 외 rowNum 을 t2라 하고
-- id, iid을 정해서 두개의 집합을 t1=id, t2=iid 로 연결해서
-- 그 나온 값을 t1.id, t2.iid에 할당한다.
UPDATE T_ID_SEED t1, (
	SELECT tid.id iid, @ROWNUM:=@ROWNUM+1 AS rowNum
	 FROM T_ID_SEED tid, (SELECT @ROWNUM:=0) AS R
	 ORDER BY iid ASC
	 )t2 SET t1.num = t2.rowNum 
WHERE t1.id = t2.iid;UPDATE T_ID_SEED t1, (
	SELECT tid.id iid, @ROWNUM:=@ROWNUM+1 AS rowNum
	 FROM T_ID_SEED tid, (SELECT @ROWNUM:=0) AS R
	 ORDER BY iid ASC
	 )t2 SET t1.num = t2.rowNum 
WHERE t1.id = t2.iid;

--오름차순 정렬
SELECT * FROM T_ID_SEED ORDER BY id ASC;



INSERT INTO INT_IDSEED(SEED, SEQ)
	SELECT tid.id iid, @ROWNUM:=@ROWNUM+1 AS rowNum
	 FROM T_I4 tid, (SELECT @ROWNUM:=0) AS R
	 ORDER BY iid ASC

alter table T_ID_SEED add primary key (num);
ALTER TABLE ex_table ADD PRIMARY KEY (id);

SELECT *
FROM t_idseed
where seq > 1600000;







WHERE num > 14000000;


SELECT num, count(*) dup_Cnt
FROM T_ID_SEED
group by num
having dup_Cnt >1;

where num;







INSERT INTO T_I1(id) VALUES ('a');
INSERT INTO T_I1(id) VALUES ('b');
INSERT INTO T_I1(id) VALUES ('c');
INSERT INTO T_I1(id) VALUES ('d');
INSERT INTO T_I1(id) VALUES ('e');
INSERT INTO T_I1(id) VALUES ('f');
INSERT INTO T_I1(id) VALUES ('g');
INSERT INTO T_I1(id) VALUES ('h');
INSERT INTO T_I1(id) VALUES ('i');
INSERT INTO T_I1(id) VALUES ('j');
INSERT INTO T_I1(id) VALUES ('k');
INSERT INTO T_I1(id) VALUES ('l');
INSERT INTO T_I1(id) VALUES ('n');
INSERT INTO T_I1(id) VALUES ('m');
INSERT INTO T_I1(id) VALUES ('o');
INSERT INTO T_I1(id) VALUES ('p');
INSERT INTO T_I1(id) VALUES ('q');
INSERT INTO T_I1(id) VALUES ('r');
INSERT INTO T_I1(id) VALUES ('s');
INSERT INTO T_I1(id) VALUES ('t');
INSERT INTO T_I1(id) VALUES ('u');
INSERT INTO T_I1(id) VALUES ('v');
INSERT INTO T_I1(id) VALUES ('w');
INSERT INTO T_I1(id) VALUES ('x');
INSERT INTO T_I1(id) VALUES ('y');
INSERT INTO T_I1(id) VALUES ('z');
INSERT INTO T_I1(id) VALUES ('0');
INSERT INTO T_I1(id) VALUES ('1');
INSERT INTO T_I1(id) VALUES ('2');
INSERT INTO T_I1(id) VALUES ('3');
INSERT INTO T_I1(id) VALUES ('4');
INSERT INTO T_I1(id) VALUES ('5');
INSERT INTO T_I1(id) VALUES ('6');
INSERT INTO T_I1(id) VALUES ('7');
INSERT INTO T_I1(id) VALUES ('8');
INSERT INTO T_I1(id) VALUES ('9');



