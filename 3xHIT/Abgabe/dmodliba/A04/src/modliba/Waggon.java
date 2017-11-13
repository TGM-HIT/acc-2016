package modliba;

import exceptions.WaggonEmptyException;
import exceptions.WaggonFullException;

/**
 * Diese Klasse modelliert einen Waggon Da eine Waggon ENTWEDER ein Speisewaggon
 * ODER ein Reisewaggon sein soll, wurde diese Klasse als 'abstract'
 * implementiert
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public abstract class Waggon {

	// Gibt an ob der Waggon offen ist oder nicht, wenn offen -> true
	private boolean isOpen;
	// Gibt die maximalen Personen des Waggons an
	private int maxPersons;
	// Gibt die Personen an die sich aktuell im Waggon befinden
	private int currentPersons;
	// Ein Präfix das für die Ausgabe auf die Konsole bentigt wird
	private String prefix;

	/**
	 * Lsst eine Person in den Waggon eisnteigen -> 'currentPersons' wird um 1
	 * grer, Falls das nicht mglich ist wird eine entsprechende Exception
	 * geworfen
	 * 
	 * @since 08-12-2016
	 */
	public void einsteigen() {
		if (currentPersons == maxPersons) {
			throw new WaggonFullException();
		}
		currentPersons++;
	}

	/**
	 * Lsst eine Person aus dem Waggon aussteigen -> 'currentPersons' wird um 1
	 * kleiner, Falls das nicht mglich ost wird eine entsprechende Exception
	 * geworfen
	 * 
	 * @since 08-12-2016
	 */
	public void aussteigen() {
		if (currentPersons == 0) {
			throw new WaggonEmptyException();
		}
		currentPersons--;
	}

	public Waggon(boolean isOpen, int maxPersons, int currentPersons) {
		this.isOpen = isOpen;
		this.maxPersons = maxPersons;
		this.currentPersons = currentPersons;
	}

	public String toString() {
		if (isOpen) {
			prefix = "|";
		} else {
			prefix = "#";
		}

		String r = prefix + "\n";
		r += prefix + " - Personen: " + currentPersons + "/" + maxPersons + "\n";

		return r;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public int getMaxPersons() {
		return maxPersons;
	}

	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}

	public int getCurrentPersons() {
		return currentPersons;
	}

	public void setCurrentPersons(int currentPersons) {
		this.currentPersons = currentPersons;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}
