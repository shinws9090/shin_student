package shin_student.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import shin_student.dao.Impl.ComboBoxDaoImpl;

public class ListSelectDaoTest {

	@Test
	public void testComboListSelect() {
		fail("Not yet implemented");
	}

	@Test
	public void testListSelectByStr() {
		int a = ComboBoxDaoImpl.getInstance().ListSelectByNo("days", "day", "dayno", "주간");
		System.out.println(a);
	}

	@Test
	public void testListSelectByNo() {
		String s = ComboBoxDaoImpl.getInstance().ListSelectByStr("attendings", "atdno", "attending", "재학");
		System.out.println(s);
	}

}
