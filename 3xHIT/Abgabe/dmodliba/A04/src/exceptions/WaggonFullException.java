package exceptions;

/**
 * Diese Exception wird geworfen wenn keine Personen mehr einsteigen können
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public class WaggonFullException extends RuntimeException {

	public WaggonFullException() {
		super("Es können keine weiteren Personen mehr in diesen Waggon einsteigen.");
	}

}
