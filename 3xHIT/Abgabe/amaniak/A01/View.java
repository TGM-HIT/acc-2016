/**
 * Es wird ein Baum mit einer beliebigen Hoehe produziert, gespeichert und in der Konsole ausgegeben.
 * View-Klasse für Baumfabrik
 * 
 * @author David Maniak
 * @version 07.12.2016
 */
public class View {
	/**
	 * Default-Konstruktor
	 */
	public View() {
		
	}
	
	/**
	 * Es soll ein Baum mit beliebiger Hoehe in der Konsole gezeichnet werden.
	 * 
	 * zum Beispiel ein Baum mit der Hoehe 5:
	 *      #
	 *     ###
	 *    #####
	 *   #######
	 *  #########
	 *  
	 * @param size die Hoehe des Baumes
	 */
	public void drawTree(int size) {
		//Damit man auch einen Output bekommt, wenn die Hoehe des Baumes 0 entspricht.
		if(size == 0) {
			System.out.println("Größe des Baumes ist 0, deswegen wird nichts angezeigt.");
			return;
		}
		
		// '#' als Variable gespeichert, falls man sich für ein anderes Zeichen entscheidet.
		char sign = '#';
		int line = 1;
		int spacing = size - 1;
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < spacing; j++)
				System.out.print(' ');
			
			spacing--;
			
			for(int j = 0; j < line; j++)
				System.out.print(sign);
			
			line += 2;
			System.out.print("\n");
		}
	}
}
