package shin_student.ui.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import shin_student.ui.StudentUiMain;
import shin_student.ui.panel.score.LowPanel;
import shin_student.ui.panel.score.TopPanel;

public class StrScore extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;


	/**
	 * Create the frame.
	 */
	public StrScore() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(12, 10, 121, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("성적 관리");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 685, 38);
		contentPane.add(lblNewLabel);
		
		TopPanel panel = new TopPanel();
		panel.setBounds(12, 58, 685, 25);
		contentPane.add(panel);
		
		LowPanel panel_1 = new LowPanel();
		panel_1.setBounds(12, 93, 685, 287);
		contentPane.add(panel_1);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(arg0);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		setVisible(false);
		StudentUiMain.frame.setVisible(true);
	}
}
