package shin_student.ui.frame;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import shin_student.ui.panel.manag.LeftPanel;
import shin_student.ui.panel.manag.RightPanel;
import shin_student.ui.panel.manag.TopPanel;

public class StrManagement extends JFrame {

	private JPanel contentPane;


	public StrManagement() {
		initialize();
	}
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("학적/학생 관리");
		lblNewLabel.setBounds(256, 20, 203, 41);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		
		TopPanel panel = new TopPanel();
		panel.setBounds(20, 61, 679, 33);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 119, 679, 266);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		LeftPanel panel_2 = new LeftPanel();
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		RightPanel panel_4 = new RightPanel();
		panel_3.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(25, 50, 25, 50));
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 10, 10));
		
		JButton btnNewButton = new JButton("추가");
		panel_5.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("저장");
		panel_5.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("삭제");
		panel_5.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Home");
		panel_5.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("▼ 학생 목록");
		lblNewLabel_1.setBounds(20, 101, 79, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("▼ 상새 정보");
		label.setBounds(359, 101, 100, 15);
		contentPane.add(label);
		
		TopPanel panel_6 = new TopPanel();
		panel_6.setBounds(20, 81, 687, -20);
		contentPane.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}
