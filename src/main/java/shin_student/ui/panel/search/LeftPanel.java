package shin_student.ui.panel.search;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import shin_student.dao.Impl.ListSelectDaoImpl;
import shin_student.dto.Attendings;
import shin_student.dto.Codes;
import shin_student.dto.Militarys;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeftPanel extends JPanel {
	private JButton btnHome;
	private ListSelectDaoImpl dao = ListSelectDaoImpl.getInstance();
	private JComboBox cbSocial;
	private JComboBox cbGrade;
	private JComboBox cbAtd;
	private JComboBox cbMilt;
	

	public JComboBox getCbSocial() {
		return cbSocial;
	}

	public JComboBox getCbGrade() {
		return cbGrade;
	}

	public JComboBox getCbAtd() {
		return cbAtd;
	}

	public JComboBox getCbMilt() {
		return cbMilt;
	}

	public JButton getBtnBtnHome() {
		return btnHome;
	}

	public LeftPanel() {
		initialize();
	}

	private void initialize() {
		this.setBounds(12, 86, 295, 294);
		setLayout(null);

		JPanel pTop = new JPanel();
		pTop.setBounds(12, 27, 271, 139);
		add(pTop);
		pTop.setLayout(new GridLayout(0, 2, 20, 20));

		JLabel lblSocial = new JLabel("성       별");
		lblSocial.setHorizontalAlignment(SwingConstants.CENTER);
		pTop.add(lblSocial);
		String[] a = { "남", "여" };
		cbSocial = new JComboBox(a);
		
		pTop.add(cbSocial);

		JLabel lblGrade = new JLabel("학       년");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pTop.add(lblGrade);
		Stream<String> a1 = Arrays.stream(dao.ComboListSelect("codes", "grade"));
		cbGrade = new JComboBox(a1.distinct().sorted().toArray());
		pTop.add(cbGrade);

		JLabel lblAtd = new JLabel("학적사항");
		lblAtd.setHorizontalAlignment(SwingConstants.CENTER);
		pTop.add(lblAtd);

		cbAtd = new JComboBox(dao.ComboListSelect("attendings", "attending"));
		pTop.add(cbAtd);

		JLabel lblMilt = new JLabel("병역사항");
		lblMilt.setHorizontalAlignment(SwingConstants.CENTER);
		pTop.add(lblMilt);

		cbMilt = new JComboBox(dao.ComboListSelect("militarys", "military"));
		pTop.add(cbMilt);

		btnHome = new JButton("Home");
		btnHome.setBounds(45, 197, 193, 59);
		add(btnHome);
		
		
	}

	public Codes getCodes() {
	
		
			
			int social = 0;
			if (cbSocial.getSelectedItem() == "남") {
				social = 1000000;
			} else {
				social = 2000000;
			}
			
		
			
			int grade = cbGrade.getSelectedIndex()+1;
			String s = dao.ListSelectByStr("attendings", "atdno", "attending", (String)cbAtd.getSelectedItem());
			String s2 = dao.ListSelectByStr("militarys", "miltno", "military", (String)cbMilt.getSelectedItem());
			Attendings atdno = new Attendings(s);
			Militarys miltno = new Militarys(s2);
		
		
		return new Codes(social,grade, atdno, miltno);
		
	}

	
	

	
	
}
