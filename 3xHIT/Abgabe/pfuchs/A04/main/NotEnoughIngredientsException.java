package main;

/**
 * An Exception for making a salad
 * 
 * @author Peter Fuchs
 * @version 12 Dec 2016
 */
public class NotEnoughIngredientsException extends Exception {
	private static final long serialVersionUID = 1L;

	public NotEnoughIngredientsException() {
		super("Sie haben nicht genug Zutaten mit!");
	}
}
