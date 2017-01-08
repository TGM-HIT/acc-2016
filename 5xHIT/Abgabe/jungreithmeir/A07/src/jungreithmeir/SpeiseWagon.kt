package jungreithmeir

import jungreithmeir.Type.SPEISEWAGON

/**
 * SpeiseWagon strategy which gives some error messages if you try to withdraw to much food.
 *
 * @author Jakob Jungreithmeir
 * @version 1.0 15-12-2016.
 * @constructor Initializing basic SpeiseWagon, with 1000 food units by default.
 */
class SpeiseWagon constructor(food: Int = 1000): WagonType(food) {

    init {
        super.type = SPEISEWAGON
    }

    /**
     * More verbose removal method.
     * @param food
     */
    override fun remove(food: Int) {
        if (super.resource - food >= 0)
            super.resource -= food
        else
            println("Can not remove so much food.")
    }


}