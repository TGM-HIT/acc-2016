
/**
 * Beschreiben Sie hier die Klasse Main.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Main
{
   public static void main(String[] arg0){
       java.util.Scanner s = new java.util.Scanner(java.lang.System.in);
       while(true)
       {
           
           java.lang.System.out.println("Gib die groesse des Baumes ein!");
           java.lang.String in = s.nextLine();
           if(in.equalsIgnoreCase("exit"))
                break;
           try{
               int h = java.lang.Integer.parseInt(in);
               for(int i = 1;i<=h;i++)
               {
                   for(int z = (h-i);z>0;z--)
                   {
                       java.lang.System.out.print(" ");
                   }
                   for(int x = (i*2)-1;x>0;x--)
                   {
                       java.lang.System.out.print("#");
                   }
                   java.lang.System.out.println("");
               }
           }
           catch(java.lang.Exception e)
           {
               java.lang.System.out.println("Das war keine Zahl!");
               continue;
           }
       }
   }
}
