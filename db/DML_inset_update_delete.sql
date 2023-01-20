/*
	DML
    C: insert / into 데이터 추가
    R: select / from 데이터 조회
    U: update / set 데이터 수정
    D: delete / from  데이터 삭제
*/

/*===================<< insert >>===================*/

select * from student_mst;
/*   `(물결)백쿼터를 사용한다.  */
insert into 
		`db_study2_explain`.`student_mst`
		(`student_id`, `student_name`)
values (4, '황인범');

select * from student_mst;

insert into student_mst
	(student_id,	 student_name,	 mentor_id)
values
	(5,				'백승호',			10),
	(6, '이승우', 10),
	(7, '이강인', 10),
	(8, '조규성', 10);
    
    select * from student_mst;
    
    select * from university_mst;
    
    insert into university_mst
		(university_id, university_name)
	values
		(4, '첼시'),
		(5, '토트넘'),
		(6, '바르셀로나'),
		(7, '레알'),
		(8, '유벤투스');
	
    select * from university_mst;
    select * from student_mst;
    
/*===================<< update >>===================*/
    
    select * from student_mst;
    
    update student_mst
    set
		student_name = '김문환',
		mentor_id = 2
	where 
		student_id = 4;
        
	select * from student_mst;
    select * from mentor_mst;
    
/*멘토 아이디가 10인 학생들의 멘토 아이디를 1로 바꿔라 */
    
    update student_mst
    set
		mentor_id = 1
	where
		mentor_id = 10;
        
	select * from student_mst;
    
    
/*===================<< update >>===================*/

delete
from
	student_mst
where
	student_id = 4
and student_name = '김문환'
and mentor_id = 2;

select * from student_mst;

select * from university_mst;

delete
from
	university_mst
where
	university_id = 4
and
	university_name = '첼시';
    
select * from university_mst;