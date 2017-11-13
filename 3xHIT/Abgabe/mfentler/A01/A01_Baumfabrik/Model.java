package A01_Baumfabrik;

import java.util.*;

/**
 * Modelklasse
 * 
 * @author mario fentler
 * @version 06.12.2016
 */
public class Model {
	private ArrayList<Integer> al = new ArrayList<Integer>();

	public int storedTrees() {
		return al.size();
	}

	public int getTree(int i) {
		return al.get(i);
	}

	public void addTree(int i) {
		al.add(i);

	}

}
