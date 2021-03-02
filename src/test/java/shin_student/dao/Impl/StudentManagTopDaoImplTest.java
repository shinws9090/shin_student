package shin_student.dao.Impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class StudentManagTopDaoImplTest {
	StudentManagTopDaoImpl dao = StudentManagTopDaoImpl.getInstance();

	@Test
	public void testDaysComdoListSelect() {

		String[] list = dao.daysComdoListSelect();

		System.out.println(Arrays.toString(list));

	}

	@Test
	public void testDeptComdoList() {
		String[] list = dao.deptComdoList();

		System.out.println(Arrays.toString(list));
	}

	@Test
	public void testAttenComdoList() {
		String[] list = dao.attenComdoList();

		System.out.println(Arrays.toString(list));
	}

	@Test
	public void testSelectByAll() {
		fail("Not yet implemented");
	}

}
