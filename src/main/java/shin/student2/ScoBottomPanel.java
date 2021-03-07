package shin.student2;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

public class ScoBottomPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ScoBottomPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(new EmptyBorder(10, 10, 10, 10), "\uC131\uC801\uC870\uD68C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"학과", "이름", "학번", "1과목", "2과목", "3과목", "총점", "평균", "평어", "평점" 
			}
		));
		scrollPane.setViewportView(table);
	}

}
