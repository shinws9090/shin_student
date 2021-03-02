package shin_student.ui.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shin_student.ui.panel.search.LeftPanel;
import shin_student.ui.panel.search.RightPanel;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class StrSearch extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public StrSearch() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("학생 조회");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(12, 10, 685, 66);
		contentPane.add(lblNewLabel);
		
		LeftPanel panel = new LeftPanel();
		panel.setBounds(12, 86, 295, 294);
		contentPane.add(panel);
		
		RightPanel panel_1 = new RightPanel();
		panel_1.setBounds(319, 86, 378, 294);
		contentPane.add(panel_1);
	}
}
