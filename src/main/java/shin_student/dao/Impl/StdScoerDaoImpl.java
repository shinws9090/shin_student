package shin_student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shin_student.dao.StdSearchDao;
import shin_student.dto.Codes;
import shin_student.dto.Rank;
import shin_student.dto.Scoers;
import shin_student.util.JdbcUtil;

public class StdScoerDaoImpl extends SelectByAll implements StdSearchDao {
	private static final StdScoerDaoImpl instance = new StdScoerDaoImpl();

	private StdScoerDaoImpl() {
	}

	public static StdScoerDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List selectByAll(Codes code) {
		String sql = "select c.`no`, name, c.deptno, s.subno ,u.subiect ,s.score ,deptname , grade\r\n"
				+ "	from codes c join scores s on c.no = s.`no` \r\n"
				+ "	join department d  on c.deptno = d.deptno\r\n" + "	join subiects u on u.subno =s.subno \r\n"
				+ "	where c.grade = ? and c.deptno =? ";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, code.getGrade());
			pstmt.setInt(2, code.getDeptno().getDeptno());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ArrayList<Scoers> list = new ArrayList<Scoers>();
					do {
						list.add(getScoer(rs, getCodes(rs)));

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

	public Rank selectRank(double a) {
		String sql = "select * from ranking \r\n" + "	where ? between lowsoc and hisoc ";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setDouble(1, a);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next())
					return new Rank(rs.getString("rank"), rs.getDouble("ranksoc"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public int scoreUpdate(Scoers s) {
		String sql = "update scores \r\n" + 
				"	set score = ?\r\n" + 
				"	where no = ? and subno =?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, s.getScoer());
			pstmt.setInt(2, s.getNo().getNo());
			pstmt.setInt(3, s.getSubNo());

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	public int scoreInaert(Codes c,int i) {
	
		String sql = "insert into scores values (?,?,0);";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, c.getNo());
			pstmt.setInt(2, i);
			
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	public int scoreDelete(Codes c) {
		
		String sql = "delete from scores where no = ?;";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, c.getNo());
			
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
