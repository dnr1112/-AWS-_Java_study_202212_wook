select
	*
from
	library_mst
where
/*	도서명 like '%나를%'		// like : %%로 쌓여있는 것만 조회, 나를% : 나를 로 시작하는거, %나를 : 나를 로 끝나는거 */
	저작자 in('채사장 지음', '최인절 지음');		/* like와 in은 같이 쓸 수 없음 */



/*===============<< select insert >>================*/
insert into author_mst
	(author_name)
select distinct
	저작자
from
	library_mst
order by
	저작자;
    
select * from author_mst;

insert into publisher_mst
	(publisher_name)
select distinct
	출판사
from
	library_mst
order by
	출판사;
    
select * from publisher_mst;

/*===============<< select update >>================*/
update 
	library_mst lm, author_mst am
set 
	lm.저작자 = am.author_id
where 
	am.author_name = lm.저작자;
                    
select * from library_mst
order by
	저작자;

update
	library_mst, publisher_mst
set
	출판사 = publisher_id
where
	출판사 = publisher_name;
    
select * from
	library_mst lm
left outer join
	author_mst am on(am.author_id = lm.저작자)
left outer join
	publisher_mst pm on(pm.publisher_id = lm.출판사);
    
/*====================================*/
/*
set profiling = 1;
set profiling_history_size = 30;
*/
select
	도서관명,
    도서명
from
	library_mst
where
	저작자 in (
			select author_id
			from author_mst
			where author_name like '김%'
            or author_name like '이%');
  /*  
show profiles; */

select
	도서관명,
	도서명
from
	library_mst lm
    left outer join author_mst am on(am.author_id = lm.저작자)
where
	am.author_name like '김%';