package shin_student.dao;

import java.util.Arrays;

import org.junit.Test;

import shin_student.dao.Impl.ComboBoxDaoImpl;

public class ComboBoxDaoTest {
	ComboBoxDao dao = ComboBoxDaoImpl.getInstance();
	@Test
	public void testComboListSelect() {
		String[] list = dao.ComboListSelect("days", "day");
		System.out.println(Arrays.toString(list));
	}

}
