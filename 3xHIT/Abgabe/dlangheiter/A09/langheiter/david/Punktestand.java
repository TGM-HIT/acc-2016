package langheiter.david;

public class Punktestand {
	
	private int users;
	private int curUser;
	private int rounds;
	private int curRound;
	private double[] currentPoints;
	private double[] completePoints;
	
	public Punktestand(int users, int rounds) {
		currentPoints = new double[users];
		completePoints = new double[users];
		this.users = users;
		this.rounds = rounds;
		curUser = 0;
	}
	
	public int currentUser() {
		return curUser;
	}
	
	public void nextUserResult(double result) {
		currentPoints[curUser] = result;
		completePoints[curUser] += result;
		curUser++;
	}
	
	public int currentRound() {
		return curRound;
	}
	
	public boolean roundFinished() {
		if(curUser >= users) {
			curRound++;
			curUser = 0;
			return true;
		}
		return false;
	}
	
	public double[] getRoundPoints() {
		return currentPoints;
	}
	
	public double[] getCompletePoints() {
		return completePoints;
	}
	
	public boolean finished() {
		return curRound >= rounds;
	}
	
}
