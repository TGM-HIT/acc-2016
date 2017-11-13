package langheiter.david;

public class Question {
	private String answer;
	
	public Question() {
		answer = "";
	}
	
	public String newQuestion() {
		int num1 = ((int)(Math.random() * 10));
		int num2 = ((int)(Math.random() * 10));
		int answer = 0;
		char calcChar = ' ';
		switch ((int)(Math.random() * 3)) {
		case 0:
			answer = num1 + num2;
			calcChar = '+';
			break;
		case 1:
			answer = num1 - num2;
			calcChar = '-';
			break;
		case 2:
			answer = num1 * num2;
			calcChar = '*';
			break;
		}
		this.answer = answer + "";
		return num1 + " " + calcChar + " " + num2 + " = ";
	}
	
	public boolean checkAnswer(String answer) {
		return this.answer.equals(answer);
	}
	
	
}
