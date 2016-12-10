
/**
 * Write a description of class entschlüesung here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class entschlüesung
{
    public static void main(String[] args){
        String b="ZPV TPMWFE NZ QVAAMF";
        System.out.println(a(b));
    }

    static String a(String d){
        String c="ZABCDEFGHIJKLMNOPQRSTUVWXY";
        String b="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String e="";
        d=d.toUpperCase();
        for(int i=0;i<d.length();i++){
            char f=d.charAt(i);
            if(b.indexOf(f)>-1){
                e+=c.charAt(b.indexOf(f));
            }
            else{
                e+=f;
            }
        }
        return e;
    }
    }


