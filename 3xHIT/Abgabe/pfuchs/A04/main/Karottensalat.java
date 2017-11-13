package main;

public class Karottensalat implements Salat {
	private int karotten;
	private int marinade;
	
	public Karottensalat(int karotten, int marinade) {
		if (karotten < 0 || marinade < 0) throw new IllegalArgumentException();
		this.karotten = karotten;
		this.marinade = marinade;
	}
	
	/**
	 * @return int[] an array of the amount of ingredients that are left over<br>
	 * index 0 = carrots, index 1 = marinade
	 * @throws NotEnoughIngredientsException 
	 */
	public int[] rezept() throws NotEnoughIngredientsException {
		if (karotten < 300 || marinade < 62) throw new NotEnoughIngredientsException();
		
		int[] remainingIngredients = new int[2];
		remainingIngredients[0] = karotten-300;
		remainingIngredients[1] = marinade-62;
		
		return remainingIngredients;
	}
}
