import java.util.ArrayList;

/**
 * Programm mit dem man einzelne Wagons eines Zuges kontrollieren kann.
 * 
 * @author David Maniak
 * @version 12.12.2016
 */
public class Zug {
	private ArrayList<Wagon> wagons = new ArrayList<>();
	
	/**
	 * Default-Konstruktor bei dem der erste Wagon ein offener Personenwagon fuer 100 Personen ist
	 */
	public Zug() {
		wagons.add(new Wagon(true, 100));
	}
	
	/**
	 * Konstruktor bei dem ein erster Wagon gesetzt werden kann.
	 * 
	 * @param w der Wagon der gesetzt werden kann
	 */
	public Zug(Wagon w) {
		wagons.add(w);
	}
	
	/**
	 * Ein Personen- bzw. Speisewagon kann am Anfang oder Ende des Zuges angehangt werden.
	 * 
	 * @param pos	ob der Wagon hinten abgehaengt werden soll ('h') oder vorne ('v')
	 * @param w 	der Wagon der angehaengt werden soll
	 */
	public void anhaengen(char pos, Wagon w) {
		if(pos == 'v')
			wagons.add(0, w);
		else if(pos == 'h')
			wagons.add(w);
		else
			throw new InvalidPositionException("Ungueltige Position. 'v' fuer vorne oder 'h' fuer hinten sind gueltig.");
	}
	
	/**
	 * Ein Personen- bzw. Speisewagon kann am Anfang oder Ende des Zuges abgehangt werden.
	 * 
	 * @param pos ob der Wagon hinten abgehaengt werden soll ('h') oder vorne ('v')
	 */
	public void abhaengen(char pos) {
		int index = 0;
		
		if(wagons.size() == 1)
			throw new TrainSizeException("Es kann nichts abgehaengt werden, da der Zug mind. einen Wagon braucht.");
		if(pos != 'v' && pos != 'h')
			throw new InvalidPositionException("Ungueltige Position. 'v' fuer vorne oder 'h' fuer hinten sind gueltig.");
		
		if(pos == 'h')
			index = wagons.size() - 1;
		
		wagons.remove(index);
	}
	
	/**
	 * Es werden die  Wagons in ihrer echten Reihenfolge in der Konsole ausgegeben.
	 */
	public void printTrain() {
		System.out.println("====WAGONANREIHUNG====");
		System.out.print("VORNE ");
		
		for(Wagon wagon : wagons)
			System.out.print(wagon.printWagon());
		
		System.out.print(" HINTEN\n\n");
	}
	
	/**
	 * Es werden alle Wagons mit ihrem Türzustand, maximaler Personenanzahl 
	 * und bei Speisewagen mit ihrer maximalen Essensmenge in der Konsole ausgegeben.
	 */
	public void printWagonDetails() {
		System.out.println("====WAGONDETAILS====");
		
		for(Wagon wagon : wagons)
			System.out.println("\n" + wagon.printDetails());
		
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		Zug zug = new Zug();
		
		Wagon pWagonSmall = new Wagon(false, 50);
		Wagon pWagonBig = new Wagon(true, 100);
		
		SpeiseWagon speiseWagonSmall = new SpeiseWagon(true, 40, 40);
		SpeiseWagon speiseWagonBig = new SpeiseWagon(false, 80, 70);
		
		// Wagons werden vorne und hinten angehaengt
		zug.anhaengen('h', speiseWagonBig);	 	//VORNE [Personenwagon][Speisewagon] HINTEN
		zug.anhaengen('h', pWagonBig);		 	//VORNE [Personenwagon][Speisewagon][Personenwagon] HINTEN
		zug.anhaengen('v', speiseWagonSmall);	//VORNE [Speisewagon][Personenwagon][Speisewagon][Personenwagon] HINTEN
		zug.anhaengen('h', pWagonSmall);		//VORNE [Speisewagon][Personenwagon][Speisewagon][Personenwagon][Personenwagon] HINTEN
		zug.anhaengen('h', speiseWagonSmall);	//VORNE [Speisewagon][Personenwagon][Speisewagon][Personenwagon][Personenwagon][Speisewagon] HINTEN
		zug.anhaengen('v', pWagonBig);		 	//VORNE [Personenwagon][Speisewagon][Personenwagon][Speisewagon][Personenwagon][Personenwagon][Speisewagon] HINTEN
		
		// Zug und Wagondetails werden ausgegeben
		zug.printTrain();
		zug.printWagonDetails();
		
		// Wagons werden vorne und hinten abgehaengt
		zug.abhaengen('h');					//VORNE [Personenwagon][Speisewagon][Personenwagon][Speisewagon][Personenwagon][Personenwagon] HINTEN
		zug.abhaengen('v');					//VORNE [Speisewagon][Personenwagon][Speisewagon][Personenwagon][Personenwagon] HINTEN
		zug.abhaengen('h');					//VORNE [Speisewagon][Personenwagon][Speisewagon][Personenwagon] HINTEN
		zug.anhaengen('h', speiseWagonBig);	//VORNE [Speisewagon][Personenwagon][Speisewagon][Personenwagon][Speisewagon] HINTEN
		
		// Neuer Zug und neue Wagondetails werden ausgegeben
		zug.printTrain();
		zug.printWagonDetails();
	}
}
