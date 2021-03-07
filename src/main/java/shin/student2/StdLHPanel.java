package shin.student2;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class StdLHPanel extends JPanel implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton_1;
	private StdLHBottomPanel panel_1;

	/**
	 * Create the panel.
	 */
	public StdLHPanel() {
		setBorder(new TitledBorder(null, "\uD559\uC0DD\uC870\uD68C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBounds(100, 100, 263, 690);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 10, 10));
		
		JLabel lblNewLabel = new JLabel("성      명");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("학      번");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		JButton btnNewButton = new JButton("검색");
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(30, 20, 0, 20));
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnNewButton_1 = new JButton("상새조회▼");
		btnNewButton_1.addActionListener(this);
		panel_3.add(btnNewButton_1);
		
		panel_1 = new StdLHBottomPanel();
		panel_1.setVisible(false);
		add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(10, 30, 10, 30));
		add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton_2 = new JButton("추가");
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("삭제");
		panel_4.add(btnNewButton_3);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			btnNewButton_1ActionPerformed(e);
		}
	}
	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		if(panel_1.isVisible()) {
			panel_1.setVisible(false);
		}else {
			panel_1.setVisible(true);
			
		}
	}
}
