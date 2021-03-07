package shin.student2;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ScoTopPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ScoTopPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(1, 0, 10, 10));
		
		JLabel lblNewLabel = new JLabel("학과");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("학년");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("등급");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		add(comboBox_2);
		
		JLabel lblNewLabel_3 = new JLabel("성명");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
	}

}
