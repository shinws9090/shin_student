package shin_student.ui.frame;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import shin_student.dao.StudentManagTopDao;
import shin_student.dao.Impl.StdScoerDaoImpl;
import shin_student.dao.Impl.StudentManagTopDaoImpl;
import shin_student.dto.Codes;
import shin_student.ui.StudentUiMain;
import shin_student.ui.panel.manag.LeftPanel;
import shin_student.ui.panel.manag.RightPanel;
import shin_student.ui.panel.manag.TopPanel;

public class StrManagement extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private TopPanel pTop;
	private LeftPanel pLeft;
	private List<Codes> managList;
	private RightPanel pRTop;
	private StudentManagTopDao dao = StudentManagTopDaoImpl.getInstance();
	private JButton btnUpdate;
	private Object res;
	private Codes selecStd;
	private DefaultTableModel tableModel;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnBack;
	private StdScoerDaoImpl scoDao = StdScoerDaoImpl.getInstance();

	public StrManagement() {
		initialize();
	}

	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("학적/학생 관리");
		lblTitle.setBounds(256, 20, 203, 41);
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 30));

		pTop = new TopPanel();
		pTop.getBtnSelect().addActionListener(this);
		pTop.setBounds(20, 58, 679, 33);
		contentPane.add(pTop);

		JPanel pBottom = new JPanel();
		pBottom.setBounds(20, 119, 679, 266);
		contentPane.add(pBottom);
		pBottom.setLayout(new GridLayout(0, 2, 0, 0));

		pLeft = new LeftPanel();
		pLeft.getTable().addMouseListener(this);
		pBottom.add(pLeft);

		JPanel pRigth = new JPanel();
		pBottom.add(pRigth);
		pRigth.setLayout(new GridLayout(0, 1, 0, 0));

		pRTop = new RightPanel();
		pRigth.add(pRTop);

		JPanel pTBottom = new JPanel();
		pTBottom.setBorder(new EmptyBorder(25, 50, 25, 50));
		pRigth.add(pTBottom);
		pTBottom.setLayout(new GridLayout(0, 2, 10, 10));

		btnInsert = new JButton("추가");
		btnInsert.addActionListener(this);
		pTBottom.add(btnInsert);

		btnUpdate = new JButton("저장");
		btnUpdate.addActionListener(this);
		pTBottom.add(btnUpdate);

		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		pTBottom.add(btnDelete);

		btnBack = new JButton("Home");
		btnBack.addActionListener(this);
		pTBottom.add(btnBack);

		JLabel lblNewLabel_1 = new JLabel("▼ 학생 목록");
		lblNewLabel_1.setBounds(20, 101, 79, 15);
		contentPane.add(lblNewLabel_1);

		JLabel label = new JLabel("▼ 상새 정보");
		label.setBounds(359, 101, 100, 15);
		contentPane.add(label);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBack) {
			do_btnBack_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnDelete) {
			do_btnDelete_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnInsert) {
			do_btnInsert_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnUpdate) {
			do_btnUpdate_actionPerformed(arg0);
		}
		if (arg0.getSource() == pTop.getBtnSelect()) {
			do_btnSelect_actionPerformed(arg0);
		}
	}

	protected void do_btnSelect_actionPerformed(ActionEvent arg0) {

		tableModel = getTableModel();
		pLeft.getTable().setModel(tableModel);

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
		managList = pTop.selecte();
		Object[][] arrs = new Object[managList.size()][3];
		for (int i = 0; i < managList.size(); i++) {
			arrs[i][0] = managList.get(i).getNo();
			arrs[i][1] = managList.get(i).getName();
			arrs[i][2] = managList.get(i).getAtdno().getAttending();
		}
		return arrs;
	}

	private String[] getColumn() {
		return new String[] { "학번", "성명", "학적 구분" };
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == pLeft.getTable()) {
			do_table_mouseClicked(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void do_table_mouseClicked(MouseEvent e) {
		res = pLeft.getTable().getModel().getValueAt(pLeft.getTable().getSelectedRow(), 0);

		for (Codes a : managList) {
			if (a.getNo() == (Integer) res) {
//					System.out.println(a);
				selecStd = a;
				pRTop.setvalue(a);

			}

		}

	}

	protected void do_btnUpdate_actionPerformed(ActionEvent arg0) {
		dao.update(new Codes((Integer) res), pRTop.getCodes());
		tableModel = getTableModel();
		pLeft.getTable().setModel(tableModel);
		pRTop.clear();
	}

	protected void do_btnInsert_actionPerformed(ActionEvent arg0) {
		dao.insert(pRTop.getCodes());

		for (int i = 1; i <= 3; i++) {
			scoDao.scoreInaert(pRTop.getCodes(), i);
		}
		tableModel = getTableModel();
		pLeft.getTable().setModel(tableModel);
		pRTop.clear();
	}

	protected void do_btnDelete_actionPerformed(ActionEvent arg0) {
		scoDao.scoreDelete(pRTop.getCodes());
		dao.delete(selecStd);
		tableModel = getTableModel();
		pLeft.getTable().setModel(tableModel);
		pRTop.clear();

	}

	protected void do_btnBack_actionPerformed(ActionEvent arg0) {
		setVisible(false);
		StudentUiMain.frame.setVisible(true);
	}
}
