/**
 * Es werden alle Funktionen der Klassen Spielzeug, Spielzeuglade und Spielzeugschrank getestet
 */
class Testklasse {
    
}

fun main(args: Array<String>) {
    var schrank = Spielzeugschrank(2)
        
    var kartenLade = Spielzeuglade(3)
    var randomLade = Spielzeuglade(2)
        
    kartenLade.addItem(Spielzeug("Kartenspiel 1", 10, 99, 3))
    kartenLade.addItem(Spielzeug("Kartenspiel 2", 11, 33, 3))
    kartenLade.addItem(Spielzeug("Kartenspiel 3", 5, 9, 3))
        
    randomLade.addItem(Spielzeug("Holzspielzeug 1", 1, 4, 2))
    randomLade.addItem(Spielzeug("Kartenspiel 1", 3, 16, 3))
    //Es wird versucht ein Spielzeug hinzuzufuegen obwohl die Lade voll ist, um zu zeigen, dass es nicht funktioniert
    randomLade.addItem(Spielzeug("Lego 2", 1, 8, 1))
        
    schrank.addDrawer(kartenLade)
    //Es wird eine Lade mit unterschiedlichen Typen versucht hinzuzufuegen um zu zeigen, dass es nicht funktioniert
    schrank.addDrawer(randomLade)
        
    //Dann werden noch die Spielzeuge von der Lade mit unterschiedlichen Spieltypen in der Konsole ausgegeben
    randomLade.showItems()
}
