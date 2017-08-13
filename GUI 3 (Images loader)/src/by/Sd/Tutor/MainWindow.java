package by.Sd.Tutor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainWindow extends JFrame {

	public MainWindow(int width, int hight) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(640, 480);
		getContentPane().setLayout(null);
		
		JPanel panel1 = new JPanel(null);
		JPanel panel2 = new JPanel(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 80, 604, 351);
		getContentPane().add(tabbedPane);
		setVisible(true);
		tabbedPane.addTab("Tab 1", panel1);
		tabbedPane.addTab("Tab 2", panel2);
	}
}
