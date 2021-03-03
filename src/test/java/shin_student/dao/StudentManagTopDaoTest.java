package shin_student.dao;

import java.util.List;

import org.junit.Test;

import shin_student.dao.Impl.StudentManagTopDaoImpl;
import shin_student.dto.Attendings;
import shin_student.dto.Days;
import shin_student.dto.Department;

public class StudentManagTopDaoTest {
	StudentManagTopDao dao = StudentManagTopDaoImpl.getInstance();

	@Test
	public void testSelectByAll() {
		
		List managList = dao.selectByAll(new Days ("주간"),new Department("컴퓨터정보") , 
				Integer.parseInt("1"), new Attendings("","재학"));
		managList.stream().forEach(System.out::println);
	}

}
