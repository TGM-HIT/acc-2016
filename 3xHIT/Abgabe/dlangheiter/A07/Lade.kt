/**
 * Created by david on 16.12.2016.
 */

class Lade (size: Int, val type: Type) {
    private var spielzeug: Array<Spielzeug?> = arrayOfNulls(size)
    private var c: Int = 0

    fun add(spiel: Spielzeug) {
        if(spiel.type == type) {
            spielzeug[c] = spiel
            c++
        }
    }

    fun list() {
        for(i in spielzeug) {
            if(i != null) {
                print(i.toString() + "\n")
            }
        }
    }

}