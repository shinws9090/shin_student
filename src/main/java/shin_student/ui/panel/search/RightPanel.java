package shin_student.ui.panel.search;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

public class RightPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public RightPanel() {
		initialize();
	}
	private void initialize() {
		this.setBounds(319, 86, 378, 294);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"학번", "성명", "학과"
			}
		));
		scrollPane.setViewportView(table);
	}

}
