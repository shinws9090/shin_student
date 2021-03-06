package shin_student.ui.panel.search;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RightPanel extends JPanel {
	private JTable table;

	public JTable getTable() {
		return table;
	}
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
		scrollPane.setViewportView(table);
	}

}
