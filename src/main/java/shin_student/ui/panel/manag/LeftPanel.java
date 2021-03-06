package shin_student.ui.panel.manag;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class LeftPanel extends JPanel {
	private JTable table;

	public JTable getTable() {
		return table;
	}

	public LeftPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		table = new JTable();
		table.setDoubleBuffered(true);
		table.setDragEnabled(true);
		table.setModel(new DefaultTableModel(null, new String[] { "학번", "성명", "학적 구분" }));
		
		scrollPane.setViewportView(table); 
	}



}
