package shin_student.ui.panel.score;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import shin_student.dao.ListSelectDao;
import shin_student.dao.Impl.ListSelectDaoImpl;
import shin_student.dto.Attendings;
import shin_student.dto.Codes;
import shin_student.dto.Days;
import shin_student.dto.Department;
import shin_student.dto.Militarys;
import shin_student.ui.frame.StrScoreManag;

public class TopPanel extends JPanel {
	private JComboBox cbDept;
	private JComboBox cbGrade;
	private JButton btnSearch;
	private ListSelectDao dao = ListSelectDaoImpl.getInstance();

	
	public JComboBox getCbDept() {
		return cbDept;
	}
	public JComboBox getCbGrade() {
		return cbGrade;
	}
	public JButton getBtnSearch() {
		return btnSearch;
	}
	/**
	 * Create the panel.
	 */
	public TopPanel() {
		initialize();
	}
	private void initialize() {
		setBounds(12, 58, 685, 25);
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 2, 2);
		setLayout(flowLayout);
		
		JLabel lbl = new JLabel("                         ");
		add(lbl);
		
		JLabel lblDept = new JLabel("학과");
		add(lblDept);
		
		cbDept = new JComboBox(dao.ComboListSelect("department", "deptname"));
		add(cbDept);
		
		JLabel lblGrade = new JLabel("학년");
		add(lblGrade);
		Stream<String> a1 = Arrays.stream(dao.ComboListSelect("codes", "grade"));
		cbGrade = new JComboBox(a1.distinct().sorted().toArray());
		add(cbGrade);
		
		btnSearch = new JButton("조회");
		add(btnSearch);
	}


	
	public Codes getCodes() {
		
		
		int i2 = dao.ListSelectByNo("department", "deptname", "deptno", (String)cbDept.getSelectedItem());
		
		Department deptno = new Department(i2);
		
		int grade = cbGrade.getSelectedIndex()+1;
		return new Codes(deptno, grade);

	}
}
