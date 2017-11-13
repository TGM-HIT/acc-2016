public class CodingContest {
    public static String encrypter() {
        String a;
        String b;
        String c;
        c = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";   //b und c vertauschen um zu entschluesseln.
        b = "BCDEFGHIJKLMNOPQRSTUVWXYZA";
        String d = "ZPV TPMWFE NZ QVAAMF";
        String e = "";
        d = d.toUpperCase();
        for(int i=0; i < d.length(); i++) {
            char f = d.charAt(i);
            if(b.indexOf(f)>-1) //ob der buchstabe 'f' in 'b' vorkommt.
            {
                e += c.charAt(b.indexOf(f)); //sucht den buchstaben 'f' in 'b' und verwendet den selben index 
                                            //um den buchstaben an der stelle auszugeben. 
            } else {
                e += f;     //wenn f nicht enthalten ist, diesen buchstaben nicht verschluesseln.
            }
        }
        
        return e;
    }   //"ZPV TPMWFE NZ QVAAMF" ---> YOU SOLVED MY PUZZLE
        //ZFT J EJE
            
    public static void main(String[] args) {
        System.out.println(encrypter());
    }
}
