/**
 * Exception die auftritt, wenn eine Rechnung sich nicht berechnen laesst.
 * 
 * @author David Maniak
 * @version 19.12.2016
 */
public class InvalidCalculationException extends RuntimeException {
	/**
	 * Konstruktor bei dem die Nachricht mitgegeben werden kann
	 * 
	 * @param msg die Nachricht die mitgegeben wird.
	 */
	public InvalidCalculationException(String msg) {
		super(msg);
	}
}
