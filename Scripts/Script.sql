



select c.`no` ,c.name ,a.attending 
	from codes c   
	join days d2  on d2.dayno = c.dayno 
	join attendings a on c.atdno = a.atdno
	join department d  on d.deptno = c.deptno 
	where d2.`day` = '주간' and d.deptname ='컴퓨터정보' and c.grade = 1 and a.attending = '재학';

	

select * from days;


select c.`no`, c.name, c.birthday, c.social, c.dayno, d2.`day`, c.deptno, d.deptname, c.grade, c.atdno, a.attending, c.miltno, m.military 
	from codes c   
	join days d2  on d2.dayno = c.dayno 
	join attendings a on c.atdno = a.atdno
	join department d  on d.deptno = c.deptno 
	join militarys m on m.miltno = c.miltno 
	where d2.`day` = '주간' and d.deptname ='컴퓨터정보' and c.grade = 1 and a.attending = '재학';
	
select * from codes c2 ;

update codes 
	set no = 17010012 , name = '박태준', birthday = 971011, social = 1000000, dayno = 2, deptno = 2, grade = 2, atdno = 'h1b', miltno = 'y2a'
	where no = 17010012;
insert into codes values
	(99999999 , '박태준', 971011, 1000000, 2, 2, 2, 'h1b', 'y2a');
	
delete from codes where no = 99999999;


select * from attendings ;
atdno, attending;

select * from codes	
	where social = 1000000 and grade = 2 and atdno = 'h1a' and miltno ='y2a';

select * from ranking r ;


select c.`no`, name, c.deptno, s.subno ,u.subiect ,s.score ,deptname
	from codes c join scores s on c.no = s.`no` 
	join department d  on c.deptno = d.deptno
	join subiects u on u.subno =s.subno 
	where c.grade = 1 and c.deptno =2 ;
	

select * from scores s ,ranking r 
 where score > r.lowsoc and  score <r.hisoc ;

select * from scores s ;

select * from department d ;

select c.`no`, name, deptno, s.subno ,u.subiect ,s.score 
	from codes c join scores s on c.no = s.`no` 
	join subiects u on u.subno =s.subno 
	where grade = 1 and deptno =1 ;

select * from ranking 
	where 71.6 between lowsoc and hisoc ;

