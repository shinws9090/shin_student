package shin_student.ui.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import shin_student.dao.Impl.StdScoerDaoImpl;
import shin_student.dto.ScoPrint;
import shin_student.dto.Scoers;
import shin_student.ui.panel.score.manag.CenterPanel;

public class StrScoreManag extends JFrame {

	private JPanel contentPane;
	private CenterPanel pCenter;
	private JButton btnClose;
	private JButton btnUpdate;


	public JButton getBtnClose() {
		return btnClose;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	
	public CenterPanel getpCenter() {
		return pCenter;
	}
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
		
		JLabel lblTitle = new JLabel("성적 수정");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 30));
		lblTitle.setBounds(12, 10, 315, 54);
		contentPane.add(lblTitle);
		
		pCenter = new CenterPanel();
		pCenter.setBounds(12, 74, 315, 156);
		contentPane.add(pCenter);
		
		btnUpdate = new JButton("저장");
		btnUpdate.setBounds(63, 240, 97, 23);
		contentPane.add(btnUpdate);
		
		btnClose = new JButton("취소");
		btnClose.setBounds(172, 240, 97, 23);
		contentPane.add(btnClose);
	}

	
}
