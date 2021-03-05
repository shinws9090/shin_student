package shin_student.ui.panel.score.manag;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CenterPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public CenterPanel() {

		initialize();
	}
	private void initialize() {
		this.setBounds(12, 74, 315, 156);
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 14));
		
		JLabel lblNewLabel = new JLabel("학과 : ");
		add(lblNewLabel);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("1과목 : ");
		add(label);
		
		textField_1 = new JTextField();
		add(textField_1);
		textField_1.setColumns(6);
		
		JLabel label_1 = new JLabel("학년 : ");
		add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		add(textField_2);
		
		JLabel label_2 = new JLabel("2과목 : ");
		add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(6);
		add(textField_3);
		
		JLabel label_3 = new JLabel("학번 : ");
		add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		add(textField_4);
		
		JLabel label_4 = new JLabel("3과목 : ");
		add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(6);
		add(textField_5);
		
		JLabel label_5 = new JLabel("이름 : ");
		add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		add(textField_6);
		
		JLabel lblNewLabel_1 = new JLabel("                               ");
		add(lblNewLabel_1);
	}

}
