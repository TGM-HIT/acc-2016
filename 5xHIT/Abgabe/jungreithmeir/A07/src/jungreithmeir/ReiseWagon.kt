package jungreithmeir

/**
 * ReiseWagon strategy which gives some error messages if you too many passengers try to enter of if to many (ghosts?)
 * try to leave.
 *
 * @author Jakob Jungreithmeir
 * @version 1.0 15-12-2016
 * @constructor Creates basic ReiseWagon with a maximum number of 100 passengers. At construction the wagon is empty.
 * Also throws a IllegalArgumentException if you try to initialize it with more passengers than possible.
 */
class ReiseWagon constructor(private val maxPassengers: Int = 100, private var passengers: Int=0): WagonType(passengers) {

    init {
        super.type = Type.REISEWAGON
        if (this.passengers > this.maxPassengers)
            throw IllegalArgumentException("More passengers than possible have entered the wagon.")
    }

    /**
     * More verbose addition process.
     * @param passengers
     */
    override fun add(passengers: Int) {
        if (super.resource + passengers <= maxPassengers)
            super.resource += passengers
        else
            println("Sorry there are no more places left.")
    }

    /**
     * More verbose removal process.
     * @param passengers
     */
    override fun remove(passengers: Int) {
        if (super.resource - passengers >= 0)
            super.resource -= passengers
        else
            println("There aren't as many people in the wagon.")
    }
}