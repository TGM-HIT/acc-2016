/**
 * Diese Klasse enthält zwei Methoden zur Textver-/entschlüsselung.
 * 
 * @author Hammer Viktoria
 * @version 2016-12-10
 */
public class A02Entschlüsselung {
    //ORIGINALES PROGRAMM
    public static String stringa (String d) {
        String c = "BCDEFGHIJKLMNOPQRSTUVWXYZA";
        String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String e = "";
        d = d.toUpperCase();
        
        for(int i=0; i < d.length(); i++) {
            char f = d.charAt(i);
            if(b.indexOf(f)>-1){
                e+= c.charAt(b.indexOf(f));
            } else{
                e+=f;
            }
        }
        
        return e;
    }
    
    //ENTSCHLÜSSELUNG DER NACHRICHT
    /**
     * Diese Methode entschlüsselt die Nachricht, die aus dem originalen Programm hervorgegangen ist.
     * 
     * @param v der verschlüsselte Text
     * @return den entschlüsselten Text
     */
    public static String entschluesselung (String v) {  
        //damit die Methode allgemein verwendbar ist, man kann aber auch einfach den Paramter löschen 
        //und das hier wieder unkommentieren.
        //v = "ZPV TPMWFE NZ QVAAMF"; 
        
        //die beiden Strings mussten zur Lösung des Programmes einfach nur getauscht werden
        String b = "BCDEFGHIJKLMNOPQRSTUVWXYZA";    
        String c = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String e = "";  //Variable für den entschlüsselten Text
        
        for(int i=0; i < v.length(); i++) { //Zuweisen der jeweiligen Stellen im normalen Alphabet
            char f = v.charAt(i);
            if(b.indexOf(f)>-1){
                e+= c.charAt(b.indexOf(f));
            } else{
                e+=f;
            }
        }
        
        e = e.toLowerCase();    //optionale Umkehrung der Großbuchstaben zu Kleinbuchstaben
        return e;   //"ZPV TPMWFE NZ QVAAMF" -> "you solved my puzzle"
    }
   
}
