package shin_student.ui.panel.manag;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import shin_student.dao.StudentManagTopDao;
import shin_student.dao.Impl.ListSelectDaoImpl;
import shin_student.dao.Impl.StudentManagTopDaoImpl;
import shin_student.dto.Attendings;
import shin_student.dto.Codes;
import shin_student.dto.Days;
import shin_student.dto.Department;

@SuppressWarnings("serial")
public class TopPanel extends JPanel {
	private DefaultTableModel tableModel;
	private JTextField tfGrade;
	private ListSelectDaoImpl dao = ListSelectDaoImpl.getInstance();
	private JButton btnSelect;
	private JLabel lblDays;
	private JComboBox cbDays;
	private JLabel lblDept;
	private JComboBox cbDept;
	private JLabel lblGrade;
	private JLabel lblAtd;
	private JComboBox cbAtd;
	private Object[][] arrs;

	public JLabel getLblDays() {
		return lblDays;
	}

	public ListSelectDaoImpl getDao() {
		return dao;
	}

	public JLabel getLblDept() {
		return lblDept;
	}

	public JLabel getLblGrade() {
		return lblGrade;
	}

	public JLabel getLblAtd() {
		return lblAtd;
	}

	public JTextField getTfGrade() {
		return tfGrade;
	}

	public JComboBox getCbDays() {
		return cbDays;
	}

	public JComboBox getCbDept() {
		return cbDept;
	}

	public JComboBox getCbAtd() {
		return cbAtd;
	}

	public Object[][] getArrs() {
		return arrs;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public JButton getBtnSelect() {
		return btnSelect;
	}

	public TopPanel() {

		initialize();
	}

	private void initialize() {

		lblDays = new JLabel("주야구분");
		add(lblDays);

		cbDays = new JComboBox(dao.ComboListSelect("days", "day"));
		add(cbDays);

		lblDept = new JLabel("학과");
		add(lblDept);

		cbDept = new JComboBox(dao.ComboListSelect("department", "deptname"));
		add(cbDept);

		lblGrade = new JLabel("학년");
		add(lblGrade);

		tfGrade = new JTextField();
		add(tfGrade);
		tfGrade.setColumns(10);

		lblAtd = new JLabel("학적구분");
		add(lblAtd);

		cbAtd = new JComboBox(dao.ComboListSelect("attendings", "attending"));
		add(cbAtd);

		btnSelect = new JButton("조회");
		add(btnSelect);
	}
	
	
	public List<Codes> selecte() {
		StudentManagTopDao dao =StudentManagTopDaoImpl.getInstance();
		Days day = new Days((String) cbDays.getSelectedItem());
		Department dept = new Department((String) cbDept.getSelectedItem());
		int grade = Integer.parseInt(tfGrade.getText());
		Attendings attendings = new Attendings("", (String) cbAtd.getSelectedItem());

		return dao.selectByAll(day, dept, grade, attendings);
	}
}
