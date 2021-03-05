package shin_student.ui.panel.search;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import shin_student.dao.Impl.ListSelectDaoImpl;

public class LeftPanel extends JPanel {
	private JButton btnHome;
	private ListSelectDaoImpl dao = ListSelectDaoImpl.getInstance();

	public JButton getBtnBtnHome() {
		return btnHome;
	}
	/**
	 * Create the panel.
	 */
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
		JComboBox cbSocial = new JComboBox(a);
		pTop.add(cbSocial);
		
		JLabel lblGrade = new JLabel("학       년");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pTop.add(lblGrade);
		Stream<String> a1 = Arrays.stream(dao.ComboListSelect("codes", "grade"));
		JComboBox cbGrade = new JComboBox(a1.distinct().toArray());
		pTop.add(cbGrade);
		
		JLabel lblAtd = new JLabel("학적사항");
		lblAtd.setHorizontalAlignment(SwingConstants.CENTER);
		pTop.add(lblAtd);
		
		JComboBox cbAtd = new JComboBox(dao.ComboListSelect("attendings", "attending"));
		pTop.add(cbAtd);
		
		JLabel lblMilt = new JLabel("병역사항");
		lblMilt.setHorizontalAlignment(SwingConstants.CENTER);
		pTop.add(lblMilt);
		
		JComboBox cbMilt = new JComboBox(dao.ComboListSelect("militarys", "military"));
		pTop.add(cbMilt);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(45, 197, 193, 59);
		add(btnHome);
	}
	
}
