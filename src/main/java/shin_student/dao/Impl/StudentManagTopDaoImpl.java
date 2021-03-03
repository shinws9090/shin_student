package shin_student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shin_student.dao.StudentManagTopDao;
import shin_student.dto.Attendings;
import shin_student.dto.Codes;
import shin_student.dto.Days;
import shin_student.dto.Department;
import shin_student.dto.Militarys;
import shin_student.util.JdbcUtil;

public class StudentManagTopDaoImpl implements StudentManagTopDao {
	private static final StudentManagTopDaoImpl instance = new StudentManagTopDaoImpl();

	private StudentManagTopDaoImpl() {
	}

	public static StudentManagTopDaoImpl getInstance() {
		return instance;
	}

	@Override
	public ArrayList<Codes> selectByAll(Days day, Department dept, int grade, Attendings attendings) {
		String sql = "select c.`no`, c.name, c.birthday, c.social, c.dayno, d2.`day`, c.deptno, d.deptname, c.grade, c.atdno, a.attending, c.miltno, m.military \r\n"
				+ "	from codes c   \r\n" + "	join days d2  on d2.dayno = c.dayno \r\n"
				+ "	join attendings a on c.atdno = a.atdno\r\n" + "	join department d  on d.deptno = c.deptno \r\n"
				+ "	join militarys m on m.miltno = c.miltno \r\n"
				+ "	where d2.`day` = ? and d.deptname = ? and c.grade = ? and a.attending = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, day.getDay());
			pstmt.setString(2, dept.getDeptname());
			pstmt.setInt(3, grade);
			pstmt.setString(4, attendings.getAttending());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ArrayList<Codes> list = new ArrayList<Codes>();
					do {
						list.add(getCodes(rs));

					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private Codes getCodes(ResultSet rs) throws SQLException {
		int no = rs.getInt("no");
		String name = rs.getString("name");
		int birthday = rs.getInt("birthday");
		int social = rs.getInt("social");
		Days dayno = new Days(rs.getInt("dayno"));
		Department deptno = new Department("deptno");
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
