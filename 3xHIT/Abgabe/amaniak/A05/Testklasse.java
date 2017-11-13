/**
 * Es werden alle Funktionen der Klasse Fibonacci.java getestet.
 * 
 * @author David Maniak
 * @version 17.12.2016
 */
public class Testklasse {
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		
		//Es wird 5 mal um die Eingabe einer Zahl fuer eine Fibonacci Zahl gefragt
		for (int i = 0; i < 5; i++) {
			f.read();
		}
		
		//Dann werden die 5 gespeicherten Zahlen ausgegeben
		System.out.println(f.toString());
		
		//Es wird nach einer Zahl gefragt bis dahin Fibonacci Zahlen erstellt werden
		f.viewTo();
	}
}
