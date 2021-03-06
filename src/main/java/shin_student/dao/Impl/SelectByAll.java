package shin_student.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import shin_student.dto.Attendings;
import shin_student.dto.Codes;
import shin_student.dto.Days;
import shin_student.dto.Department;
import shin_student.dto.Militarys;

public class SelectByAll {
	
	
	
	public Codes getCodes(ResultSet rs) throws SQLException {
		int no = rs.getInt("no");
		String name = rs.getString("name");
		int birthday = rs.getInt("birthday");
		int social = rs.getInt("social");
		Days dayno = new Days(rs.getInt("dayno"));
		Department deptno = new Department(rs.getInt("deptno"));
		int grade = rs.getInt("grade");
		Attendings atdno = new Attendings(rs.getString("atdno"));
		Militarys miltno = new Militarys(rs.getString("miltno"));
		try {
			dayno.setDay(rs.getString("day"));
			deptno.setDeptname(rs.getString("deptname"));
			atdno.setAttending(rs.getString("attending"));
			miltno.setMilitary(rs.getString("military"));
		} catch (SQLException e) {

		}
		
		return new Codes(no, name, birthday, social, dayno, deptno, grade, atdno, miltno);
	}
}
