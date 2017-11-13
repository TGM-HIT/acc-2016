package main;

public class Erdäpfelsalat implements Salat {
	private int erdäpfel;
	private int marinade;
	
	public Erdäpfelsalat(int erdäpfel, int marinade) {
		if (erdäpfel < 0 || marinade < 0) throw new IllegalArgumentException();
		this.erdäpfel = erdäpfel;
		this.marinade = marinade;
	}
	
	/**
	 * @return int[] an array of the amount of ingredients that are left over<br>
	 * index 0 = potatoes, index 1 = marinade
	 * @throws NotEnoughIngredientsException 
	 */
	public int[] rezept() throws NotEnoughIngredientsException {
		if (erdäpfel < 300 || marinade < 62) throw new NotEnoughIngredientsException();
		
		int[] remainingIngredients = new int[2];
		remainingIngredients[0] = erdäpfel-300;
		remainingIngredients[1] = marinade-62;
		
		return remainingIngredients;
	}
}
