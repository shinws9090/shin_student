package shin_student.ui.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shin_student.ui.panel.score.manag.CenterPanel;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class StrScoreManag extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public StrScoreManag() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 355, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("성적 수정");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(12, 10, 315, 54);
		contentPane.add(lblNewLabel);
		
		CenterPanel panel = new CenterPanel();
		panel.setBounds(12, 74, 315, 156);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("저장");
		btnNewButton.setBounds(63, 240, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(172, 240, 97, 23);
		contentPane.add(btnNewButton_1);
	}

}
