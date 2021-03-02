package shin_student.ui.panel.manag;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LeftPanel extends JPanel {
	private JTable table;


	public LeftPanel() {
		
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"학번", "성명", "학적 구분"
			}
		));
		scrollPane.setViewportView(table);
	}

}
