package by.Sd.tutorial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class MainWindow extends JFrame {
	private ListModel model;
	private JList<String> list;
	private JButton btnRemove;
	private JButton add_btn;

	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JScrollPane remove_btn = new JScrollPane();
		remove_btn.setBounds(10, 11, 320, 430);
		getContentPane().add(remove_btn);
		
		model = new ListModel();
		
		list = new JList<String>(model);
		remove_btn.setViewportView(list);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> objects = list.getSelectedValuesList();
				for(String s: objects) {
					model.removeElement(s);
				}
				list.updateUI();
			}
		});
		btnRemove.setBounds(340, 9, 89, 23);
		getContentPane().add(btnRemove);
		
		add_btn = new JButton("Add");
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog("Enter your string here:");
				model.addElement(s);
				list.updateUI();
			}
		});
		add_btn.setBounds(340, 43, 89, 23);
		getContentPane().add(add_btn);
		

		setVisible(true);
		list.updateUI();
		}
	public void addElement(String s) {
		model.addElement(s);
	}	
	public void removeElement(int index) {
		model.removeElement(index);
	}
	public void updateUI(){
		list.updateUI();
	}
}
