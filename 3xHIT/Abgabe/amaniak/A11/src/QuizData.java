import java.io.*;
import javax.swing.JOptionPane;

/**
 * Es werden laufend Fragen gestellt, wenn die Fragen ausgehen fangen sie von neu an.
 * Die Fragen und Antworten werden in einer Datei namens quiz.txt gespeichert.
 * 
 * Informationen fuer das Quiz.
 * 
 * @author David Maniak
 * @version 22.12.2016
 */
public class QuizData {
	int score, allPoints;
	private File file;
	private BufferedReader reader;
	
	/**
	 * Default-Konstruktor
	 */
	public QuizData() {
		score = 0;
		allPoints = 0;
		file = new File("quiz.txt");
		
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	/**
	 * Liest die naechste Zeile der File wo eine Frage steht und gibt diese zurueck
	 * 
	 * @return die Frage
	 */
	public String question() {
		String question = null;
		
		try {
			question = reader.readLine();
			
			if(question == null) {
				noMoreQuestions();
				reader = new BufferedReader(new FileReader(file));
				question = reader.readLine();
			}
		} catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		question = question.substring(2);
		
		return question;
	}
	
	/**
	 * Falls alle Fragen aus der quiz.txt gestellt wurden, wird gefragt ob die Fragen wiederholt werden sollen und ob 
	 * die Punkte zurueckgesetzt werden sollen
	 */
	private void noMoreQuestions() {
		int reset = JOptionPane.showConfirmDialog(null, "Liste an Fragen is zu Ende, die Fragen fangen von neu an.\nPunktestand: " 
														+ score + "/" + allPoints + "\nSoll der Punktestand zurueckgesetzt werden?"
														, "Von Neu", JOptionPane.ERROR_MESSAGE);
		if(reset == 0) {
			score = 0;
			allPoints = 0;
		}
	}
	
	/**
	 * Liest die naechste Zeile der File wo eine Antwort steht und gibt diese zurueck.
	 * 
	 * @return eine der Antworten
	 */
	public String answers() {
		String answer = null;
		
		try {
			answer = reader.readLine();
		} catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		if(answer == null)
			throw new InvalidFileFormatException("quiz.txt wurde falsch bearbeitet.\nEs gehoert immer eine Frage(q:), dann 4 Antworten (a:) und als letztes die richtige Antwort(r:).");
		answer = answer.substring(2);
		
		return answer;
	}
	
	/**
	 * Es wird ueberprueft ob die gewaehlte Antwort richtig ist.
	 * 
	 * @param toCheck die gewaehlte Antwort
	 */
	public void check(String toCheck) {
		String correctAnswer = answers(); //Da unter den 4 moeglichen Antworten gleich die richtige steht, kann man answers() benutzen um die richtige Antwort zu bekommen
		
		if(toCheck.equals(correctAnswer))
			score++;
		allPoints++;
		
		System.out.println("Momentante Punkte: " + score + "/" + allPoints);
	}
}
