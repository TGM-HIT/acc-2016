package exceptions;

/**
 * Diese Exception wird geworfen wenn keine Portionen mehr eingeladen werden
 * k�nnen.
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public class ReachedMaxFoodException extends RuntimeException {

	public ReachedMaxFoodException() {
		super("Es k�nnen keine zus�tzlichen Portionen mehr eingelagert werden.");
	}

}
