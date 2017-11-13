package exceptions;

/**
 * Diese Exception wird geworfen wenn kein Essen mehr ausgegeben werden kann.
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public class NoFoodException extends RuntimeException {

	public NoFoodException() {
		super("Es kann kein Essen mehr ausgegeben werden.");
	}

}
