package modliba;

import java.util.ArrayList;

import exceptions.KeineWaggonsException;

/**
 * Diese Klasse modelliert einen Zug
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public class Zug {

	// Die Waggon die an der Zugmaschine hngen
	private ArrayList<Waggon> waggons = new ArrayList<Waggon>();

	/**
	 * Hngt den hintersten Waggon ab, -> Der letzte Eintrag der Liste wird
	 * removed, Falls das nicht mglich ist wird eine entsprechnde Exception
	 * geworfen
	 * 
	 * @since 08-12-2016
	 */
	public void abhangen() {
		if (waggons.size() <= 1) {
			throw new KeineWaggonsException();
		}
		waggons.remove(waggons.size() - 1);
	}

	/**
	 * Hngt einen Waggon hinten an den Zug an, 'w' wird am Ende der Liste
	 * hinzugefgt, Falls das nicht mglich ist wird eine entsprechende
	 * Exception geworfen
	 * 
	 * @param w
	 *            Der Waggon der angehngt werden soll
	 * @since 08-12-2016
	 */
	public void anhangen(Waggon w) {
		waggons.add(w);
	}

	public Zug(Waggon w) {
		waggons.add(w);
	}

	public String toString() {
		String r = "";
		for (int i = waggons.size() - 1; i >= 0; i--) {
			r += waggons.get(i);
		}
		r += "V\nV - Zugmaschine\nV\n\n";
		return r;
	}

	public ArrayList<Waggon> getWaggons() {
		return waggons;
	}

	public void setWaggons(ArrayList<Waggon> waggons) {
		this.waggons = waggons;
	}

}
