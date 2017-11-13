package exceptions;

/**
 * Diese Exception wird geworfen wenn keine Personen mehr aussteigen können
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public class WaggonEmptyException extends RuntimeException {

	public WaggonEmptyException() {
		super("Es können keine Personen mehr aussteigen");
	}

}
