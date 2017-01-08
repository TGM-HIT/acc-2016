package langheiter.david;

public class Reisewagon implements Wagon{
	private boolean open;
	private int maxPersons;
	
	public Reisewagon(boolean open, int maxPersons) {
		this.open = open;
		this.maxPersons = maxPersons;
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public int getMaxPersons() {
		return maxPersons;
	}
	
}
