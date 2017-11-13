package modliba;

/**
 * Diese Klasse testet die Zug/Waggon Implementierung
 * 
 * @author Daniel Modliba
 * @version 08-12-2016
 */
public class Test {

	/**
	 * Standard main-Methode des Programms
	 * 
	 * @param args
	 *            Die Argumente des Programms
	 * @since 08-12-2016
	 */
	public static void main(String[] args) {
		// Hier wird ein Zug erstellt
		Zug z = new Zug(new Reisewaggon(true, 20, 0));
		System.out.println(z);

		// Hier steigt in den ersten Waggon jemand ein
		z.getWaggons().get(0).einsteigen();
		System.out.println(z);

		// Hier wird ein weiterer Waggon angehängt
		z.anhangen(new Speisewaggon(false, 10, 2, 25, 25));
		System.out.println(z);

		// Hier wird im Speisewaggon eine Portion ausgegeben
		Speisewaggon rw = (Speisewaggon) z.getWaggons().get(1);
		rw.essenAusgeben();
		System.out.println(z);

		// Hier wird eine Portion Essen wieder aufgefüllt
		rw.essenAuffüllen();
		System.out.println(z);

		// Hier würde eine weitere Portion aufgefüllt werden, da aber das
		// Maximum überschritten wird -> Exception
		// rw.essenAuffüllen();

		// Hier wird ein Waggon abgehängt
		z.abhangen();
		System.out.println(z);

		// Hier wird ein weiterer Waggon abgehängt, da aber das Minimum bereits
		// erreicht ist -> Exception
		z.abhangen();
		System.out.println(z);
	}

}
