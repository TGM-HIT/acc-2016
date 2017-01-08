/**
 * The Quiz-class is used for saving the data of a question<br>
 * which is the question, it's answers and the correct answer
 * 
 * @author Peter Fuchs
 * @version 21 Dec 2016
 */
public class Quiz {
	private String[] answers;
	private String correctAnswer;
	private String question;
	
	/**
	 * Constructor<br>
	 * Creates a new Quiz using the answers, the question and the right answer
	 * 
	 * @param correctAnswer the right answer
	 * @param question the question
	 * @param answers the possible answers as an array
	 */
	public Quiz(String correctAnswer, String question, String ...answers) {
		this.setCorrectAnswer(correctAnswer);
		this.setAnswers(answers);
		this.setQuestion(question);
	}

	/**
	 * @return the answers
	 */
	public String[] getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	/**
	 * @return the correctAnswer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * @param correctAnswer the correctAnswer to set
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
}
