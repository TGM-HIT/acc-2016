
/**
 * Dieses Programm entschlüsselot die gegebene Nachricht
 * 
 * @author Shai Dzindzihashvili 
 * @version 1.9
 */
public class A02Verschluesselung
{
        public static void main(String[] args){
            System.out.println(a("ZPV TPMWFE NZ QVAAMF"));
        }
    
        public static String a (String d){
            String c = "ZABCDEFGHIJKLMNOPQRSTUVWXY";
            String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String e = "";
            d = d.toUpperCase();
            for(int i = 0; i < d.length(); i++){
                char f = d.charAt(i);
                if(b.indexOf(f) > -1){
                    e += c.charAt(b.indexOf(f));
                }
                else{
                    e += f;
                }
            }
            return e; 
        }
    }
