package modliba;

import exceptions.NoFoodException;
import exceptions.ReachedMaxFoodException;

/**
 * Diese Klasse modelliert einen Speisewaggon
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public class Speisewaggon extends Waggon {

	// Die Portionen die aktuell ausgegeben werden können
	private int currentPortionen;
	// Die Portionen die in diesem Waggon maximal gelagert werden können
	private int maxPortionen;

	/**
	 * Gibt eine Portion Essen aus -> 'currentPortionen' wird um 1 kleiner Falls
	 * das nicht möglich ist wird eine entsprechende Exception geworfen
	 * 
	 * @since 08-12-2016
	 */
	public void essenAusgeben() {
		if (currentPortionen == 0) {
			throw new NoFoodException();
		}
		currentPortionen--;
	}

	/**
	 * Lädt eine Portion Essen ein -> 'currentPortionen' wird um 1 größer Falls
	 * das nicht möglich ist wird eine entsprechende Exception geworfen
	 * 
	 * @since 08-12-2016
	 */
	public void essenAuffüllen() {
		if (currentPortionen == maxPortionen) {
			throw new ReachedMaxFoodException();
		}
		currentPortionen++;
	}

	public Speisewaggon(boolean isOpen, int maxPersons, int currentPersons, int maxPortionen, int portionen) {
		super(isOpen, maxPersons, currentPersons);
		this.currentPortionen = portionen;
		this.maxPortionen = maxPortionen;
	}

	public String toString() {
		String r = super.toString();
		r += getPrefix() + " - Portionen: " + currentPortionen + "/" + maxPortionen + "\n";
		r += getPrefix() + "\n~\n";
		return r;
	}

	public int getCurrentPortionen() {
		return currentPortionen;
	}

	public void setCurrentPortionen(int currentPortionen) {
		this.currentPortionen = currentPortionen;
	}

	public int getMaxPortionen() {
		return maxPortionen;
	}

	public void setMaxPortionen(int maxPortionen) {
		this.maxPortionen = maxPortionen;
	}
}
