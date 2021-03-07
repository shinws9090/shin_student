package shin.student2;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

public class StdRHPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public StdRHPanel() {
		setBorder(new TitledBorder(null, "\uD559\uC0DD\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"성명", "학번", "재학","학적"
			}
		));
		scrollPane.setViewportView(table);

	}

}
