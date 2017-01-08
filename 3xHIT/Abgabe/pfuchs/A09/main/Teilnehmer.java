package main;

/**
 * The members of the game
 * 
 * 
 * @author Peter Fuchs
 * @version 19 Dec 2016
 */
public class Teilnehmer {
	private int punkte;
	private String name;
	
	/**
	 * 
	 * Constructor
	 * 
	 * @param name the name of the member
	 */
	public Teilnehmer(String name) {
		this.setName(name);
		this.setPunkte(0);
	}
	
	public void addPunkte(double time) {
		this.punkte += (int) (300-time*10);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the punkte
	 */
	public int getPunkte() {
		return punkte;
	}

	/**
	 * @param punkte the punkte to set
	 */
	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}
}
