package shin_student.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import shin_student.dto.Attendings;
import shin_student.dto.Codes;
import shin_student.dto.Days;
import shin_student.dto.Department;
import shin_student.dto.Militarys;
import shin_student.dto.Scoers;

public class SelectByAll {
	
	
	
	public Codes getCodes(ResultSet rs) throws SQLException {
		int no = rs.getInt("no");
		String name = rs.getString("name");
		Department deptno = new Department(rs.getInt("deptno"));
		deptno.setDeptname(rs.getString("deptname"));
		try {
			int birthday = rs.getInt("birthday");
			int social = rs.getInt("social");
			Days dayno = new Days(rs.getInt("dayno"));
			int grade = rs.getInt("grade");
			Attendings atdno = new Attendings(rs.getString("atdno"));
			Militarys miltno = new Militarys(rs.getString("miltno"));
			dayno.setDay(rs.getString("day"));
			atdno.setAttending(rs.getString("attending"));
			miltno.setMilitary(rs.getString("military"));
			
			return new Codes(no, name, birthday, social, dayno, deptno, grade, atdno, miltno);
		} catch (SQLException e) {

		}
		return new Codes(no, name, deptno);
	}
	
	
	public Scoers getScoer(ResultSet rs , Codes code) throws SQLException {
		Codes no = code ;      
		int subNo = rs.getInt("subno");    
		String subiect = rs.getString("subiect");
		int scoer = rs.getInt("score");     
		
		return new Scoers(no, subNo, subiect, scoer) ;
	}
	
	
	
}
