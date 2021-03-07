package shin_student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shin_student.dao.StdSearchDao;
import shin_student.dto.Codes;
import shin_student.util.JdbcUtil;

public class StdSearchDaoImpl  extends SelectByAll implements StdSearchDao {
	private static final StdSearchDaoImpl instance = new StdSearchDaoImpl();

	private StdSearchDaoImpl() {
	}

	public static StdSearchDaoImpl getInstance() {
		return instance;
	}
	@Override
	public List selectByAll(Codes code, boolean i) {
		String where = "";
		if(i==true) {
		where = "	where social = ? and grade = ? and c.atdno = ? and c.miltno =?";
		}
		String sql = "select c.`no`, c.name, c.birthday, c.social, c.dayno, d2.`day`, c.deptno, d.deptname, c.grade, c.atdno, a.attending, c.miltno, m.military \r\n"
				+ "	from codes c   \r\n" + "	join days d2  on d2.dayno = c.dayno \r\n"
				+ "	join attendings a on c.atdno = a.atdno\r\n" 
				+ "	join department d  on d.deptno = c.deptno \r\n"
				+ "	join militarys m on m.miltno = c.miltno \r\n"
				+ where;
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			if(i==true) {
			pstmt.setInt(1, code.getSocial());
			pstmt.setInt(2, code.getGrade());
			pstmt.setString(3, code.getAtdno().getAtdno());
			pstmt.setString(4, code.getMiltno().getMiltno());
			}
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

	@Override
	public int update(Codes code2, Codes code) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Codes code) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Codes code) {
		// TODO Auto-generated method stub
		return 0;
	}

}
