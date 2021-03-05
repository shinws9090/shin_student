package shin_student.dao;

public interface ListSelectDao {
	String[] ComboListSelect(String sql,String sql1);
	int ListSelectByNo(String sql, String sql1, String sqlNo, String obj);
	String ListSelectByStr(String sql, String sql1, String sqlStr, String select);
}
