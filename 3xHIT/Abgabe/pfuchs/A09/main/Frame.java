package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	public Frame(JPanel panel, int size, String title) {
		setSize(500, size);
		setTitle(title);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(panel);
		
		setVisible(true);
	}
}
