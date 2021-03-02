package shin_student.ui.panel.manag;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import shin_student.dao.Impl.StudentManagTopDaoImpl;
import shin_student.dto.Days;

public class TopPanel extends JPanel {
	private JTextField textField;

	public TopPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("주야구분");
		lblNewLabel.setBounds(12, 9, 48, 15);
		add(lblNewLabel);

		StudentManagTopDaoImpl dao = StudentManagTopDaoImpl.getInstance();
		JComboBox comboBox = new JComboBox(dao.daysComdoListSelect());
		comboBox.setBounds(72, 6, 60, 21);
		add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("학과");
		lblNewLabel_1.setBounds(156, 9, 24, 15);
		add(lblNewLabel_1);

		JComboBox comboBox_1 = new JComboBox(dao.deptComdoList());
		comboBox_1.setBounds(192, 6, 95, 21);
		add(comboBox_1);

		JLabel lblNewLabel_2 = new JLabel("학년");
		lblNewLabel_2.setBounds(299, 9, 24, 15);
		add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(335, 6, 58, 21);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("학적구분");
		lblNewLabel_3.setBounds(405, 9, 48, 15);
		add(lblNewLabel_3);

		JComboBox comboBox_2 = new JComboBox(dao.attenComdoList());
		comboBox_2.setBounds(465, 6, 60, 21);
		add(comboBox_2);

		JButton btnNewButton = new JButton("조회");
		btnNewButton.setBounds(537, 5, 57, 23);
		add(btnNewButton);
	}

	

}
