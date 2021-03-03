package shin_student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shin_student.dao.ComboBoxDao;
import shin_student.util.JdbcUtil;

public class ComboBoxDaoImpl implements ComboBoxDao {
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

}
