package shin_student.ui.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import shin_student.dao.StdSearchDao;
import shin_student.dao.Impl.StdSearchDaoImpl;
import shin_student.dto.Codes;
import shin_student.ui.StudentUiMain;
import shin_student.ui.panel.search.LeftPanel;
import shin_student.ui.panel.search.RightPanel;

public class StrSearch extends JFrame implements ActionListener {

	private JPanel contentPane;
	private LeftPanel pLeft;
	private RightPanel pRight;
	private StdSearchDao dao =StdSearchDaoImpl.getInstance();
	private List<Codes> seachList;
	

	/**
	 * Create the frame.
	 */
	public StrSearch() {
		initialize();
		seachList = dao.selectByAll(pLeft.getCodes(),false);
		pRight.getTable().setModel(getTableModel());
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
		pLeft.getCbSocial().addActionListener(this);
		pLeft.getCbAtd().addActionListener(this);
		pLeft.getCbGrade().addActionListener(this);
		pLeft.getCbMilt().addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pLeft.getBtnBtnHome()) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == pLeft.getCbSocial()) {
			do_cbGrade_actionPerformed(e);
		}
		if (e.getSource() == pLeft.getCbAtd()) {
			do_cbGrade_actionPerformed(e);
		}
		if (e.getSource() == pLeft.getCbGrade()) {
			do_cbGrade_actionPerformed(e);
		}
		if (e.getSource() == pLeft.getCbMilt()) {
			do_cbGrade_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		setVisible(false);
		StudentUiMain.frame.setVisible(true);
	}

	protected void do_cbGrade_actionPerformed(ActionEvent e) {
		seachList = dao.selectByAll(pLeft.getCodes(),true);
		pRight.getTable().setModel(getTableModel());
	}
	private DefaultTableModel getTableModel() {
		try {
			return new DefaultTableModel(getTableList(), getColumn());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "학년정보 입력 바랍니다.");
		} catch (NullPointerException e) {
			return new DefaultTableModel(null, getColumn());
		}
		return new DefaultTableModel(null, getColumn());
	}

	private Object[][] getTableList() {
		Object[][] arrs = new Object[seachList.size()][3];
		for (int i = 0; i < seachList.size(); i++) {
			arrs[i][0] = seachList.get(i).getNo();
			arrs[i][1] = seachList.get(i).getName();
			arrs[i][2] = seachList.get(i).getAtdno().getAttending();
		}
		return arrs;
	}

	private String[] getColumn() {
		return new String[] { "학번", "성명", "학적 구분" };
	}
}
