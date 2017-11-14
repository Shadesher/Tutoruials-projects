package by.Sd.Tutor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class MainWindow extends JFrame {

	private JPanel panel1;
	private JPanel panel2;
	private JTabbedPane tabbedPane;
	private JTextArea txtrEnterUrlHere;
	private JButton btnGetImage;
	private JButton btnGetFile;
	private Choice choice;
	private JLabel lblFormat;
	private JButton btnView;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmSaveImage;
	private JMenu mnOptions;
	private JMenuItem mntmExit;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JLabel imageLable;

	public MainWindow(int width, int hight) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(640, 480);
		getContentPane().setLayout(null);
		
		panel1 = new JPanel(null);
		panel2 = new JPanel(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 31, 605, 400);
		getContentPane().add(tabbedPane);
		tabbedPane.addTab("Page1", panel1);
		
		txtrEnterUrlHere = new JTextArea();
		txtrEnterUrlHere.setText("Enter URL here...");
		txtrEnterUrlHere.setBounds(10, 45, 580, 314);
		panel1.add(txtrEnterUrlHere);
		
		btnGetImage = new JButton("Get Image");
		btnGetImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Main.setImage(new URL(txtrEnterUrlHere.getText()));
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Invalid URL or no internet connection");
				}
			}
		});
		btnGetImage.setBounds(10, 11, 130, 23);
		panel1.add(btnGetImage);
		
		btnGetFile = new JButton("Get File");
		btnGetFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int reply = chooser.showOpenDialog(null);
				if(reply == JFileChooser.APPROVE_OPTION) {
					Main.setImage(chooser.getSelectedFile());
				}
			}
		});
		btnGetFile.setBounds(460, 11, 130, 23);
		panel1.add(btnGetFile);
		tabbedPane.addTab("Page 2", panel2);
		
		choice = new Choice();
		choice.setBounds(510, 10, 80, 20);
		panel2.add(choice);
		
		choice.add("png");
		choice.add("jpg");
		
		
		lblFormat = new JLabel("  Format :");
		lblFormat.setBounds(451, 10, 53, 20);
		panel2.add(lblFormat);
		
		btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Main.getImage()== null){return;}
				imageLable.setIcon(new ImageIcon(Main.getImage()));
				imageLable.updateUI();
			}
		});
		btnView.setBounds(10, 10, 90, 23);
		panel2.add(btnView);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 44, 570, 317);
		panel2.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		imageLable = new JLabel("");
		panel.add(imageLable, BorderLayout.CENTER);
		
		menuBar = new JMenuBar();
		menuBar.setForeground(Color.DARK_GRAY);
		menuBar.setBounds(0, 0, 634, 21);
		getContentPane().add(menuBar);
		
		mnFile = new JMenu("File");
		mnFile.setForeground(Color.DARK_GRAY);
		menuBar.add(mnFile);
		
		mntmSaveImage = new JMenuItem("Save Image");
		mntmSaveImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int reply = chooser.showSaveDialog(null);
				if(reply == JFileChooser.APPROVE_OPTION) {
					Main.saveImage(chooser.getSelectedFile(), choice.getSelectedItem());
				}
			}
		});
		mnFile.add(mntmSaveImage);
		
		mnOptions = new JMenu("Options");
		mnOptions.setForeground(Color.DARK_GRAY);
		menuBar.add(mnOptions);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnOptions.add(mntmExit);
		
		setVisible(true);
	}
}
