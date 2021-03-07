package shin_student.ui.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import shin_student.dao.StdSearchDao;
import shin_student.dao.Impl.StdScoerDaoImpl;
import shin_student.dto.ScoPrint;
import shin_student.dto.Scoers;
import shin_student.ui.StudentUiMain;
import shin_student.ui.panel.score.LowPanel;
import shin_student.ui.panel.score.TopPanel;

public class StrScore extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JButton btnHome;
	private TopPanel pTop;
	private StdSearchDao dao = StdScoerDaoImpl.getInstance();
	private List<Scoers> scoList;
	private LowPanel pLow;
	private List<ScoPrint> scoPrintList;
	private StrScoreManag pScoManag;

	/**
	 * Create the frame.
	 */
	public StrScore() {
		pScoManag = new StrScoreManag();
		initialize();
		scoList = dao.selectByAll(pTop.getCodes(),false);
//		pLow.getTable().setColumnSelectionAllowed(true);
//		pLow.getTable().setRowSorter(new TableRowSorter(getTableModel()));
		pLow.getTable().setModel(getTableModel());

	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnHome = new JButton("Home");
		btnHome.addActionListener(this);
		btnHome.setBounds(12, 10, 121, 38);
		contentPane.add(btnHome);

		JLabel lblScoerManag = new JLabel("성적 관리");
		lblScoerManag.setFont(new Font("굴림", Font.PLAIN, 30));
		lblScoerManag.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoerManag.setBounds(12, 10, 685, 38);
		contentPane.add(lblScoerManag);

		pTop = new TopPanel();
		pTop.getBtnSearch().addActionListener(this);
		pTop.setBounds(12, 58, 685, 25);
		contentPane.add(pTop);

		pLow = new LowPanel();
		pLow.getTable().addMouseListener(this);
		pLow.setBounds(12, 93, 685, 287);
		contentPane.add(pLow);

		pScoManag.getBtnUpdate().addActionListener(this);
		pScoManag.getBtnClose().addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == pTop.getBtnSearch()) {
			do_pTopBtnSearch_actionPerformed(arg0);
		}

		if (arg0.getSource() == btnHome) {
			do_btnNewButton_actionPerformed(arg0);
		}
		if (arg0.getSource() == pScoManag.getBtnUpdate()) {
			do_btnUpdate_actionPerformed(arg0);
		}
		if (arg0.getSource() == pScoManag.getBtnClose()) {
			do_btnClose_actionPerformed(arg0);
		}
	}


	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		setVisible(false);
		StudentUiMain.frame.setVisible(true);
	}

	protected void do_pTopBtnSearch_actionPerformed(ActionEvent arg0) {
		scoList = dao.selectByAll(pTop.getCodes(),true);
		pLow.getTable().setModel(getTableModel());
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
		scoPrintList = new ArrayList<ScoPrint>();

		for (Scoers s : scoList) {
			if (s.getSubNo() == 1)
				scoPrintList.add(new ScoPrint(s.getNo(), s.getScoer(), 0, 0));

		}
		for (ScoPrint a : scoPrintList) {
			for (int i = 0; i < scoList.size(); i++) {
				if (a.getCode().equals(scoList.get(i).getNo())) {
					switch (scoList.get(i).getSubNo()) {

					case 2:
						a.setSub2(scoList.get(i).getScoer());
						break;
					case 3:
						a.setSub3(scoList.get(i).getScoer());
						break;

					}
				}
			}
		}

		Object[][] arrs = new Object[scoPrintList.size()][10];
		for (int i = 0; i < scoPrintList.size(); i++) {
			arrs[i][0] = scoPrintList.get(i).getCode().getDeptno().getDeptname();
			arrs[i][1] = scoPrintList.get(i).getCode().getName();
			arrs[i][2] = scoPrintList.get(i).getCode().getNo();
			
			arrs[i][3] = scoPrintList.get(i).getSub1();
			arrs[i][4] = scoPrintList.get(i).getSub2();
			arrs[i][5] = scoPrintList.get(i).getSub3();
			
			arrs[i][6] = scoPrintList.get(i).getTotal();
			arrs[i][7] = scoPrintList.get(i).getAvg();
			arrs[i][8] = scoPrintList.get(i).getRank();
			arrs[i][9] = scoPrintList.get(i).getRankSco();

		}
		return arrs;
	}

	private String[] getColumn() {
		return new String[] { "학과", "이름", "학번", "1과목", "2과목", "3과목", "총점", "평균", "평어", "평점" };
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == pLow.getTable()) {
			do_pLow_mouseClicked(arg0);
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	protected void do_pLow_mouseClicked(MouseEvent arg0) {
		pScoManag.setVisible(true);

		int res = (int) pLow.getTable().getModel().getValueAt(pLow.getTable().getSelectedRow(), 2);

		for (ScoPrint a : scoPrintList) {
			if (a.getCode().getNo() == res) {
				pScoManag.getpCenter().setValue(a);

			}

		}
		
	}

	protected void do_btnClose_actionPerformed(ActionEvent e) {
		pScoManag.setVisible(false);
	}

	protected void do_btnUpdate_actionPerformed(ActionEvent e) {
		StdScoerDaoImpl dao = StdScoerDaoImpl.getInstance();
		ScoPrint a = pScoManag.getpCenter().getValue();
		List<Scoers> sList = new ArrayList<Scoers>();
		sList.add(new Scoers(a.getCode(), 1, "1과목", a.getSub1()));
		sList.add(new Scoers(a.getCode(), 2, "2과목", a.getSub2()));
		sList.add(new Scoers(a.getCode(), 3, "3과목", a.getSub3()));

		for (Scoers s : sList) {
			dao.scoreUpdate(s);
		}

		scoList = dao.selectByAll(pTop.getCodes(),true);
		pLow.getTable().setModel(getTableModel());
		pScoManag.setVisible(false);

	}
}
