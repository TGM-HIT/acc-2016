
/**
 * A10
 * 
 * @author Sebastian Grünewald 
 * @version 21-12-2016
 */

public class Rasterdrehung
{
    /** statische Attribute */
    static String standardPosition[][] = new String[4][5];
    static String drehenPosition[][] = new String[4][5];

    /**
     * Diese Methode analyisiert das gegebene Raster und trägt die Werte dann in das 2D Array ein
     * @param z1    Zeile 1 des gegebenen Rasters
     * @param z2    Zeile 2 des gegebenen Rasters
     * @param z3    Zeile 3 des gegebenen Rasters
     * @param z4    Zeile 4 des gegebenen Rasters
     */
    public static void analysieren (String z1, String z2, String z3, String z4) {
        char c;

        for (int i = 0; i < z1.length(); i++) {
            c = z1.charAt(i);

            standardPosition[0][i] = c+"";
        }

        for (int i = 0; i < z2.length(); i++) {
            c = z2.charAt(i);

            standardPosition[1][i] = c+"";
        }

        for (int i = 0; i < z3.length(); i++) {
            c = z3.charAt(i);

            standardPosition[2][i] = c+"";
        }

        for (int i = 0; i < z4.length(); i++) {
            c = z4.charAt(i);

            standardPosition[3][i] = c+"";
        }
    }

    /**
     * Diese Methode dreht das Raster einmal
     */
    public static void drehen90 () {
        String z1 = "";
        String z2 = "";
        String z3 = "";
        String z4 = "";
        String z5 = "";

        for (int i = 0; i < standardPosition.length; i++) {
            z1 += standardPosition[i][4]+" ";  
        }
        for (int i = 0; i < standardPosition.length; i++) {
            z2 += standardPosition[i][3]+" ";  
        }
        for (int i = 0; i < standardPosition.length; i++) {
            z3 += standardPosition[i][2]+" ";  
        }
        for (int i = 0; i < standardPosition.length; i++) {
            z4 += standardPosition[i][1]+" ";  
        }
        for (int i = 0; i < standardPosition.length; i++) {
            z5 += standardPosition[i][0]+" ";  
        }

        System.out.println(z1);
        System.out.println(z2);
        System.out.println(z3);
        System.out.println(z4);
        System.out.println(z5);
    }

    /**
     * Diese Methode gibt den Standard aus 
     */
    public static void standardAusgeben () {
        for ( int zeile = 0; zeile < standardPosition.length; zeile++ ){
            for ( int spalte=0; spalte < standardPosition[zeile].length; spalte++ ) {
                System.out.print(standardPosition[zeile][spalte] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Main - Methode
     */
    public static void main (String[] args) {
        String zeile1 = "---o-";
        String zeile2 = "-o---";
        String zeile3 = "---o-";
        String zeile4 = "-o---";

        analysieren(zeile1,zeile2,zeile3,zeile4);
        
        standardAusgeben();
        System.out.println();
        
        drehen90();
        System.out.println();
        
        standardAusgeben();
        System.out.println();
        
        drehen90();
    }
}
