package shin_student.ui.panel.manag;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import shin_student.dto.Codes;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class LeftPanel extends JPanel implements MouseListener {
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

//		tableModel = new DefaultTableModel(getList(), new String[] { "학번", "성명", "학적 구분" });
		table = new JTable();
		table.setModel(new DefaultTableModel(null, new String[] { "학번", "성명", "학적 구분" }));
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
	}

//	public static DefaultTableModel getModel() {
//		return new DefaultTableModel(null, new String[] { "학번", "성명", "학적 구분" });
//	}

//	private static Object[][] getList() {
//		try {
//		List<Codes> managList = TopPanel.managList;
//		Object[][] arr = new Object[managList.size()][3];
//		for (int i = 0; i < managList.size(); i++) {
//			arr[i][0] = managList.get(i).getNo();
//			arr[i][1] = managList.get(i).getName();
//			arr[i][2] = managList.get(i).getAtdno().getAttending();
//		}
////		for(Codes a : managList) {
////			String[] data = {a.getNo()+"",a.getName(),a.getAtdno().getAttending()};
////			tableModel.addRow(data);
////		}
//		return arr;
//			
//		}catch(NullPointerException e) {
//			
//		}
//
//		return null;
//	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			do_table_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_table_mouseClicked(MouseEvent e) {
//		Object a = getModel().getValueAt(table.getSelectedRow(),0);
//		System.out.println(a);
	}
}
