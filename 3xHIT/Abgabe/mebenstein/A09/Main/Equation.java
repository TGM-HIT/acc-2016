package Main;
/**
 * 
 * @author Michael Ebenstein
 * @version 17-12-2016
 */
public class Equation {
	private String equation;
	private double answer;
	private long startTime;
	private long duration;
	
	public Equation(String e,double a){
		equation = e;
		answer = a;
		duration = 0;
	}
	
	
	public Equation start(){
		startTime = System.nanoTime();
		duration = 0;
		
		return this;
	}
	
	public long check(double answer){
		if(this.answer != answer)return 0;
		duration = System.nanoTime() - startTime;
		return duration;
	}
	
	public String getEquation(){
		return equation;
	}


	public long getDuration() {
		return duration;
	}

	public long getStartTime() {
		return startTime;
	}
	
	 

	
}
