package shin_student.ui.frame;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import shin_student.dao.StudentManagTopDao;
import shin_student.dao.Impl.StudentManagTopDaoImpl;
import shin_student.dto.Attendings;
import shin_student.dto.Codes;
import shin_student.dto.Days;
import shin_student.dto.Department;
import shin_student.ui.panel.manag.LeftPanel;
import shin_student.ui.panel.manag.RightPanel;
import shin_student.ui.panel.manag.TopPanel;

public class StrManagement extends JFrame implements ActionListener{

	private JPanel contentPane;
	private TopPanel panel;
	private LeftPanel panel_2;
	private List<Codes> managList;


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
		
		panel = new TopPanel();
		panel.setBounds(20, 61, 679, 33);
		contentPane.add(panel);
//		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		panel.getBtnSelect().addActionListener(panel);
		panel.getBtnSelect().addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 119, 679, 266);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_2 = new LeftPanel();
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
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == panel.getBtnSelect()) {
			do_btnSelect_actionPerformed(arg0);
		}
	}
	protected void do_btnSelect_actionPerformed(ActionEvent arg0) {
		StudentManagTopDao dao = StudentManagTopDaoImpl.getInstance();
		try {

			Days day = new Days((String) panel.getCbDays().getSelectedItem());
			Department dept = new Department((String) panel.getCbDept().getSelectedItem());
			int grade = Integer.parseInt(panel.getTfGrade().getText());
			Attendings attendings = new Attendings("", (String) panel.getCbAtd().getSelectedItem());

			managList = dao.selectByAll(day, dept, grade, attendings);

			Object[][] arrs = new Object[managList.size()][3];
			for (int i = 0; i < managList.size(); i++) {
				arrs[i][0] = managList.get(i).getNo();
				arrs[i][1] = managList.get(i).getName();
				arrs[i][2] = managList.get(i).getAtdno().getAttending();
			}
//			tableModel = new DefaultTableModel(arrs, new String[] { "학번", "성명", "학적 구분" });
//			LeftPanel.table.setModel(new DefaultTableModel(arr, new String[] { "학번", "성명", "학적 구분" }));
			panel_2.getTable().setModel(new DefaultTableModel(arrs, new String[] { "학번", "성명", "학적 구분" }));

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "학년정보 입력 바랍니다.");
		}catch (NullPointerException e) {
			panel_2.getTable().setModel(new DefaultTableModel(null, new String[] { "학번", "성명", "학적 구분" }));
		}
		

		
	}
}
