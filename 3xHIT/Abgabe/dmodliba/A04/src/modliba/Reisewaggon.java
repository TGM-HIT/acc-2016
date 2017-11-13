package modliba;

/**
 * Diese Klasse modelliert einen Reisewaggon
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public class Reisewaggon extends Waggon {

	public Reisewaggon(boolean isOpen, int maxPersons, int currentPersons) {
		super(isOpen, maxPersons, currentPersons);
	}

	public String toString() {
		String r = super.toString();

		r += getPrefix() + "\n~\n";
		return r;
	}

}
