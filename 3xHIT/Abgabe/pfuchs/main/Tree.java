package main;

/**
 * Tree is an object that saves the size of the tree
 * 
 * @author Peter Fuchs
 * @version 7 Dec 2016
 */
public class Tree {
	private int size;

	/**
	 * Constructor
	 * 
	 * @param size the size of the tree
	 */
	public Tree(int size) {
		this.setSize(size);
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 * @throws IllegalArgumentException if the size is lower than 0
	 */
	public void setSize(int size) {
		if (size < 0) throw new IllegalArgumentException();
		this.size = size;
	}

}
