/**
 * Es werden Spielzeugschrank mit einer maximalen Anzahl an Spielzeugladen erstellt.
 * Eine Lade darf nur Spiele von einem Typen drinnen haben, um in den Schrank zu duerfen.
 * 
 * @author David Maniak
 * @version 17.12.2016
 * 
 * 
 * Konstruktor bei dem die Groesse der Lade bestimmt werden kann.
 * 
 * @param size die maximale Anzahl an Spielzeugen in der Lade
 */
class Spielzeugschrank(val size : Int) {
    var laden = 0
    var schrank = arrayOfNulls<Spielzeuglade>(size)
    
    /**
     * Es werden Laden in den Schrank hinzugefuegt, wenn sie nur Spiele von einem Typ haben
     */
    fun addDrawer(e : Spielzeuglade) {
        if(laden < schrank.size && e.allEqual()) {
        	schrank[laden] = e
            laden++
        } else if(laden >= schrank.size) {
            println("Schrank ist voll!" + 
                    "\n====================")
        } else if(!e.allEqual()) {
            println("Lade darf nur Spiele vom selben Typen haben!" +
            		"\n====================")
        }
    }
}