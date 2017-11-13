import java.util.ArrayList;

/**
 * Es wird ein Baum mit einer beliebigen Hoehe produziert, gespeichert und in der Konsole ausgegeben.
 * Model-Klasse für Baumfabrik
 * 
 * @author David Maniak
 * @version 07.12.2016
 */
public class Model {
	private ArrayList<Integer> trees;
	
	/**
	 * Default-Konstruktor
	 */
	public Model() {
		trees = new ArrayList<>();
	}
	
	/**
	 * Im Array wird die Hoehe des Baumes gespeichert, falls er mal erstellt werden will.
	 * 
	 * @param size die Hoehe des Baumes
	 */
	public void addTree(int size) {
		trees.add(size);
	}
	
	/**
	 * Es wird die Anzahl der gespeicherten Baeume zurueckgegeben.
	 * 
	 * @return die Anzahl der gespeicherten Baeume
	 */
	public int storedTrees() {
		return trees.size() + 1;
	}
	
	/**
	 * getter-Methode
	 * Es wird die Hoehe des angefragten Baumes zurueckgegeben.
	 * 
	 * @param index die Stelle im Array wo die Hoehe des Baumes gespeichert sein sollte
	 * @return die Hoehe des Baumes
	 */
	public int getTree(int index) {
		return trees.get(index);
	}
	
	/**
	 * setter-Methode, falls man eine bereits vorhandene ArrayList verwenden will.
	 * 
	 * @param trees die Hoehen der einzelnen Baeume in einer ArrayList
	 */
	public void setTree(ArrayList<Integer> trees) {
		this.trees = trees;
	}
}
