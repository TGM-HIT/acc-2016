package main;

/**
 * Has an Array of Tree-Objects as an attribute
 * 
 * @author Peter Fuchs
 * @version 7 Dec 2016
 */
public class Model {
	private Tree[] trees;
	
	/**
	 * Constructor
	 */
	public Model() {
		trees = new Tree[0];
	}

	/**
	 * Adds a tree to the array
	 * @param i the size of the tree
	 * @throws NullPointerException
	 */
	public void addTree(int i) {
		if (trees == null) throw new NullPointerException();
		Tree[] help = new Tree[trees.length+1];
		for (int j = 0; j < trees.length; j++)
			help[j] = trees[j];
		help[help.length-1] = new Tree(i);
		trees = help;
	}

	/**
	 * @return the size of the array
	 * @throws NullPointerException
	 */
	public int storedTrees() {
		if (trees == null || trees.length == 0) throw new NullPointerException();
		return trees.length+1;
	}

	/**
	 * Returns a tree of the array
	 * 
	 * @param i the index of the element that gets returned
	 * @return the element at the index i
	 */
	public Tree getTree(int i) {
		if (trees == null || trees.length == 0) throw new NullPointerException();
		if (i < 0 || i > trees.length) throw new IllegalArgumentException();
		return trees[i];
	}

}
