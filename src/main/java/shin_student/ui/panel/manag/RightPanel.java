package shin_student.ui.panel.manag;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import shin_student.dao.ComboBoxDao;
import shin_student.dao.Impl.ComboBoxDaoImpl;

import javax.swing.JComboBox;
import java.awt.Rectangle;

public class RightPanel extends JPanel {
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_15;
	


	public RightPanel() {

		initialize();
	}
	private void initialize() {
		setBounds(20, 119, 340, 133);
		setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
		
		JLabel label_8 = new JLabel("주야구분");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(label_8);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setColumns(6);
		add(textField_9);
		
		JLabel label_9 = new JLabel("학         과");
		add(label_9);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setColumns(6);
		add(textField_10);
		
		JLabel label_10 = new JLabel("학         년");
		add(label_10);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(6);
		add(textField_11);
		
		JLabel label_11 = new JLabel("성         명");
		add(label_11);
		
		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setColumns(6);
		add(textField_12);
		
		JLabel label_12 = new JLabel("학         번");
		add(label_12);
		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setColumns(6);
		add(textField_13);
		
		JLabel label_13 = new JLabel("학적구분");
		add(label_13);
		
		JComboBox comboBox = new JComboBox(ComboBoxDaoImpl.getInstance().ComboListSelect("attendings", "attending"));
		add(comboBox);
		
		JLabel label_14 = new JLabel("생년월일");
		add(label_14);
		
		textField_15 = new JTextField();
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setColumns(20);
		add(textField_15);
		
		JLabel label_15 = new JLabel("성         별");
		add(label_15);
		String[] a = {"남","여"};
		JComboBox comboBox_1 = new JComboBox(a);
		add(comboBox_1);
		
		JLabel label_16 = new JLabel("병역사항");
		add(label_16);
		
		JComboBox comboBox_2 = new JComboBox(ComboBoxDaoImpl.getInstance().ComboListSelect("militarys", "military"));
		add(comboBox_2);
	}

}
