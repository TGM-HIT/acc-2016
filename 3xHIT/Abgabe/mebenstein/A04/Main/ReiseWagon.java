package Main;
/**
 * 
 * @author Michael Ebenstein
 * @version 10.12.2016
 * 
 */
public class ReiseWagon extends Wagon {

	public ReiseWagon(boolean open, int persons) {
		super(open, persons);
	
	}
	
	public String toString(){
		return "Reisewagon:\t"+open+"\t"+personCount;
	}
}
