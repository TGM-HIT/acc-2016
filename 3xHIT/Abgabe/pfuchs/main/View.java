package main;

/**
 * The View shows for the graphical View for the user
 * 
 * @author Peter Fuchs
 * @version 7 Dec 2016
 */
public class View {

	/**
	 * Draws a tree
	 * 
	 * @param tree the tree that gets drawn
	 * @throws IllegalArgumentException
	 */
	public void drawTree(Tree tree) {
		if (tree == null) throw new IllegalArgumentException();
		System.out.println("/* Baum der Größe " + tree.getSize() + " */");
		System.out.println(">>");
		int size = 1;
		for (int i = 0; i < tree.getSize(); i++) {
			System.out.print(">> ");
			for (int j = tree.getSize()-size; j > 0; j--)
				System.out.print(" ");
			for (int j = 0; j < 2*i+1; j++)
				System.out.print("#");
			System.out.println("");
			size++;
		}
		System.out.println(">>\n");
	}

}
