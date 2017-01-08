package langheiter.david;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Controller implements ActionListener {
	
	private View v;
	private Fragen f;
	private Stats s;
	
	public Controller() {
		f = new Fragen("fragen.txt");
		f.loadFromFile();
		f.saveToFile();
		s = new Stats();
		v = new View(this);
		v.init();
		showQuestion();
	}
	
	public static void main(String[] args) {
		new Controller();
	}
	
	private void showQuestion() {
		Frage fr = f.getNextFrage();
		v.showQuiz(fr.getQuestion(), fr.getAnswers());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		
		if(cmd.equalsIgnoreCase("exit")) {
			v.showStats(s.getRight(), s.getWrong());
			return;
		}
		
		int answer = Integer.parseInt(cmd.charAt(cmd.length()-1) + "");
		if(answer == f.getCurrentAnswer()) {
			s.incRight();
		} else {
			s.incWrong();
		}
		showQuestion();
		
	}
	
}
