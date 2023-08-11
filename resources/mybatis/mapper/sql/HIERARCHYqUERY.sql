create table T_H(
	id			INT primary key,
	hid			INT,
	name		varchar(255) not null
);

insert into T_H(id, hid, name)
	Values(0, null, '단군 할아버지');
insert into T_H(id, hid, name)
	Values(1, 0, '단군 아버지');
insert into T_H(id, hid, name)
	Values(2, 0, '단군 아들');
insert into T_H(id, hid, name)
	Values(3, 1, '단군 둘째 아들');
insert into T_H(id, hid, name)
	Values(4, 2, '아빠');
insert into T_H(id, hid, name)
	Values(5, 2, '엄마');
insert into T_H(id, hid, name)
	Values(6, 3, '나');

--'나'의 조상님들 다 찾아봐요.
select me.*
  from T_H me
 where me.name = '나'
 
 select me.*, p1.*
   from T_H me, T_H p1
  where me.name = '나'
 	and me.hid = p1.id;
 	
 select me.*, p1.*, p2.*
   from T_H me, T_H p1, T_H p2
  where me.name = '나'
 	and me.hid = p1.id
 	and p1.hid = p2.id;
 
 select me.*, p1.*, p2.*, p3.*
   from T_H me, T_H p1, T_H p2, T_H p3
  where me.name = '나'
 	and me.hid = p1.id
 	and p1.hid = p2.id
 	and p2.hid = p3.id;


-- 느려서 성능은 담보하기 어려움. 
 create table T_H(
 	id			INT primary key,
	hid			INT,
	name		varchar(255) not null
	
  --족보 다 보기
 WITH RECURSIVE prevResult AS(.
	SELECT id, name
	  FROM T_H
	 WHERE Id = 0
	
	 UNION ALL --위 prevResult를 다시 만들어 내는것. 그래서 ALL임.
	
	SELECT 
		child.id, child.name
		FROM T_H child --출발점이 단군할아버지(조상)이셔서.
		INNER JOIN prevResult
		ON prevResult.id = child.hid
)
SELECT *
FROM prevResult;
 
  --족보 다 보기(역순).
  WITH RECURSIVE prevResult AS(
	SELECT id, hid, name
	  FROM T_H
	 WHERE Id = 6
	
	 UNION ALL --위 prevResult를 다시 만들어 내는것. 그래서 ALL임.
	
	SELECT 
		parent.id, parent.hid, parent.name
		FROM T_H parent --출발점이 나(역순으로 족보보기).
		INNER JOIN prevResult
		ON prevResult.hid = parent.id
)
SELECT *
FROM prevResult;

