package main;

import java.util.LinkedList;

/**
 * A tschu-tschu-train
 * 
 * @author Peter Fuchs
 * @version 12 Dec 2016
 */
public class Zug {
	private LinkedList<Wagon> zug;
	
	/**
	 * Constructor<br>
	 * Adds a {@linkplain Reisewagon} with 100 seats
	 */
	public Zug() {
		System.out.println("Welome on our new Tschu-Tschu-Express");
		zug = new LinkedList<Wagon>();
		zug.add(new Reisewagon(100));
	}
	
	/**
	 * Add a wagon in front of the train
	 * 
	 * @param wagon the wagon to add
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public void addWagonFront(Wagon wagon) {
		if (zug == null || zug.size() == 0) throw new NullPointerException();
		if (wagon == null) throw new IllegalArgumentException();
		zug.addFirst(wagon);
	}

	/**
	 * Add a wagon at the end of the train
	 * 
	 * @param wagon the wagon to add
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public void addWagonBack(Wagon wagon) {
		if (zug == null || zug.size() == 0) throw new NullPointerException();
		if (wagon == null) throw new IllegalArgumentException();
		zug.add(wagon);
	}
	
	/**
	 * Removes the wagon at the beginning of the train
	 * 
	 * @throws NullPointerException
	 */
	public void removeWagonFront() {
		if (zug == null || zug.size() == 0) throw new NullPointerException();
		zug.remove();
	}
	
	/**
	 * Removes the wagon at the end of the train
	 * 
	 * @throws NullPointerException
	 */
	public void removeWagonBack() {
		if (zug == null || zug.size() == 0) throw new NullPointerException();
		zug.removeLast();
	}
}
