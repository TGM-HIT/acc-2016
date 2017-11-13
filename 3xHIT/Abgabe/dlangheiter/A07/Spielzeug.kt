/**
 * Created by david on 16.12.2016.
 */

class Spielzeug(val name: String, val mindestAlter: Int, val altersLimit: Int, val type: Type){
    override fun toString(): String {
        return "Name: $name; MinAge: $mindestAlter; LimitAge: $altersLimit; Type: $type"
    }

}
