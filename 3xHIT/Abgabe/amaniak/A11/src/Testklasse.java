/**
 * Testklasse in der das Quiz gestartet wird.
 * 
 * @author David Maniak
 * @version 22.12.2016
 */
public class Testklasse {
	public static void main(String[] args) {
		QuizData data = new QuizData();
		QuizUI ui = new QuizUI(data);
		QuizControl control = new QuizControl(ui);
	}
}
