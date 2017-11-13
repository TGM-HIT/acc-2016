package Baumfabrik;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 
 * @author Michael Ebenstein
 * @version 6.12.2016
 * 
 */

public class Model {
	
	private ArrayList<ArrayList<ArrayList<Boolean>>> trees;;
	private int storedTrees = 0;
	
	public Model(){
		trees = new ArrayList<>();
	}
	
	public void addTree(int size){
		ArrayList<ArrayList<Boolean>> tree = new ArrayList<>();
		
		int offBeg = 0,offEnd = size*2 -1;
		for(int i = 0; i < size;++i){
			ArrayList<Boolean> row = new ArrayList<>();
			for(int j = 0; j < size*2 -1;++j){
				if(j < offBeg|| j >= offEnd)
					row.add(false);
				else 
					row.add(true);
			}
			
			tree.add(row);
			
			offBeg += 1;
			offEnd -= 1;
		}
		Collections.reverse(tree);
		trees.add(tree);
		storedTrees++;
	}
	
	public int storedTrees(){
		return storedTrees;
	}
	
	public ArrayList<ArrayList<Boolean>> getTree(int i){
		if(i < 0 || i > storedTrees)throw new IllegalArgumentException();
		
		return trees.get(i);
	}
	
}
