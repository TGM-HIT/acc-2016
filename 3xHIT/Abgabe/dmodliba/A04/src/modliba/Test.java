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

		// Hier wird ein weiterer Waggon angeh�ngt
		z.anhangen(new Speisewaggon(false, 10, 2, 25, 25));
		System.out.println(z);

		// Hier wird im Speisewaggon eine Portion ausgegeben
		Speisewaggon rw = (Speisewaggon) z.getWaggons().get(1);
		rw.essenAusgeben();
		System.out.println(z);

		// Hier wird eine Portion Essen wieder aufgef�llt
		rw.essenAuff�llen();
		System.out.println(z);

		// Hier w�rde eine weitere Portion aufgef�llt werden, da aber das
		// Maximum �berschritten wird -> Exception
		// rw.essenAuff�llen();

		// Hier wird ein Waggon abgeh�ngt
		z.abhangen();
		System.out.println(z);

		// Hier wird ein weiterer Waggon abgeh�ngt, da aber das Minimum bereits
		// erreicht ist -> Exception
		z.abhangen();
		System.out.println(z);
	}

}
