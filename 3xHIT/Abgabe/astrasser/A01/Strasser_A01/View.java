package Strasser_A01;

/**
 * Class to output trees to the console
 * 
 * @author Alexander Strasser
 * @version 2016-12-06
 *
 */
public class View {
	
	/**
	 * Outputs a tree of the given size to the console
	 * 
	 * @param treeSize size of the tree to output
	 */
	public void drawTree(int treeSize) {
		String outputString = "/* Baum der Groesse "+treeSize+" */\n>>\n";
		
		for(int i = 0; i < treeSize; ++i) {
			outputString += ">>  ";
			
			for(int j = 0; j < treeSize - 1 - i; ++j)
				outputString += " ";
			
			for(int j = 0; j < 2 * i + 1; ++j)
				outputString += "#";
			
			outputString += "\n";
		}
		
		outputString += ">>\n\n";
		
		System.out.print(outputString);
	}
}
