import javax.swing.*;
import java.awt.*;
import java.util.NoSuchElementException;

/**
 * Creates a Panel where the user can play the quizzes on
 * 
 * @author Peter Fuchs
 * @version 21 Dec 2016
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	private Controller c;
	private Model m;
	
	private String answer;
	private JButton[] answers;
	private JButton endButton;
	
	private Quiz q;
	
	/**
	 * Constructor<br>
	 * Adds some Labels and Buttons to play the quiz
	 * 
	 * @param controller - {@linkplain Controller}
	 * @param m - {@linkplain Model}
	 */
	public GamePanel(Controller controller, Model m) {
		this.c = controller;
		this.m = m;
		try {
			this.q = this.m.getAktQuiz(); //if there is a next question
		} catch (NoSuchElementException e) {
			this.c.endGame(); 	//if not it throws a NoSuchElementException
			return;				//and calls endGame method from controller
		}
		
		this.answer = "";
		
		setOpaque(false);
		
		setLayout(new BorderLayout());
		
		JLabel headline = new JLabel("<html><body><h1 style=\"font-size: 40px\">Frage "+(this.m.getCorrectAnswers()+this.m.getWrongAnswers()+1)+"</h1></body></html", SwingConstants.CENTER);
		headline.setForeground(Color.BLACK);
		add(headline, BorderLayout.NORTH);
		
		JLabel question = new JLabel("<html><body><h3 style=\"font-size: 20px; text-align: center;\">"+q.getQuestion()+"</h3></body></html>", SwingConstants.CENTER);
		question.setForeground(Color.BLACK);
		question.setPreferredSize(new Dimension(500, 175));
		add(question);
		
		JPanel answer = new JPanel();
		answer.setLayout(new GridLayout(0, 2, 100, 10));
		answer.setOpaque(false);
		answers = new JButton[4];
		String[] answerString = q.getAnswers();
		for (int i = 0; i < answers.length; i++) {
			answers[i] = new JButton(answerString[i]);
			answers[i].setForeground(Color.WHITE);
			answers[i].setContentAreaFilled(false);
			answers[i].setFocusPainted(false);
			answers[i].setPreferredSize(new Dimension(300, 40));
			answers[i].addActionListener(this.c);
		}
		
		for (JButton b : answers)
			answer.add(b);
		
		endButton = new JButton("End game");
		endButton.addActionListener(this.c);
		endButton.setForeground(Color.WHITE);
		endButton.setContentAreaFilled(false);
		endButton.setFocusPainted(false);
		answer.add(endButton);
		
		add(answer, BorderLayout.SOUTH);
	}
	
	/**
	 * Checks if one of the Buttons got clicked
	 * @param source the object to compare
	 */
	public void checkButtons(Object source) {
		if (this.answers == null || this.endButton == null)
			return;
		
		for (int i = 0; i < answers.length; i++)
			if (source.equals(answers[i])) {
				answer = answers[i].getText();
				this.c.answered(answer.equals(q.getCorrectAnswer()));
			}
		
		if (source.equals(this.endButton))
			this.c.endGame();
	}
}
