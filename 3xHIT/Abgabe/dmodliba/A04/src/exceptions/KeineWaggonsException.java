package exceptions;

/**
 * Diese Exception wird geworfen wenn keine Waggons mehr abgehängt werden können
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public class KeineWaggonsException extends RuntimeException {

	public KeineWaggonsException() {
		super("Es kann kein Waggon abgehängt werden.");
	}

}
