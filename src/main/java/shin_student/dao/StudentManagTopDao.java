package shin_student.dao;

import java.util.List;

import shin_student.dto.Attendings;
import shin_student.dto.Codes;
import shin_student.dto.Days;
import shin_student.dto.Department;

public interface StudentManagTopDao {
	// 주야구분 콤보박스 리스트
	String[] daysComdoListSelect();

	// 학과 콤보박스 리스트
	String[] deptComdoList();

	// 학적구분 콤보박스 리스트
	String[] attenComdoList();

	// 조회 버튼 기능
	List selectByAll(Days day, Department dept, Codes grade, Attendings attendings);

}
