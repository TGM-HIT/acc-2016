package main;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Shows the user the result in a panel
 * 
 * 
 * @author Peter Fuchs
 * @version 19 Dec 2016
 */
@SuppressWarnings("serial")
public class EndPanel extends JPanel {
	/**
	 * Constructor<br>
	 * Creates a JPanel that provides all the info for the user<br>
	 * With a sorted result!
	 * 
	 * @param rennen the model
	 */
	public EndPanel(Rennen rennen) {
		String text = "<html><body><h1 style=\"text-align: center;\">Ergebnis:</h1><br>";
		Map<Teilnehmer, Integer> punkte = new HashMap<Teilnehmer, Integer>();
		
		for (Teilnehmer t: rennen.getTeilnehmer())
			punkte.put(t, t.getPunkte());
		
		SortedSet<Map.Entry<Teilnehmer, Integer>> set = entriesSortedByValues(punkte);

		Iterator<Entry<Teilnehmer, Integer>> it = set.iterator();
		int count = 1;
		while (it.hasNext()) {
			Entry<Teilnehmer, Integer> t = it.next();
			text += "<p style=\"text-align: center\">"+count+t.getKey().getName()+": "+t.getKey().getPunkte()+"</p><br>";
			count++;
		}
		
		text+="</body></html>";
		add(new JLabel(text));
	}
	
	/**
	 * @param map the map to sort
	 * @return a map sorted by the values
	 */
	static <K,V extends Comparable<? super V>>
	SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
	        new Comparator<Map.Entry<K,V>>() {
	            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	                int res = e2.getValue().compareTo(e1.getValue());
	                return res != 0 ? res : 1;
	            }
	        }
	    );
	    sortedEntries.addAll(map.entrySet());
	    return sortedEntries;
	}

}
