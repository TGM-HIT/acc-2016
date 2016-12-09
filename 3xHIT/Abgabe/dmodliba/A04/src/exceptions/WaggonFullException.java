package exceptions;

/**
 * Diese Exception wird geworfen wenn keine Personen mehr einsteigen k�nnen
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public class WaggonFullException extends RuntimeException {

	public WaggonFullException() {
		super("Es k�nnen keine weiteren Personen mehr in diesen Waggon einsteigen.");
	}

}
