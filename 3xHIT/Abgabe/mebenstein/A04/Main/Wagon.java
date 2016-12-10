package Main;


/**
 * 
 * @author Michael Ebenstein
 * @version 10.12.2016
 * 
 */

public class Wagon {
	protected boolean open;
	protected int personCount;
	
	
	public Wagon(boolean open,int persons){
		this.open = open;
		personCount = persons;
		if(persons < 0)
			throw new IllegalArgumentException("persons are lower than 0");
	}
	
	public boolean open(){
		return open;
	}
	
	public boolean close(){
		return !open;
	}
	
	public int getPersonCount(){
		return personCount;
	}
	
	public String toString(){
		return "Wagon:\t"+open+"\t"+personCount;
	}
}
