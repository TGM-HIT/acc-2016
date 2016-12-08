/**
 * Der String "ZPV TPMWFE NZ QVAAMF" soll entschlüsselt werden.
 * 
 * @author David Maniak (3D HIT)
 * @version 06.12.2016
 */
public class Entschluesselung {
	/**
	 * Methode die den vorgegebenen Code fixed, damit es korrekt entschlüsselt wird.
	 * Die versteckte Nachricht lautet: "YOU SOLVED MY PUZZLE"
	 * 
	 * @param d der verschlüsselte String
	 * @return 	der entschlüsselte String
	 */
	String a(String d) {
		String c = "BCDEFGHIJKLMNOPQRSTUVWXYZA";
		String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String e = "";
		
		d = d.toUpperCase();
		
		for(int i = 0; i < d.length(); i++) {
			char f = d.charAt(i);
			
			if(b.indexOf(f) >- 1) {
				//c.charAt(b.indexOf(f); wurde auf b.charAt(c.indexOf(f); damit man die Eingabe korrekt entschlüsseln kann
				e += b.charAt(c.indexOf(f));
			} else {
				e += f;
			}
		}
		return e;
	}
	
	public static void main(String[] args) {
		System.out.println(new Entschluesselung().a("ZPV TPMWFE NZ QVAAMF"));
	}
}

