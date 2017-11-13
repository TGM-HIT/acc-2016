/**
 * Es werden Spielzeuge mit einem Namen, Mindestalter, Alterslimit und einem Spieletyp erstellt.
 * 
 * @author David Maniak
 * @version 17.12.2016
 * 
 * 
 * Konstruktor bei dem der Name, Mindestalter, Alterslimit und einem Spieletyp gesetzt werden kann.
 * 
 * @param name der Name des Spiels
 * @param minAge mindestAlter ab wann das Spiel gespielt werden darf
 * @param maxAge Alterlimit bis zu dem gespielt werden darf
 * @param type der Spielzeugtyp: 1 fuer Lego, 2 fuer Holzspielzeug und 3 fuer Kartenspiel
 */
public class Spielzeug {
    var art = "NoType"
    var name = "NoName"
    var minAge = -1
    var maxAge = -1
    
    public constructor(name : String, minAge : Int, maxAge : Int, type : Int) {
        this.name = name
        this.minAge = minAge
        this.maxAge = maxAge
        
        if(type == 1) {
            art = "Lego"
        } else if(type == 2) {
            art = "Holzspielzeug"
        } else if(type == 3) {
            art = "Kartenspiel"
        }
    }
    
    
    /**
     * Methode bei der alle Informationen in einen String gepackt werden.
     * 
     * @return die Informationen des Spielzeugs in einem String 
     */
    fun printInfo() : String {
        
        
        return "Name: " + name + 
        	   "\nMindestalter: " + minAge + 
        	   "\nMaximalalter: " + maxAge + 
        	   "\nArt: " + art + 
        	   "\n====================="
    }
}