package Main;
/**
 * 
 * @author Michael Ebenstein
 * @version 10.12.2016
 * 
 */
public class SpeiseWagon extends Wagon{
	private int foodCount;
	
	public SpeiseWagon(boolean open, int persons,int foodCount) {
		super(open, persons);
		this.foodCount = foodCount;
		if(foodCount < 0)throw new IllegalArgumentException("Food count is lower than 0");
	}
	
	public int getFoodCount(){
		return foodCount;
	}
	
	public void giveFoodOut(int numFood){
		if(numFood > foodCount||numFood < 0)throw new IllegalArgumentException("Invalid food count");
		foodCount -= numFood;
	}
	
	public String toString(){
		return "Speisewagon:\t"+open+"\t"+personCount+"\t"+foodCount;
	}

}
