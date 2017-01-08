package langheiter.david;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
	
	private View v;
	private Question q;
	private Punktestand curPoints;
	private long userStartTime;
	private boolean restart;
	
	public Controller() {
		userStartTime = 0;
		restart = false;
		q = new Question();
		v = new View(this);
		v.showStartScreen();
	}
	
	public static void main(String[] args) {
		new Controller();
	}
	
	private void userStartScreen() {
		v.showUserStartScreen(curPoints.currentUser(), curPoints.currentRound());
	}
	
	private void nextRound() {
		v.showRoundScreen(curPoints.getRoundPoints(), (curPoints.currentRound()-1) + ". Round Points");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd) {
		case "Starte Spiel":
			String usersStr = v.getUsersField().getText();
			String roundsStr = v.getRoundsField().getText();
			int users, rounds;
			try {
				users = Integer.parseInt(usersStr);
				rounds = Integer.parseInt(roundsStr);
				curPoints = new Punktestand(users, rounds);
				userStartScreen();
			} catch (NumberFormatException e2) {
				return;
			}
			curPoints = new Punktestand(users, rounds);
			break;
		case "userStart":
			v.showQuizScreen(q.newQuestion());
			userStartTime = System.currentTimeMillis();
			break;
		case "userInput":
			if(q.checkAnswer(v.getQuizInput().getText())) {
				long stopTime = System.currentTimeMillis();
				curPoints.nextUserResult(stopTime-userStartTime);
				if(curPoints.roundFinished()) {
					nextRound();
				} else {
					userStartScreen();
				}
			} else {
				v.getQuizInput().setText("");
			}
			break;
		case "Next":
			if(restart) {
				v.showStartScreen();
				restart = false;
				break;
			}
			if(curPoints.finished()) {
				v.showRoundScreen(curPoints.getCompletePoints(), "Complete Points");
				restart = true;
			} else {
				userStartScreen();
			}
			break;
		case "Beeenden":
			System.exit(0);
			break;
		}
	}
	
}
