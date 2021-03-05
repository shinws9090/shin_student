package shin_student.ui.panel.search;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import shin_student.ui.StudentUiMain;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeftPanel extends JPanel {
	private JButton btnNewButton;

	public JButton getBtnNewButton() {
		return btnNewButton;
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
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 27, 271, 139);
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 20, 20));
		
		JLabel lblNewLabel = new JLabel("성       별");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JLabel label = new JLabel("학       년");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		
		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1);
		
		JLabel label_1 = new JLabel("학적사항");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_1);
		
		JComboBox comboBox_2 = new JComboBox();
		panel.add(comboBox_2);
		
		JLabel label_2 = new JLabel("병역사항");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_2);
		
		JComboBox comboBox_3 = new JComboBox();
		panel.add(comboBox_3);
		
		btnNewButton = new JButton("Home");
		btnNewButton.setBounds(45, 197, 193, 59);
		add(btnNewButton);
	}
	
}
