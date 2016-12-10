package Main;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.concurrent.DelayQueue;

/**
 * 
 * @author Michael Ebenstein
 * @version 10.12.2016
 * 
 */

public class Zug extends ArrayDeque<Wagon>{
	
	
	public Zug(){
		
		add(new Wagon(false,2));
	}
	
	public void dispatchWagons(int idx){
		if(size() < 2||idx < 0||idx > size()-1)throw new IllegalArgumentException("Invalid dispatch index");
		
		for(int i = idx; i < size();++i)
			pollLast();
	}
	
	public void attachWagon(Wagon w){
		if(w == null)throw new IllegalArgumentException("attached wagon is null");
		
		addLast(w);
	}
	
	public void attachWagons(Collection<Wagon> wagons){
		if(wagons == null)throw new IllegalArgumentException("attached wagons are null");
		
		this.addAll(wagons);
	}
	
	public void attachWagons(Wagon[] wagons){
		if(wagons == null)throw new IllegalArgumentException("attached wagons are null");
		
		attachWagons(Arrays.asList(wagons));
	}
	
	public String toString(){
		return "Zug "+size();
	}
}
