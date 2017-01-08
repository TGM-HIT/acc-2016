package main;

/**
 * A salad for the train<br>
 * *YUM*
 * 
 * @author Peter Fuchs
 * @version 12 Dec 2016
 */
public interface Salat {
	/**
	 * To make an salad, you use rezept()
	 * 
	 * @return the remaining ingredients<br>
	 * index 0 = the ingredient for specializing the salad<br>
	 * index 1 = the marinade
	 * @throws NotEnoughIngredientsException if there were not enough ingredients
	 */
	public int[] rezept() throws NotEnoughIngredientsException;
}
