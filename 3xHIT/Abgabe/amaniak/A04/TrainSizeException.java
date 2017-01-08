/**
 * Exception die gethrowed wird, wenn der Zug nur mehr einen Wagon hat und man einen entfernen will
 * 
 * @author David Maniak
 * @version 12.12.2016
 */
public class TrainSizeException extends RuntimeException {
	/**
	 * Konstruktor bei dem der Exception eine Nachricht mitgegeben werden kann.
	 * 
	 * @param msg die gesetzte Nachricht
	 */
	public TrainSizeException(String msg) {
		super(msg);
	}
}
