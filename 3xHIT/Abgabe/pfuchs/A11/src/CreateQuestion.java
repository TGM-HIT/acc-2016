import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Gives the user the possibility to create a new question
 * 
 * @author Peter Fuchs
 * @version 21 Dec 2016
 */
@SuppressWarnings("serial")
public class CreateQuestion extends JPanel {
	
	private JTextField[] answers;
	private JTextArea question;
	private JButton submit;
	private JComboBox<String> correctAnswer;
	
	/**
	 * Constructor<br>
	 * Adds some labels and textFields and buttons
	 * 
	 * @param c - {@linkplain Controller}
	 * @param m - {@linkplain Model}
	 */
	public CreateQuestion(Controller c, Model m) {		
		setOpaque(false);
		
		setLayout(new BorderLayout());
		
		JLabel headline = new JLabel("<html><body><h1 style=\"font-size: 40px\">Frage erstellen</h1></body></html", SwingConstants.CENTER);
		headline.setForeground(Color.BLACK);
		add(headline, BorderLayout.NORTH);
		
		question = new JTextArea("", SwingConstants.CENTER, 0);
		question.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void focusLost(FocusEvent arg0) {
					for (JTextField tf : answers)
						if (tf.getText().equals("")) {	//if one textfield is empty
							submit.setEnabled(false); 	//the button gets disabled
							return;
						}
					
					if (question.getText().equals("")) { //same with the textarea
						submit.setEnabled(false);		//button gets disabled
						return;
					}
					submit.setEnabled(true); //if every textfield/-area has an input the button gets enabled
				}
			});
		question.setForeground(Color.BLACK);
		question.setPreferredSize(new Dimension(500, 140));
		add(question);
		
		JPanel answer = new JPanel();
		answer.setLayout(new GridLayout(0, 2, 100, 30));
		answer.setOpaque(false);
		correctAnswer = new JComboBox<String>();
		correctAnswer.addItem("");
		correctAnswer.addItem("");
		correctAnswer.addItem("");
		correctAnswer.addItem("");
		submit = new JButton("Submit");
		submit.setEnabled(false);
		submit.setContentAreaFilled(false);
		submit.setFocusPainted(false);
		submit.setForeground(Color.WHITE);
		answers = new JTextField[4];
		for (int i = 0; i < answers.length; i++) {
			answers[i] = new JTextField();
			answers[i].setPreferredSize(new Dimension(300, 40));
			answers[i].addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void focusLost(FocusEvent arg0) { //adds the items to the dropdown-list
					correctAnswer.removeAllItems();
					for (int i = 0; i < answers.length; i++)
						correctAnswer.addItem(answers[i].getText());
					
					for (JTextField tf : answers)		//and does the same with activation as above
						if (tf.getText().equals("")) {
							submit.setEnabled(false);
							return;
						}
					
					if (question.getText().equals("")) {
						submit.setEnabled(false);
						return;
					}
					submit.setEnabled(true);
				}
			});
		}
		
		for (JTextField b : answers)
			answer.add(b);

		answer.add(correctAnswer);
		answer.add(submit);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { //when the button gets clicked, a quiz gets added
				String zeile = "<br />";
				m.addQuizzes(new Quiz((String) (correctAnswer.getSelectedItem()), question.getText().replaceAll("\n", zeile), answers[0].getText(), answers[1].getText(), answers[2].getText(), answers[3].getText()));
				for (Quiz q : m.getQuizzes())
					System.out.println(q.getQuestion());
				
				c.menu();
			}
		});
		
		add(answer, BorderLayout.SOUTH);
	}
	
}
