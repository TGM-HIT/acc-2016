package langheiter.david;

public class Stats {
	
	private int right;
	private int wrong;
	
	public Stats() {
		right = 0;
		wrong = 0;
	}
	
	public void incRight() {
		right++;
	}
	
	public void incWrong() {
		wrong++;
	}
	
	public int getRight() {
		return right;
	}
	
	public int getWrong() {
		return wrong;
	}
	
}
