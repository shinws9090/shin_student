package shin_student.dao;

import java.util.List;

import shin_student.dto.Attendings;
import shin_student.dto.Codes;
import shin_student.dto.Days;
import shin_student.dto.Department;

public interface StudentManagTopDao {
	// 조회 버튼 기능
	List selectByAll(Days day, Department dept, int grade, Attendings attendings);

}
