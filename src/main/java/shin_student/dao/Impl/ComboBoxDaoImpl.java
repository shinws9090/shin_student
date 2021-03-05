package shin_student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shin_student.dao.ListSelectDao;
import shin_student.util.JdbcUtil;

public class ComboBoxDaoImpl implements ListSelectDao {
	private static final ComboBoxDaoImpl instance = new ComboBoxDaoImpl();

	private ComboBoxDaoImpl() {
	}

	public static ComboBoxDaoImpl getInstance() {
		return instance;
	}

	@Override
	public String[] ComboListSelect(String sql, String sql1) {
		String a = "select * from " + sql;
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(a);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				ArrayList<String> combolist = new ArrayList<String>();
				do {
					combolist.add(rs.getString(sql1));
				} while (rs.next());
				String[] list = new String[combolist.size()];
				for (int i = 0; i < combolist.size(); i++) {
					list[i] = combolist.get(i);
				}
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int ListSelectByNo(String sql, String sql1, String sqlNo, String select) {
		String a = "select * from " + sql;
		class NoStr {
			int no;
			String str;

			public NoStr(int no, String str) {
				this.no = no;
				this.str = str;
			}

		}

		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(a);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				int res = 0;
				ArrayList<NoStr> list = new ArrayList<NoStr>();
				do {
					NoStr n = new NoStr(rs.getInt(sqlNo), rs.getString(sql1));
					if (n.str.equals(select)) {
						res = n.no;
					}
				} while (rs.next());

				return res;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public String ListSelectByStr(String sql, String sql1, String sqlStr, String select) {
		String a = "select * from " + sql;

		class StrStr {
			String str1;
			String str2;

			public StrStr(String str1, String str2) {
				super();
				this.str1 = str1;
				this.str2 = str2;
			}

		}

		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(a);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				String res = "";
				ArrayList<StrStr> list = new ArrayList<StrStr>();
				do {
					StrStr n = new StrStr(rs.getString(sql1), rs.getString(sqlStr));
					if (n.str2.equals(select)) {
						res = n.str1;
					}
				} while (rs.next());

				return res;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

}
