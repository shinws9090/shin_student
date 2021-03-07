package shin_student.ui.panel.score.manag;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import shin_student.dto.Codes;
import shin_student.dto.ScoPrint;

public class CenterPanel extends JPanel {
	private JTextField tfDept;
	private JTextField tfSub1;
	private JTextField tfGrade;
	private JTextField tfSub2;
	private JTextField tfNo;
	private JTextField tfSub3;
	private JTextField tfName;
	private Codes code;

	

	/**
	 * Create the panel.
	 */
	public CenterPanel() {

		initialize();
		tfDept.setEditable(false);
		tfGrade.setEditable(false);
		tfNo.setEditable(false);
		tfName.setEditable(false);
	}

	private void initialize() {
		this.setBounds(12, 74, 315, 156);
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 14));

		JLabel lblDept = new JLabel("학과 : ");
		add(lblDept);

		tfDept = new JTextField();
		add(tfDept);
		tfDept.setColumns(10);

		JLabel lblSub1 = new JLabel("1과목 : ");
		add(lblSub1);

		tfSub1 = new JTextField();
		add(tfSub1);
		tfSub1.setColumns(6);

		JLabel lblGrade = new JLabel("학년 : ");
		add(lblGrade);

		tfGrade = new JTextField();
		tfGrade.setColumns(10);
		add(tfGrade);

		JLabel lblSub2 = new JLabel("2과목 : ");
		add(lblSub2);

		tfSub2 = new JTextField();
		tfSub2.setColumns(6);
		add(tfSub2);

		JLabel lblNo = new JLabel("학번 : ");
		add(lblNo);

		tfNo = new JTextField();
		tfNo.setColumns(10);
		add(tfNo);

		JLabel lblSub3 = new JLabel("3과목 : ");
		add(lblSub3);

		tfSub3 = new JTextField();
		tfSub3.setColumns(6);
		add(tfSub3);

		JLabel lblName = new JLabel("이름 : ");
		add(lblName);

		tfName = new JTextField();
		tfName.setColumns(10);
		add(tfName);

		JLabel lbl = new JLabel("                               ");
		add(lbl);

	}

	public void setValue(ScoPrint t) {
		code = t.getCode();
		tfDept.setText(t.getCode().getDeptno().getDeptname());
		tfSub1.setText(t.getSub1() + "");
		tfGrade.setText(t.getCode().getGrade() + "");
		tfSub2.setText(t.getSub2() + "");
		tfNo.setText(t.getCode().getNo() + "");
		tfSub3.setText(t.getSub3() + "");
		tfName.setText(t.getCode().getName());
	}

	public ScoPrint getValue() {

		int sub1 = Integer.parseInt(tfSub1.getText());
		int sub2 = Integer.parseInt(tfSub2.getText());
		int sub3 = Integer.parseInt(tfSub3.getText());
		return new ScoPrint(code, sub1, sub2, sub3);
	}
}
