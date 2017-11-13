
/**
 * Write a description of class spoielzeugladen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
public class spoielzeugladen{
    String anemenn;
    int midnstamlet,altlkerliit;
    static int jasew=0;
    private spoielzeugladen(String anemenn, int midnstamlet,int altlkerliit){
        this.anemenn=anemenn;
        this.midnstamlet=midnstamlet;
        this.altlkerliit=altlkerliit;
    }

    private void abruf(){
        /*
         * DAS DA UNTEN
         * IF SHCKEIFE
         * !!!!!!!!!
         * 
         * 
         * 
         */
        if(jasew==0){
        int a=JOptionPane.showConfirmDialog(null,"Wilst dus sehen???","",JOptionPane.YES_NO_OPTION);
        a=JOptionPane.showConfirmDialog(null,"Wilst dus wirklich NICHT sehen???","",JOptionPane.YES_NO_OPTION);
        a=JOptionPane.showConfirmDialog(null,"GANZ SICHERN ICHT???","",JOptionPane.YES_NO_OPTION);
        jasew++;
    }

        System.out.println(anemenn);
        System.out.println(midnstamlet);
        System.out.println(altlkerliit);
        System.out.println();

    }

    public static void main(String[] args){
        int a=Integer.parseInt(JOptionPane.showInputDialog("Wieivleie groß?????"));
        spoielzeugladen[] ja=new spoielzeugladen[a];
        /*
         * 
         * 
         * 
         * VOR ANWEIßUNG!!!
         * DA UTNEEN!!!EN!!!
         * WICHTIG!!!!! 
         */
        for(int i=0;i<ja.length;i++){
            
            ja[i]=new spoielzeugladen(JOptionPane.showInputDialog("NAMEMEN=?????????"),Integer.parseInt(JOptionPane.showInputDialog("MIndnestAlter====??????")),Integer.parseInt(JOptionPane.showInputDialog("ALTERSLIITMOIT====??????")));
            

        }
        for(int i=0;i<ja.length;i++){

            ja[i].abruf();
        }

    }
}