package shin_student.ui.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import shin_student.dao.StdSearchDao;
import shin_student.dao.Impl.StdScoerDaoImpl;
import shin_student.dto.ScoPrint;
import shin_student.dto.Scoers;
import shin_student.ui.StudentUiMain;
import shin_student.ui.panel.score.LowPanel;
import shin_student.ui.panel.score.TopPanel;

public class StrScore extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnHome;
	private TopPanel pTop;
	private StdSearchDao dao = StdScoerDaoImpl.getInstance();
	private List<Scoers> scoList;
	private LowPanel pLow;

	/**
	 * Create the frame.
	 */
	public StrScore() {
		initialize();
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
		pLow.setBounds(12, 93, 685, 287);
		contentPane.add(pLow);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == pTop.getBtnSearch()) {
			do_pTopBtnSearch_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnHome) {
			do_btnNewButton_actionPerformed(arg0);
		}
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		setVisible(false);
		StudentUiMain.frame.setVisible(true);
	}

	protected void do_pTopBtnSearch_actionPerformed(ActionEvent arg0) {
		scoList = dao.selectByAll(pTop.getCodes());
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
		List<ScoPrint> list = new ArrayList<ScoPrint>();
		System.out.println("104--"+scoList);
		
		
		for (Scoers s : scoList) {
			
			list.add(new ScoPrint(s.getNo(), 0, 0, 0));
			for (int i = 0; i < scoList.size()/3; i++) {
				System.out.println("temp2");
				if (s.getNo().equals(list.get(i).getCode())) {
					System.out.println("a  ");
					switch (s.getSubNo()) {
					case 1:
						list.get(i).setSub1(s.getScoer());
						break;
					case 2:
						list.get(i).setSub2(s.getScoer());
						break;
					case 3:
						list.get(i).setSub3(s.getScoer());
						break;

					}
				} else {
					System.out.println("new  ");
					switch (s.getSubNo()) {
					case 1:
						list.add(new ScoPrint(s.getNo(), s.getScoer(), 0, 0));
						break;
					case 2:
						list.add(new ScoPrint(s.getNo(), 0, s.getScoer(), 0));
						break;
					case 3:
						list.add(new ScoPrint(s.getNo(), 0, 0, s.getScoer()));
						break;

					}
				}
			}
		}
		System.out.println("142--"+list);
		Object[][] arrs = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			arrs[i][0] = list.get(i).getCode().getDeptno().getDeptname();
			arrs[i][1] = list.get(i).getCode().getName();
			arrs[i][2] = list.get(i).getCode().getNo();
			arrs[i][3] = list.get(i).getSub1();
			arrs[i][4] = list.get(i).getSub2();
			arrs[i][5] = list.get(i).getSub3();

		}
		return arrs;
	}

	private String[] getColumn() {
		return new String[] { "학과", "이름", "학번", "1과목", "2과목", "3과목"/* , "총점", "평균", "평어", "평점" */ };
	}
}
