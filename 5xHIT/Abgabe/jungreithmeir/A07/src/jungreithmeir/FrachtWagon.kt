package jungreithmeir

/**
 * FrachtWagon strategy which gives some error messages if you too much cargo is loaded or if too much is withdrawn.
 *
 * @author Jakob Jungreithmeir
 * @version 1.0 15-12-2016
 * @constructor Creates basic FrachtWagon with a maximum number of 1000 cargo units. At construction the wagon is empty.
 * Also throws a IllegalArgumentException if you try to initialize it with more cargo than possible.
 */class FrachtWagon constructor(private val maxCargo: Int = 1000, private var cargo: Int = 0): WagonType(cargo) {

    init {
        super.type = Type.FRACHTWAGON
        if (this.cargo > this.maxCargo)
            throw IllegalArgumentException("The wagon can not hold that much cargo.")
    }

    /**
     * More verbose loading process.
     * @param cargo
     */
    override fun add(cargo: Int) {
        if (super.resource + cargo <= maxCargo)
            super.resource += cargo
        else
            println("Sorry the wagon is already full.")
    }

    /**
     * More verbose unloading process.
     * @param cargo
     */
    override fun remove(cargo: Int) {
        if(super.resource - cargo >= 0)
            super.resource -= cargo
        else
            println("There is not as much left as you'd like to have.")
    }
}