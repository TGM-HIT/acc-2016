/**
 * Es werden Spielzeugladen mit einer maximalen Anzahl an Spielzeugen erstellt.
 * 
 * @author David Maniak
 * @version 17.12.2016
 * 
 * 
 * Konstruktor bei dem die Groesse der Lade bestimmt werden kann.
 * 
 * @param size die maximale Anzahl an Spielzeugen in der Lade
 */
class Spielzeuglade(val size : Int) {
    var item = 0
    var lade = arrayOfNulls<Spielzeug>(size)
    
    /**
     * Es wird ein Spielzeug in die Lade hinzugefuegt
     * 
     * @param e das Spielzeug das hinzugefuegt werden soll
     */
    fun addItem(e : Spielzeug) {
        if(item < lade.size) {
        	lade[item] = e
            item++
            //println("Spielzeug erfolgreich hinzugefuegt." + 
            //        "\n====================")
        } else {
            println("Lade ist voll!" + 
                    "\n====================")
        }
    }
    
    /**
     * Zeigt alle Spielzeuge in der Lade an.
     */
    fun showItems() {
        for(i in 0..lade.size - 1) {
            if(lade.get(i) != null) {
            	println(lade.get(i)?.printInfo())
            }
        }
    }
    
    /**
     * Prueft ob alle Spielzeuge den selben Typen haben
     * 
     * @return true wenn alle Elemente in der Lade gleich sind, false wenn nicht
     */
    fun allEqual() : Boolean {
        val typ : String
        //Es wird das erste Spielzeug auf die Art geprueft und die restlichen muessen gleich sein
        if(lade.get(0) != null) {
        	typ = lade.get(0)!!.art
        } else {
            return false
        }
        
        for(i in 0..lade.size - 1) {
        	if(lade.get(i) != null) {
				if(!typ.equals(lade.get(i)!!.art)) {
                    return false
                }
            }
        }
        
        return true
    }
}