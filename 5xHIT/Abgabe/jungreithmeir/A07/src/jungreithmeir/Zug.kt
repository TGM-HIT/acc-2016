package jungreithmeir

/**
 * Basic class which acts as a wrapper for the container of Wagon objects and holds various management methods.
 *
 * @author Jakob Jungreithmeir
 * @version 1.0 15-12-2016
 * @constructor Creating basic train with one wagon.
 */
class Zug constructor(wagon: Wagon){

    private var wagons: MutableList<Wagon>

    init {
        wagons = mutableListOf(wagon)
    }

    /**
     * Adds new wagon at the beginning of the container.
     * @param wagon
     */
    fun attachHead(wagon: Wagon) {
        wagons.add(0, wagon)
    }

    /**
     * Adds a new wagon to the back of the container.
     * @param wagon
     */
    fun attachTail(wagon: Wagon) {
        wagons.add(wagon)
    }

    /**
     * Removes first wagon element.
     */
    fun detachHead() {
        wagons.removeAt(0)
    }

    /**
     * Removes last wagon element.
     */
    fun detachTail() {
        wagons.removeAt(wagons.size - 1)
    }

    /**
     * Returns wagon element with given position/index.
     * @param index - starting with 0
     */
    fun getWagon(index: Int): Wagon = wagons[index]

    /**
     * @return last wagon
     */
    fun getTail() : Wagon = this.getWagon(wagons.size - 1)

    /**
     * @return first wagon
     */
    fun getHead() : Wagon = this.getWagon(0)
}