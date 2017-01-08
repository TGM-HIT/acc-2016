package main;

public class Blattsalat implements Salat {
	private int blattsalat;
	private int marinade;
	
	public Blattsalat(int blattsalat, int marinade) {
		if (blattsalat < 0 || marinade < 0) throw new IllegalArgumentException();
		this.blattsalat = blattsalat;
		this.marinade = marinade;
	}
	
	/**
	 * @return int[] an array of the amount of ingredients that are left over<br>
	 * index 0 = green salad, index 1 = marinade
	 * @throws NotEnoughIngredientsException 
	 */
	public int[] rezept() throws NotEnoughIngredientsException {
		if (blattsalat < 300 || marinade < 62) throw new NotEnoughIngredientsException();
		
		int[] remainingIngredients = new int[2];
		remainingIngredients[0] = blattsalat-300;
		remainingIngredients[1] = marinade-62;
		
		return remainingIngredients;
	}
}
