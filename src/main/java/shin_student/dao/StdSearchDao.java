package shin_student.dao;

import java.util.List;

import shin_student.dto.Codes;

public interface StdSearchDao {
	// 조회 버튼 기능
	
	int update(Codes code2, Codes code);
	int insert(Codes code);
	int delete(Codes code);

	List selectByAll(Codes code, boolean i);


}
