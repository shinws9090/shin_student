package shin_student.ui.panel.manag;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import shin_student.dao.StudentManagTopDao;
import shin_student.dao.Impl.ComboBoxDaoImpl;
import shin_student.dao.Impl.StudentManagTopDaoImpl;
import shin_student.dto.Attendings;
import shin_student.dto.Codes;
import shin_student.dto.Days;
import shin_student.dto.Department;

@SuppressWarnings("serial")
public class TopPanel extends JPanel implements ActionListener {
	DefaultTableModel tableModel;
	private JTextField tfGrade;
	private ComboBoxDaoImpl dao = ComboBoxDaoImpl.getInstance();
	private JButton btnSelect;
	private JLabel lblDays;
	private JComboBox cbDays;
	private JLabel lblDept;
	private JComboBox cbDept;
	private JLabel lblGrade;
	private JLabel lblAtd;
	private JComboBox cbAtd;
	private List<Codes> managList;

	public TopPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(null);

		lblDays = new JLabel("주야구분");
		lblDays.setBounds(12, 9, 48, 15);
		add(lblDays);

		cbDays = new JComboBox(dao.ComboListSelect("days", "day"));
		cbDays.setBounds(72, 6, 60, 21);
		add(cbDays);

		lblDept = new JLabel("학과");
		lblDept.setBounds(156, 9, 24, 15);
		add(lblDept);

		cbDept = new JComboBox(dao.ComboListSelect("department", "deptname"));
		cbDept.setBounds(192, 6, 95, 21);
		add(cbDept);

		lblGrade = new JLabel("학년");
		lblGrade.setBounds(299, 9, 24, 15);
		add(lblGrade);

		tfGrade = new JTextField();
		tfGrade.setBounds(335, 6, 58, 21);
		add(tfGrade);
		tfGrade.setColumns(10);

		lblAtd = new JLabel("학적구분");
		lblAtd.setBounds(405, 9, 48, 15);
		add(lblAtd);

		cbAtd = new JComboBox(dao.ComboListSelect("attendings", "attending"));
		cbAtd.setBounds(465, 6, 60, 21);
		add(cbAtd);

		btnSelect = new JButton("조회");
		btnSelect.addActionListener(this);
		btnSelect.setBounds(537, 5, 57, 23);
		add(btnSelect);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSelect) {
			do_btnSelect_actionPerformed(arg0);
		}
	}

	@SuppressWarnings("unchecked")
	protected void do_btnSelect_actionPerformed(ActionEvent arg0) {
		StudentManagTopDao dao = StudentManagTopDaoImpl.getInstance();
		try {
			
			
			Days day = new Days((String) cbDays.getSelectedItem());
			Department dept = new Department((String) cbDept.getSelectedItem());
			int grade = Integer.parseInt(tfGrade.getText());
			Attendings attendings = new Attendings("",(String) cbAtd.getSelectedItem());
			
			managList = dao.selectByAll(day, dept, grade, attendings);
//			LeftPanel.table.setModel(LeftPanel.table.getModel());
			Object[][] arr = new Object[managList.size()][3];
			tableModel = new DefaultTableModel(arr, new String[] { "학번", "성명", "학적 구분" });
			
			for(Codes a : managList) {
				String[] data = {a.getNo()+"",a.getName(),a.getAtdno().getAttending()};
				tableModel.addRow(data);
			}
//			for (int i = 0; i < managList.size(); i++) {
//				arr[i][0] = managList.get(i).getNo();
//				arr[i][1] = managList.get(i).getName();
//				arr[i][2] = managList.get(i).getAtdno().getAttending();}
			LeftPanel leftPanel = new LeftPanel();
			
			
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "학년정보 입력 바랍니다.");
		}
		
		
	}

}
