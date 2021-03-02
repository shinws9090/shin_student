



select s.`no` ,s.name ,a.attending 
	from students s 
	join codes c  on s.no= c.no 
	join days d2  on d2.dayno = c.dayno 
	join attendings a on c.atdno = a.atdno
	join department d  on d.deptno = c.deptno 
	where d2.`day` = '주간' and d.deptname ='컴퓨터정보' and c.grade = 1 and a.attending = '재학';
	