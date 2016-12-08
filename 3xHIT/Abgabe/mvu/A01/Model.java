import java.util.ArrayList;

/**
 * 
 * @author David Vu
 * @version 7.12.2016
 */
public class Model {

	//ArrayList mit allen Tree elementen
	private ArrayList<Integer> tree;

	/**
	 * Initaliesiert Tree Arraylist
	 */
	public Model() {
		tree = new ArrayList<Integer>();
	}

	/**
	 * Gibt den Integer im Arraylist auf dem index aus
	 * @param index Bestimme Stelle im ArrayList
	 * @return Gibt Integer auf der bestimmten Stelle zurück
	 */
	public int getTree(int index) {
		return tree.get(index);
	}

	/**
	 * Fügt ein Integer Element zur Arraylist
	 * @param treeAmount
	 */
	public void addTree(int treeAmount) {
		tree.add(treeAmount);
	}
	
	/**
	 * Gesamte anzahl von Element in der Arraylist
	 * @return Anzahl vorhandener Elemente im Arraylist
	 */
	public int storedTrees(){
		return tree.size();
	}
}
