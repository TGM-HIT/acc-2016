package langheiter.david;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class View {
	
	private Controller c;
	
	private JFrame frame;
	private JPanel panel;
	private JLabel question;
	private JButton[] answers;
	private JButton exit;
	
	public View(Controller c) {
		this.c = c;
	}
	
	public void init() {
		frame = new JFrame("Quiz");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 330);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel(new BorderLayout());
		frame.setContentPane(panel);
		
		question = new JLabel("Question", SwingConstants.CENTER);
		question.setFont(new Font(question.getFont().getName(), Font.PLAIN, 30));
		panel.add(question, BorderLayout.NORTH);
		
		JPanel answerPanel = new JPanel(new GridLayout(4, 1));
		answers = new JButton[4];
		for(int i = 0; i < 4; i++) {
			answers[i] = new JButton();
			answers[i].addActionListener(c);
			answers[i].setActionCommand("answer" + i);
			answerPanel.add(answers[i]);
		}
		
		panel.add(answerPanel, BorderLayout.CENTER);
		
		exit = new JButton("Exit");
		exit.addActionListener(c);
		panel.add(exit, BorderLayout.SOUTH);
	}
	
	public void showQuiz(String questions, String[] answers) {
		question.setText(questions);
		for(int i = 0; i < 4; i++) {
			this.answers[i].setText(answers[i]);
		}
	}
	
	public void showStats(int right, int wrong) {
		JPanel stats = new JPanel(new GridLayout(2, 1));
		Font f = new JLabel().getFont();
		f = new Font(f.getName(), f.getStyle(), 30);
		
		JLabel rightLabel = new JLabel("Right: " + right, SwingConstants.CENTER);
		rightLabel.setFont(f);
		stats.add(rightLabel);
		
		JLabel wrongLabel = new JLabel("Wrong: " + wrong, SwingConstants.CENTER);
		wrongLabel.setFont(f);
		stats.add(wrongLabel);
		
		frame.setContentPane(stats);
		frame.revalidate();
	}
	
}
