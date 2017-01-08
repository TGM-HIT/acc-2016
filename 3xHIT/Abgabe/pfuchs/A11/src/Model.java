import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Saves the data which includes all quizzes<br>
 * And the number of wrong- and right-answered questions
 * 
 * 
 * @author Peter Fuchs
 * @version 21 Dec 2016
 */
public class Model {
	private int correctAnswers;
	private int wrongAnswers;
	
	private HashSet<Quiz> quizzes;
	
	private boolean over;
	
	/**
	 * Constructor<br>
	 * Reads the Quizzes from the file located in "src", called "questions.txt"
	 * 
	 * @param quizzez the quizzes the user can add manually
	 */
	public Model(Quiz ...quizzez) {
		this.correctAnswers = 0;
		this.wrongAnswers = 0;
		this.over = false;
		
		this.quizzes = new HashSet<Quiz>();
		for (Quiz q : quizzez)
			this.quizzes.add(q);
		
		try {
			RandomAccessFile raf = new RandomAccessFile("src/questions.txt", "rw");
			String question = "", correctAnswer = "";
			String[] answers = new String[4];
			while (true) {
				String line = raf.readLine();
				
				if (line == null || line.equals(""))
					break;
				
				if (line.indexOf("Q:\t") == 0)
					question = line.substring(line.indexOf("Q:\t")+3).replaceAll("<br />", "\n");
				if (line.indexOf("A1:\t") == 0)
					answers[0] = line.substring(line.indexOf("A1:\t")+4);
				if (line.indexOf("A2:\t") == 0)
					answers[1] = line.substring(line.indexOf("A2:\t")+4);
				if (line.indexOf("A3:\t") == 0)
					answers[2] = line.substring(line.indexOf("A3:\t")+4);
				if (line.indexOf("A4:\t") == 0)
					answers[3] = line.substring(line.indexOf("A4:\t")+4);
				if (line.indexOf("Ans:\t") == 0)
					correctAnswer = line.substring(line.indexOf("Ans:\t")+5);
				
				if (line.indexOf("/END") == 0) {
					this.quizzes.add(new Quiz(correctAnswer, question, answers));
					correctAnswer = "";
					question = "";
					answers = new String[4];
				}
			}
			
			raf.close();
		} catch (FileNotFoundException e) {
			System.out.println("File could not be found");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("An error occured!");
			System.exit(1);
		}
	}
	
	/**
	 * @return the quizzes
	 */
	public HashSet<Quiz> getQuizzes() {
		return quizzes;
	}

	/**
	 * @param quizzes the quizzes to set
	 */
	public void setQuizzes(HashSet<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
	
	/**
	 * Adds an array of quizzes to the set and writes them to the file
	 * 
	 * @param quizzez the quizzes to add
	 */
	public void addQuizzes(Quiz ...quizzez) {
		try {
			RandomAccessFile raf = new RandomAccessFile("src/questions.txt", "rw");
			while (true) {
				String text = raf.readLine();
				if (text == null || text.equals("")) break;
			}
			for (Quiz q : quizzez) {
				this.quizzes.add(q);
				raf.writeBytes("Q:\t"+q.getQuestion()+"\r\n");
				for (int i = 0; i < q.getAnswers().length; i++)
					raf.writeBytes("A"+(i+1)+":\t"+q.getAnswers()[i]+"\r\n");
				raf.writeBytes("Ans:\t" + q.getCorrectAnswer()+"\r\n");
				raf.writeBytes("/END\r\n");
			}
			
			raf.close();
		} catch (FileNotFoundException e) {
			System.out.println("File could not be found!");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("An error occured");
			System.exit(1);
		}
	}

	/**
	 * @return the correctAnswers
	 */
	public int getCorrectAnswers() {
		return correctAnswers;
	}

	/**
	 * @param correctAnswers the correctAnswers to set
	 */
	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	/**
	 * @return the wrongAnswers
	 */
	public int getWrongAnswers() {
		return wrongAnswers;
	}

	/**
	 * @param wrongAnswers the wrongAnswers to set
	 */
	public void setWrongAnswers(int wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

	/**
	 * @return the actual quiz
	 */
	public Quiz getAktQuiz() {
		if (quizzes.size() < getCorrectAnswers()+getWrongAnswers())
			return null;
		
		Iterator<Quiz> it = quizzes.iterator();
		for (int i = 0; i < (getCorrectAnswers()+getWrongAnswers()) && it.hasNext(); i++)
			it.next();
		return it.next();
	}

	/**
	 * Resets the Quiz
	 */
	public void reset() {
		this.setCorrectAnswers(0);
		this.setWrongAnswers(0);
		this.setOver(false);
	}

	/**
	 * @return the over
	 */
	public boolean isOver() {
		return over;
	}

	/**
	 * @param over the over to set
	 */
	public void setOver(boolean over) {
		this.over = over;
	}

}
