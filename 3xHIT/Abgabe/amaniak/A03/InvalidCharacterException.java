/**
 * Exception welche gethrowed wird, wenn der Benutzer einen Namen mit ungueltigen Zeichen eintippt.
 * 
 * @author David Maniak
 * @version 09.12.2016
 */
public class InvalidCharacterException extends RuntimeException {
	/**
	 * Konstruktor bei dem der Exception eine Nachricht mitgegeben werden kann.
	 * 
	 * @param msg die gesetzte Nachricht
	 */
	public InvalidCharacterException(String msg) {
		super(msg);
	}
}
