
/**
 * Write a description of class buam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class buam{
    public static void main(String[] args) {
        int a,b;
        String eingabe,doppel;
        doppel="#";
        eingabe=JOptionPane.showInputDialog("wie groß baum=?????????");
        a=Integer.parseInt(eingabe);
        for(int i=0;i<a;i++){
            for(int j=0;j<a-i;j++){
                System.out.print(" ");
            }
            System.out.println(""+doppel);
            doppel+="##";

        }
    }
}
