/**
 * Personenwagons können mit einer bestimmten maximalen Personenanzahl erzeugt werden.
 * 
 * @author David Maniak
 * @version 12.12.2016
 */
public class Wagon {
	boolean open;
	int maxPersonen;
	
	/**
	 * Ein Personenwagon kann mit einer bestimmten maximalen Personenanzahl und dem Zustand der Türen erzeugt werden.
	 * 
	 * @param open ob der Wagon geöffnet oder geschlossen ist
	 * @param maxPersonen wie viele Personen in den Zug passen
	 */
	public Wagon(boolean open, int maxPersonen) {
		this.open = open;
		this.maxPersonen = maxPersonen;
	}
	
	/**
	 * Es wird der Zustand des Zuges und die maximale Personenanzahl in einem String zurueckgegeben
	 * 
	 * @return die Informationen in einem String
	 */
	public String printDetails() {
		String doors;
		if(open)
			doors = "offen";
		else
			doors = "geschlossen";
		
		return "Personenwagon\nZustand: " + doors + "\nMaximale Personenanzahl: " + maxPersonen;
	}

	/**
	 * Es wird die Art des Wagons in einem String zurueckgegeben
	 * 
	 * @return die Art des Zuges in einem String
	 */
	public String printWagon() {
		return "[Personenwagon]";
	}
}
