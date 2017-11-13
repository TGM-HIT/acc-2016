package exceptions;

/**
 * Diese Exception wird geworfen wenn keine Waggons mehr abgeh�ngt werden k�nnen
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public class KeineWaggonsException extends RuntimeException {

	public KeineWaggonsException() {
		super("Es kann kein Waggon abgeh�ngt werden.");
	}

}
