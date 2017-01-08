package langheiter.david;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View {
	
	private Controller c;
	private JFrame frame;
	
	private JTextField usersField;
	private JTextField roundsField;
	private JPanel startScreen;
	
	private JPanel userStartScreen;
	private JLabel userStartLabel;
	private JButton userStartStart;
	
	private JPanel quizScreen;
	private JLabel quizQuestion;
	private JTextField quizInput;
	
	private JPanel roundScreen;
	private JLabel roundTitle;
	private JLabel roundEntries[];
	
	public View(Controller c) {
		this.c = c;
		frame = new JFrame("Rennen");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		usersField = new JTextField();
		roundsField = new JTextField();
	}
	
	public void showStartScreen() {
		if(startScreen == null) {
			startScreen = new JPanel();
			startScreen.setLayout(new GridLayout(3, 2));
			startScreen.add(new JLabel("Teilnehmer"));
			startScreen.add(usersField);
			startScreen.add(new JLabel("Runden"));
			startScreen.add(roundsField);
			JButton start = new JButton("Starte Spiel");
			start.addActionListener(c);
			JButton end = new JButton("Beeenden");
			end.addActionListener(c);
			startScreen.add(start);
			startScreen.add(end);
		}
		
		frame.setContentPane(startScreen);
		frame.revalidate();
		frame.pack();
		Dimension size = frame.getSize();
		size.width = 250;
		frame.setSize(size);
	}
	
	public void showUserStartScreen(int user, int round) {
		if(userStartScreen == null) {
			userStartScreen = new JPanel();
			userStartLabel = new JLabel();
			userStartScreen.setLayout(new GridLayout(2, 1));
			userStartScreen.add(userStartLabel);
			userStartStart = new JButton("Start");
			userStartStart.addActionListener(c);
			userStartStart.setActionCommand("userStart");
			userStartScreen.add(userStartStart);
		}
		userStartLabel.setText((user+1) + ". Players Turn.  " + (round+1) + " Round");
		frame.setContentPane(userStartScreen);
		frame.revalidate();
		userStartStart.requestFocus();
	}
	
	public void showQuizScreen(String question) {
		if(quizScreen == null) {
			quizScreen = new JPanel();
			quizScreen.setLayout(new GridLayout(1, 2));
			quizQuestion = new JLabel();
			quizScreen.add(quizQuestion);
			quizInput = new JTextField();
			quizInput.addActionListener(c);
			quizInput.setActionCommand("userInput");
			quizScreen.add(quizQuestion);
			quizScreen.add(quizInput);
		}
		quizQuestion.setText(question);
		quizInput.setText("");
		frame.setContentPane(quizScreen);
		frame.revalidate();
		quizInput.requestFocus();
	}
	
	public void showRoundScreen(double values[], String label) {
		if(roundScreen == null) {
			roundScreen = new JPanel();
			roundTitle = new JLabel();
			roundScreen.add(roundTitle);
			roundEntries = new JLabel[values.length];
			roundScreen.setLayout(new GridLayout(values.length+2, 1));
			for(int i = 0; i < values.length; i++) {
				roundEntries[i] = new JLabel();
				roundScreen.add(roundEntries[i]);
			}
			JButton next = new JButton("Next");
			next.addActionListener(c);
			roundScreen.add(next);
		}
		roundTitle.setText(label + " (The lower the better)");
		for(int i = 0; i < values.length; i++) {
			roundEntries[i].setText("Player " + i + ": " + values[i]);
		}
		frame.setContentPane(roundScreen);
		frame.revalidate();
	}
	
	public JTextField getQuizInput() {
		return quizInput;
	}
	
	public JTextField getUsersField() {
		return usersField;
	}
	
	public JTextField getRoundsField() {
		return roundsField;
	}
	
}
