/**
 * Diese Klasse bietet die Basis für Spielzeugladen Objekte.
 * 
 * @author Hammer Viktoria 
 * @version 2016-12-12
 */
public class Spielzeuglade {
    //ATTRIBUTE
    private Spielzeug[] spielzeugliste;
    
    //KONSTRUKTOR
    /**
     * Dieser Konstruktor weist dem Array / der Schublade die Länge / Größe zu.
     * 
     * @param groesse die Größe der Schublade
     */
    public Spielzeuglade (int groesse) {
        spielzeugliste = new Spielzeug[groesse];
    }
    
    //METHODEN
    /**
     * Diese Methode fügt der Schublade ein weiteres Spielzeug hinzu, sofern in dieser noch Platz ist, 
     * wenn nicht, wird eine Fehlermeldung ausgegeben.
     * 
     * @param neu das Spielzeug, das hinzugefügt wird
     */
    public void hinzufuegen (Spielzeug neu) {
        boolean drinnen = false;    //um festzustellen, ob das Spielzeug hinzugefügt werden konnte
        
        for(int i=0; i < spielzeugliste.length; i++) {  //Durchgehen des Arrays
            //Wenn der aktuelle Index keine Referenz enthält (also an der Stelle noch kein Spielzeug ist) und noch keines hinzugefügt wurde
            if (spielzeugliste[i]==null && !drinnen) {  
                spielzeugliste[i]=neu;  //Spielzeug hinzufügen
                drinnen = true; //und boolean auf true, da jetzt ein Spielzeug hinzugefügt wurde
            } 
        }
        
        //Wenn trotz des Durchgehens kein Spielzeug hinzugefügt wurde, wird davon ausgegangen, dass die Schublade voll ist 
        if (!drinnen) {
            System.out.println("Diese Spielzeuglade ist breits voll!"); //und dem entsprechend eine Fehlermeldung ausgegeben
        }
    }
    
    /**
     * Diese Methode wandelt den Inhalt einer Schublade in Textform um
     * 
     * @return den Inhalt in Text-/Auflistungsform
     */
    public String toString() {
        String text = "In dieser Spielzeuglade der Größe " + spielzeugliste.length + " befinden sich folgende Spielzeuge:\n";
        
        for (int i=0; i < spielzeugliste.length; i++) { //Durchgehen des Arrays 
            if (spielzeugliste[i]!=null) {  //wenn die aktuelle Stelle nicht leer ist (die Schublade muss nicht voll sein)
                //hinzufügen der aktuellen Stelle im Array zur Ausgabe
                text = text + "- " + spielzeugliste[i].toString() + "\n";   //(die Ausgabe würde auch ohne .toString funktionieren)
            }
        }
        
        return text;
    }
}
