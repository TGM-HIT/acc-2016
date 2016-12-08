import java.util.ArrayList;
import java.util.List;

/**
 * Model class to Save diffrent Trees(sizes of them)
 * 
 * @author David Langheiter
 */
public class Model {
	private List<Integer> treeSizes;
	
	public Model() {
		treeSizes = new ArrayList<>();
	}
	
	/**
	 * Adds an Tree to the Model
	 * 
	 * @param size Size of the tree
	 */
	public void addTree(int size) {
		treeSizes.add(size);
	}
	
	/**
	 * Returns the number of stored trees
	 * 
	 * @return How many trees are stored
	 */
	public int storedTrees() {
		return treeSizes.size();
	}
	
	/**
	 * Gets an tree on the specific index
	 * 
	 * @param index Index of the tree
	 * @return THe size of the tree
	 */
	public int getTree(int index) {
		return treeSizes.get(index);
	}
	
}
