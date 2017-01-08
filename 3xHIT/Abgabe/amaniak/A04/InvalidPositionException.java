/**
 * Exception die gethrowed wird, wenn eine ungueltige Position des Wagons angegeben wird.
 * Gueltige Positionen für das an-&abhaengen eines Wagons: vorne ('v') und hinten ('h').
 * 
 * @author David Maniak
 * @version 12.12.2016
 */
public class InvalidPositionException extends RuntimeException {
	/**
	 * Konstruktor bei dem der Exception eine Nachricht mitgegeben werden kann.
	 * 
	 * @param msg die gesetzte Nachricht
	 */
	 public InvalidPositionException(String msg) {
		super(msg);
	}
}
