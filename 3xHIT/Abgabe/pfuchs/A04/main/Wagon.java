package main;

/**
 * A wagon for the train
 * 
 * @author Peter Fuchs
 * @version 12 Dec 2016
 */
public class Wagon {
	private boolean open;
	private int maxPassenger;
	private int actPassenger;
	
	/**
	 * Constructor
	 * 
	 * @param maxPassenger the max amount of passengers
	 */
	public Wagon(int maxPassenger) {
		actPassenger = 0;
		this.open = (maxPassenger > actPassenger);
		this.maxPassenger = maxPassenger;
	}
	
	/**
	 * Reserve a seat in the actual wagon
	 */
	public void buchen() {
		if (!open) {
			System.out.println("There is no seat for you in this wagon!");
			return;
		}
		
		actPassenger++;
		if (actPassenger == maxPassenger)
			open = false;
		System.out.println("Congrats, you got a seat in this train!");
	}
}
