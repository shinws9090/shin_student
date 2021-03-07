package shin.student2;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

public class StdLHBottomPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public StdLHBottomPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(0, 2, 20, 20));
		
		JLabel lblNewLabel = new JLabel("주야구분");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("학과");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("학년");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		add(comboBox_2);
		
		JLabel lblNewLabel_3 = new JLabel("학적구분");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_3);
		
		JComboBox comboBox_3 = new JComboBox();
		add(comboBox_3);
		
		JLabel lblNewLabel_4 = new JLabel("성별");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_4);
		
		JComboBox comboBox_4 = new JComboBox();
		add(comboBox_4);
		
		JLabel lblNewLabel_5 = new JLabel("병역사항");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_5);
		
		JComboBox comboBox_5 = new JComboBox();
		add(comboBox_5);

	}

}
