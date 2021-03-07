package shin_student.ui.panel.score;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class LowPanel extends JPanel {
	private JTable table;

	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	
	
	public LowPanel() {
		initialize();
	}
	private void initialize() {
		setBounds(12, 93, 685, 287);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		
		scrollPane.setViewportView(table);
	}

}
