/**
 * Speisewagons können mit einer bestimmten maximalen Personenanzahl und maximalen Essensmenge erzeugt werden.
 * 
 * @author David Maniak
 * @version 12.12.2016
 */
public class SpeiseWagon extends Wagon {
	int maxEssen;
	
	/**
	 * Ein Speisewagon kann mit einer bestimmten maximalen Personenanzahl, 
	 * maximalen Essensmenge und dem Zustand der Türen erzeugt werden.
	 * 
	 * @param open ob der Wagon geöffnet oder geschlossen ist
	 * @param maxPersonen wie viele Personen in den Zug passen
	 * @param maxEssen die maximale Essensmenge die in den Speisewagon passt
	 */
	public SpeiseWagon(boolean open, int maxPersonen, int maxEssen) {
		super(open, maxPersonen);
		this.maxEssen = maxEssen;
	}
	
	/**
	 * Es wird der Zustand des Zuges, die maximale Personen-&Speisenanzahl in einem String zurueckgegeben
	 * 
	 * @return die Informationen in einem String
	 */
	@Override
	public String printDetails() {
		String doors = null;
		if(open)
			doors = "offen";
		else
			doors = "geschlossen";
		
		return "Speisewagon\nZustand: " + doors + "\nMaximale Personenanzahl: " + maxPersonen + "\nMaximale Essensmenge: " + maxEssen;
	}
	
	/**
	 * Es wird die Art des Wagons in einem String zurueckgegeben
	 * 
	 * @return die Art des Zuges in einem String
	 */
	@Override
	public String printWagon() {
		return "[Speisewagon]";
	}
}
