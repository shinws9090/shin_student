package shin_student.ui.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import shin_student.ui.StudentUiMain;
import shin_student.ui.panel.search.LeftPanel;
import shin_student.ui.panel.search.RightPanel;

public class StrSearch extends JFrame implements ActionListener {

	private JPanel contentPane;
	private LeftPanel pLeft;
	private RightPanel pRight;

	

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
		
		JLabel lblTitle = new JLabel("학생 조회");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 30));
		lblTitle.setBounds(12, 10, 685, 66);
		contentPane.add(lblTitle);
		
		pLeft = new LeftPanel();
		pLeft.getBtnBtnHome().addActionListener(this);
		pLeft.setBounds(12, 86, 295, 294);
		contentPane.add(pLeft);
		
		pRight = new RightPanel();
		pRight.setBounds(319, 86, 378, 294);
		contentPane.add(pRight);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pLeft.getBtnBtnHome()) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		setVisible(false);
		StudentUiMain.frame.setVisible(true);
	}
}
