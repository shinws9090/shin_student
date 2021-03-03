



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