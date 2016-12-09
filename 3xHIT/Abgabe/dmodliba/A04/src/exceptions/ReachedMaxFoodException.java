package exceptions;

/**
 * Diese Exception wird geworfen wenn keine Portionen mehr eingeladen werden
 * können.
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public class ReachedMaxFoodException extends RuntimeException {

	public ReachedMaxFoodException() {
		super("Es können keine zusätzlichen Portionen mehr eingelagert werden.");
	}

}
