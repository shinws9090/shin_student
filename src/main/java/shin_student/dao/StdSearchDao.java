package shin_student.dao;

import java.util.List;

import shin_student.dto.Attendings;
import shin_student.dto.Codes;
import shin_student.dto.Militarys;

public interface StdSearchDao {

	List selectByAll(Codes code);
}
