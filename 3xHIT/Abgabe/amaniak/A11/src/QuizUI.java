import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

/**
 * Es werden laufend Fragen gestellt, wenn die Fragen ausgehen fangen sie von neu an.
 * Die Fragen und Antworten werden in einer Datei namens quiz.txt gespeichert.
 * 
 * UI fuer das Quiz.
 * 
 * @author David Maniak
 * @version 22.12.2016
 */
public class QuizUI extends JPanel {
	JFrame frame;
	JLabel question;
	JRadioButton[] answers;
	JButton next, quit;
	ButtonGroup group;
	private QuizData data;
	
	/**
	 * Konstruktor bei dem die dazugehoerige Klasse mit Daten gesetzt wird.
	 * 
	 * @param data die dazugehoerige Klasse mit Daten
	 */
	public QuizUI(QuizData data) {
		super(new GridBagLayout());
		this.data = data;
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		question = new JLabel(data.question());
		next = new JButton("Next Question");
		quit = new JButton("Quit Quiz");
		answers = new JRadioButton[4];
		group = new ButtonGroup();
		
		for(int i = 0; i < answers.length; i++) {
			answers[i] = new JRadioButton(data.answers());
			group.add(answers[i]);
		}
		
		JPanel bot = new JPanel();
		bot.add(next);
		bot.add(quit);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 10, 0);
		this.add(question, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets.bottom = 0;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(answers[0], gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(answers[1], gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(answers[2], gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(answers[3], gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets.bottom = 10;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(bot, gbc);
		
		frame = new JFrame("Quiz");
		frame.setSize(400, 210);
		frame.setResizable(false);
		frame.setContentPane(this);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/**
	 * Es wird geprueft ob eine von den verfuegbaren Antworten ausgewaehlt wurde.
	 * 
	 * @return ob eine Antwort ausgewaehlt wurde (true) oder nicht (false)
	 */
	public boolean isAnswerSelected() {
		for(int i = 0; i < answers.length; i++) {
			if(answers[i].isSelected()) {
				data.check(answers[i].getText());
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Es wird die naechste Frage und die naechsten Antworten geladen.
	 */
	public void loadQuestion() {
		if(isAnswerSelected()) {
			group.clearSelection();
			question.setText(data.question());
		
			for(int i = 0; i < answers.length; i++)
				answers[i].setText(data.answers());
		} else 
			JOptionPane.showMessageDialog(this, "Es wurde keine Antwort ausgewaehlt.", "Nichts ausgewaehlt", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Es wird der Finale Punktestand angezeigt und das Program wird geschlossen.
	 */
	public void loadPoints() {
		JOptionPane.showMessageDialog(this, "Finaler Punktestand: " + data.score + "/" + data.allPoints, "Punktestand", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
