package Main;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * 
 * @author Michael Ebenstein
 * @version 12-12-2016
 */
public class Fibonacci {
	private ArrayList<BigInteger> nums;
	
	public Fibonacci(){
		nums = new ArrayList<>();

	}
	
	public BigInteger getNumber(int num){
		if(num < 0)throw new IllegalArgumentException();
		
		int idx = 0;
		
		if(nums.size() < 2){
			for(long i = 0; i < 2;++i)
				nums.add(new BigInteger(""+i));
		}
		
		while(num >= nums.size()){
			idx = nums.size()-1;
			nums.add(new BigInteger(""+(nums.get(idx).add(nums.get(idx-1)))));
		}
		
		return nums.get(num);
	}
	
	public String toString(){
		String out = "";
		
		for(int i = 0; i < nums.size();++i)
			out+=i+" : "+nums.get(i)+'\n';
		
		return out;
	}
	
	/**
	 * Bei diese Funktion war mir die Angabe nicht eindeutig und bin mir 
	 * deshalb nicht sicher ob diese richtig ist. Ich bitte dies zu beruecksichtigen.
	 * @param idx
	 * @return
	 */
	public ArrayList<BigInteger> getNumbers(int idx){
		if(idx < 0)throw new IllegalArgumentException();
		
		if(idx > nums.size())
			getNumber(idx);
			
		ArrayList<BigInteger> out = new ArrayList<>();
		
		for(int i = 0; i < idx;++i)
			out.add(nums.get(i));
		
		return out;
	}
}
