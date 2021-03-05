package shin_student.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import shin_student.ui.frame.StrManagement;
import shin_student.ui.frame.StrScore;
import shin_student.ui.frame.StrSearch;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class StudentUiMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnManag;
	private JButton btnSearch;
	private JButton btnScoer;
	private JButton btnClose;
	public static StudentUiMain frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					frame = new StudentUiMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentUiMain() {
		setTitle("학생관리");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(30, 50, 30, 50));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 25));
		
		JLabel lblMain = new JLabel("학생 관리 프로그램");
		lblMain.setFont(new Font("굴림", Font.PLAIN, 30));
		lblMain.setForeground(Color.BLACK);
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMain);
		
		btnManag = new JButton("학적/학생 관리");
		btnManag.addActionListener(this);
		btnManag.setFont(new Font("굴림", Font.PLAIN, 20));
		contentPane.add(btnManag);
		
		btnSearch = new JButton("   학생 조회    ");
		btnSearch.addActionListener(this);
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 20));
		contentPane.add(btnSearch);
		
		btnScoer = new JButton("    성적 관리   ");
		btnScoer.addActionListener(this);
		btnScoer.setFont(new Font("굴림", Font.PLAIN, 20));
		contentPane.add(btnScoer);
		
		btnClose = new JButton("       종료       ");
		btnClose.addActionListener(this);
		btnClose.setFont(new Font("굴림", Font.PLAIN, 20));
		contentPane.add(btnClose);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClose) {
			do_btnClose_actionPerformed(e);
		}
		if (e.getSource() == btnScoer) {
			do_btnScoer_actionPerformed(e);
		}
		if (e.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(e);
		}
		if (e.getSource() == btnManag) {
			do_btnManag_actionPerformed(e);
		}
	}
	protected void do_btnManag_actionPerformed(ActionEvent e) {
		StrManagement frame = new StrManagement();
		frame.setVisible(true);
		StudentUiMain.frame.setVisible(false);
	}
	
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		StrSearch frame = new StrSearch();
		frame.setVisible(true);
		StudentUiMain.frame.setVisible(false);
	}
	protected void do_btnScoer_actionPerformed(ActionEvent e) {
		StrScore frame = new StrScore();
		frame.setVisible(true);
		StudentUiMain.frame.setVisible(false);
	}
	protected void do_btnClose_actionPerformed(ActionEvent e) {
		
	}
}
