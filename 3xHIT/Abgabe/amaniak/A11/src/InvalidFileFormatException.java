/**
 * Exception, welche ausgeloest wird wenn jemand die quiz.txt falsch modifiziert.
 * 
 * Falls man eigene Fragen adden will sollen sie folgenderweise angeordnet sein:
 * q:Frage
 * a:erste Antwort
 * a:zweite Antwort
 * a:dritte Antwort 
 * a:vierte Antwort
 * r:richtige Antwort
 * 
 * @author David Maniak
 * @version 22.12.2016
 */
public class InvalidFileFormatException extends RuntimeException {
	/**
	 * Konstruktor bei dem eine Nachricht gesetzt werden kann.
	 * 
	 * @param msg die Nachricht mitgegeben wird
	 */
	public InvalidFileFormatException(String msg) {
		super(msg);
	}
}
