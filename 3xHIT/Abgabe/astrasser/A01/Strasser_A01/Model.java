package Strasser_A01;

import java.util.ArrayList;

/**
 * Class to save the sizes of multiple trees
 * 
 * @author Alexander Strasser
 * @version 2016-12-06
 *
 */
public class Model {
	private ArrayList<Integer> trees;
	
	/**
	 * Constructor that initializes the trees-ArrayList with a new ArrayList
	 */
	public Model() {
		trees = new ArrayList<Integer>();
	}
	
	/**
	 * Adds a new tree to the end of the list of trees
	 * 
	 * @param size the size of the new tree to add, must not be less than 0
	 */
	public void addTree(int size) {
		if(size < 0 )
			throw new IllegalArgumentException();
		
		trees.add(size);
	}
	
	/**
	 * Returns the number of stored trees
	 * 
	 * @return number of trees
	 */
	public int storedTrees() {
		return trees.size();
	}
	
	/**
	 * Returns the tree-size of the tree with the given index
	 * 
	 * @param index the tree-index
	 * @return the tree-size
	 */
	public int getTree(int index) {
		return trees.get(index);
	}
}
