package exceptions;

/**
 * Diese Exception wird geworfen wenn keine Personen mehr aussteigen k�nnen
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public class WaggonEmptyException extends RuntimeException {

	public WaggonEmptyException() {
		super("Es k�nnen keine Personen mehr aussteigen");
	}

}
