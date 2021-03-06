package shin_student.ui.panel.manag;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import shin_student.dao.Impl.ListSelectDaoImpl;
import shin_student.dto.Attendings;
import shin_student.dto.Codes;
import shin_student.dto.Days;
import shin_student.dto.Department;
import shin_student.dto.Militarys;

public class RightPanel extends JPanel {
	private JTextField tfDays;
	private JTextField tfDept;
	private JTextField tfGrade;
	private JTextField tfName;
	private JTextField tfNo;
	private JTextField tfBirthday;
	private JComboBox  cbSocial;
	private JComboBox  cbMilt;
	private JComboBox  cbAtd;
	private ListSelectDaoImpl selList = ListSelectDaoImpl.getInstance();

	public JComboBox getCbSocial() {
		return cbSocial;
	}

	public JComboBox getCbMilt() {
		return cbMilt;
	}

	public JComboBox getCbAtd() {
		return cbAtd;
	}

	public JTextField getTfDays() {
		return tfDays;
	}

	public JTextField getTfDept() {
		return tfDept;
	}

	public JTextField getTfGrade() {
		return tfGrade;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public JTextField getTfNo() {
		return tfNo;
	}

	public JTextField getTfBirthday() {
		return tfBirthday;
	}

	public RightPanel() {

		initialize();
	}

	private void initialize() {
		setBounds(20, 119, 340, 133);
		setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));

		JLabel lblDays = new JLabel("주야구분");
		lblDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblDays.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblDays);

		tfDays = new JTextField();
		tfDays.setHorizontalAlignment(SwingConstants.CENTER);
		tfDays.setColumns(6);
		add(tfDays);

		JLabel lblDept = new JLabel("학         과");
		add(lblDept);

		tfDept = new JTextField();
		tfDept.setHorizontalAlignment(SwingConstants.CENTER);
		tfDept.setColumns(6);
		add(tfDept);

		JLabel lblGrade = new JLabel("학         년");
		add(lblGrade);

		tfGrade = new JTextField();
		tfGrade.setHorizontalAlignment(SwingConstants.CENTER);
		tfGrade.setColumns(6);
		add(tfGrade);

		JLabel lblName = new JLabel("성         명");
		add(lblName);

		tfName = new JTextField();
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setColumns(6);
		add(tfName);

		JLabel lblNo = new JLabel("학         번");
		add(lblNo);

		tfNo = new JTextField();
		tfNo.setHorizontalAlignment(SwingConstants.CENTER);
		tfNo.setColumns(6);
		add(tfNo);

		JLabel lblAtd = new JLabel("학적구분");
		add(lblAtd);

		cbAtd = new JComboBox(selList.ComboListSelect("attendings", "attending"));
		add(cbAtd);

		JLabel lblBirthday = new JLabel("생년월일");
		add(lblBirthday);

		tfBirthday = new JTextField();
		tfBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		tfBirthday.setColumns(20);
		add(tfBirthday);

		JLabel lblSocial = new JLabel("성         별");
		add(lblSocial);
		String[] a = { "남", "여" };
		cbSocial = new JComboBox(a);
		add(cbSocial);

		JLabel lblMilt = new JLabel("병역사항");
		add(lblMilt);

		cbMilt = new JComboBox(selList.ComboListSelect("militarys", "military"));
		add(cbMilt);
	}

	public void setvalue(Codes a) {
		getTfName().setText(a.getName());
		getTfDays().setText(a.getDayno().getDay());
		getTfDept().setText(a.getDeptno().getDeptname());
		getTfGrade().setText(a.getGrade() + "");
		getTfNo().setText(a.getNo() + "");
		getTfBirthday().setText(a.getBirthday() + "");
		getCbAtd().setSelectedItem(a.getAtdno().getAttending());
		getCbMilt().setSelectedItem(a.getMiltno().getMilitary());

		// 이거안된다
		if (a.getSocial() == 1000000) {
			getCbSocial().setSelectedItem("남");
		} else {
			getCbSocial().setSelectedItem("여");
		}

	}

	public Codes getCodes() {
		System.out.println("aaaa");
		int no = Integer.parseInt(tfNo.getText());
		String name = tfName.getText();
		int birthday = Integer.parseInt(tfBirthday.getText());
		
		int social = 0;
		if (cbSocial.getSelectedItem() == "남") {
			social = 1000000;
		} else {
			social = 2000000; 
		}
		
		int i = selList.ListSelectByNo("days", "day", "dayno", tfDays.getText());
		int i2 = selList.ListSelectByNo("department", "deptname", "deptno", tfDept.getText());
		Days dayno = new Days(i);
		Department deptno = new Department(i2);
		
		int grade = Integer.parseInt(tfGrade.getText());
		String s = selList.ListSelectByStr("attendings", "atdno", "attending", (String)cbAtd.getSelectedItem());
		String s2 = selList.ListSelectByStr("militarys", "miltno", "military", (String)cbMilt.getSelectedItem());
		Attendings atdno = new Attendings(s);
		Militarys miltno = new Militarys(s2);
		return new Codes(no, name, birthday, social, dayno, deptno, grade, atdno, miltno);

	}
	
	public void clear() {
		
		tfDays.setText("");   
		tfDept.setText("");   
		tfGrade.setText("");   
		tfName.setText("");    
		tfNo.setText("");     
		tfBirthday.setText(""); 
		cbSocial.setSelectedItem("남");  
		cbMilt.setSelectedItem(1); 
		cbAtd.setSelectedItem(1);     
		
	}
}
