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
import shin_student.util.JdbcUtil;

public class StudentManagTopDaoImpl implements StudentManagTopDao {
	private static final StudentManagTopDaoImpl instance = new StudentManagTopDaoImpl();

	private StudentManagTopDaoImpl() {
	}

	public static StudentManagTopDaoImpl getInstance() {
		return instance;
	}

	@Override
	public String[] daysComdoListSelect() {
		String sql = "select * from Days";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				ArrayList<String> comdolist = new ArrayList<String>();
				do {
					comdolist.add(rs.getString("day"));
				} while (rs.next());
				String[] list = new String[comdolist.size()];
				for (int i = 0; i < comdolist.size(); i++) {
					list[i] = comdolist.get(i);
				}
				return list;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String[] deptComdoList() {
		String sql = "select * from department";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				ArrayList<String> comdolist = new ArrayList<String>();
				do {
					comdolist.add(rs.getString("deptname"));
				} while (rs.next());
				String[] list = new String[comdolist.size()];
				for (int i = 0; i < comdolist.size(); i++) {
					list[i] = comdolist.get(i);
				}
				return list;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String[] attenComdoList() {
		String sql = "select * from attendings";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				ArrayList<String> comdolist = new ArrayList<String>();
				do {
					comdolist.add(rs.getString("attending"));
				} while (rs.next());
				String[] list = new String[comdolist.size()];
				for (int i = 0; i < comdolist.size(); i++) {
					list[i] = comdolist.get(i);
				}
				return list;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List selectByAll(Days day, Department dept, Codes grade, Attendings attendings) {
		
		return null;
	}

}
