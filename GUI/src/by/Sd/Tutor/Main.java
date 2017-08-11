package by.Sd.Tutor;

import java.awt.FlowLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {
	public static void main(String[] args) {
		Window window = new Window();
		window.setVisible(true);
		JScrollPane scrPane = new JScrollPane();
		scrPane.setBounds(100, 100, 100, 100);
		window.setLayout(null);
		window.add(scrPane);
		JTextArea text = new JTextArea();
		text.setText("asdsâaiafasfasafjopakonuasladsfsafsdfasfafasfsf");
		scrPane.setViewportView(text);
	}

}
