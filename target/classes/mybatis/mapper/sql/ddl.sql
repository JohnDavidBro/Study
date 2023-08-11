--ddl ? data definition language. 데이터 정의어
	create ~~~
	drop ~~~
	truncate ~~
--dml ? data manupulation language. 데이터 조작어, L Create Update Delete

select id, content, dis_cnt, ...
  from t_post
 where title like '감자전을 먹을 때 %'
   and like_cnt > 100
	  ...
insert into t_post(id, tile, content) values('XT0ayU', '감자전을 먹을 때 막걸리도 먹자', '음주는 적당히')

update t_post
   set content = '단골집에 녹두전 추천 할려고요.'
 where id='XT0ayU'
 
delete
  from t_post like '감자전을 먹을 때 %'
 where like_cnt > 100
--dcl ? data control language.

   pl_sql