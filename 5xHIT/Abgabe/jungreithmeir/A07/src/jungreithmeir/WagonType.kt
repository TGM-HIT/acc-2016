package jungreithmeir

/**
 * Basic abstract strategy class. Implements the basic resource management, as all types of Wagons simply hold different
 * things which are able to be increased or decreased later on. The only major design flaw of this class is the fact,
 * that the enum of strategies is stored here, which means that for every new strategy this class also needs to be
 * adapted. I believe this to be Kotlin's fault, as already mentioned in the Wagon class documentation.
 *
 * Also currently it is impossible to properly implement public getter and protected setter, generally getters & setters
 * can not have more visible modifiers than the attribute they are accessing. Come on Kotlin, cut me some slack here...
 * (http://stackoverflow.com/a/38269180)
 *
 * @author Jakob Jungreithmeir
 * @version 1.0 15-12-2016
 * @constructor Abstract class which prohibits direct initialization
 */

enum class Type {
    SPEISEWAGON, REISEWAGON, FRACHTWAGON
}

abstract class WagonType(var resource: Int = 100) {

    lateinit var type: Type

    /**
     * @param resource - number of resources to be added
     */
    open fun add(resource: Int) {
        this.resource += resource
    }

    /**
     * Adding one resource.
     */
    open fun add() {
        this.add(1)
    }

    /**
     * Only subtracts resources if the removal would not exceed the storage.
     *
     * @param resource - number of resources to be subtracted
     */
    open fun remove(resource: Int) {
        if (this.resource - resource >= 0)
            this.resource -= resource
    }

    /**
     * Removing a resource.
     */
    open fun remove() {
        this.remove(1)
    }
}