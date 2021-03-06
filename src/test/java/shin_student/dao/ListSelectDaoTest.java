package shin_student.dao;

import static org.junit.Assert.fail;

import org.junit.Test;

import shin_student.dao.Impl.ListSelectDaoImpl;

public class ListSelectDaoTest {



	@Test
	public void testListSelectByStr() {
		int a = ListSelectDaoImpl.getInstance().ListSelectByNo("days", "day", "dayno", "주간");
		System.out.println(a);
	}

	@Test
	public void testListSelectByNo() {
		String s = ListSelectDaoImpl.getInstance().ListSelectByStr("attendings", "atdno", "attending", "재학");
		System.out.println(s);
	}

}
