package shin_student.ui.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shin_student.ui.StudentUiMain;
import shin_student.ui.panel.search.LeftPanel;
import shin_student.ui.panel.search.RightPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class StrSearch extends JFrame implements ActionListener {

	private JPanel contentPane;
	private LeftPanel panel;
	private RightPanel panel_1;

	

	/**
	 * Create the frame.
	 */
	public StrSearch() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		panel = new LeftPanel();
		panel.getBtnNewButton().addActionListener(this);
		panel.setBounds(12, 86, 295, 294);
		contentPane.add(panel);
		
		panel_1 = new RightPanel();
		panel_1.setBounds(319, 86, 378, 294);
		contentPane.add(panel_1);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == panel.getBtnNewButton()) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		setVisible(false);
		StudentUiMain.frame.setVisible(true);
	}
}
