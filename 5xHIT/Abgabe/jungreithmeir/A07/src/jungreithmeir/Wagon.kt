package jungreithmeir

/**
 * Wagon class which holds a given functionality via a modified strategy pattern implementation.
 * Normally a class would hold a strategy via a simple generic strategy class member. In this case, however, the
 * Wagon instance is able to hold multiple strategies. In order to implement a set like behaviour, which only allows
 * a Wagon to hold one strategy of every type I implement this with a map, the key being an enum class from within the
 * strategy implementation. Under normal Java I would have used the .class as a key, but this is sadly not possible
 * under Kotlin therefor I have to use this rather hacky solution.
 *
 * @author Jakob Jungreithmeir
 * @version 1.0 15-12-2016
 * @constructor Creates a basic wagon which holds 100 persons and is opened. The default type is a ReiseWagon.
 */
class Wagon constructor(private val maxPersons: Int = 100,
                        private var open: Boolean = true,
                        initialTypes: MutableList<WagonType> = mutableListOf(ReiseWagon(maxPersons))
){

    private var types : MutableMap<Any, WagonType> = mutableMapOf()

    /**
     * @return map of strategies
     */
    fun getTypes(): MutableMap<Any, WagonType> = this.types

    /**
     * @param type - enum used in order to request specific strategy
     * @return specific strategy
     */
    fun getFunctionality(type: Type): WagonType? {
        return this.types[type]
    }

    /**
     * Initializing the strategy map.
     */
    init {
        for (wagonType in initialTypes) {
            types[wagonType.type] = wagonType
        }
    }

}