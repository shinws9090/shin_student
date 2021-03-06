package shin_student.dao.Impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import shin_student.dao.StdSearchDao;
import shin_student.dto.Codes;
import shin_student.dto.Department;

public class StdScoerDaoImplTest {
	
	@Test
	public void testSelectByAll() {
		StdSearchDao dao = StdScoerDaoImpl.getInstance();
		List s = dao.selectByAll(new Codes(new Department(2), 1) );
		Assert.assertNotNull(s);
		System.out.println(s);
	}

}
