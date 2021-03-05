package shin_student.ui.panel.score;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import shin_student.ui.frame.StrScoreManag;

public class TopPanel extends JPanel implements ActionListener {
	private JButton btnNewButton;

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
		
		btnNewButton = new JButton("성적 수정");
		btnNewButton.addActionListener(this);
		add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("                         ");
		add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("학과");
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("학년");
		add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("조회");
		add(btnNewButton_1);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(arg0);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		StrScoreManag frame = new StrScoreManag();
		frame.setVisible(true);
	}
}
