package shin.student2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class Search extends JFrame {

	private JPanel contentPane;

	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(true);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		tabbedPane.addTab("학생 관리", null, panel, null);
		panel.setLayout(new GridLayout(0, 2, 10, 0));
		
		StdLHPanel panel_2 = new StdLHPanel();
		panel.add(panel_2);
		
		StdRHPanel panel_3 = new StdRHPanel();
		panel.add(panel_3);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("성적 관리", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 20, 0, 20));
		panel_1.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		ScoTopPanel panel_6 = new ScoTopPanel();
		panel_4.add(panel_6);
		
		JButton btnNewButton = new JButton("검색");
		panel_4.add(btnNewButton);
		
		ScoBottomPanel panel_5 = new ScoBottomPanel();
		panel_1.add(panel_5, BorderLayout.CENTER);
	}

}
