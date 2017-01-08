package jungreithmeir

import org.junit.Test
import org.junit.Assert

/**
 * This JUnit4 class tests against the requirements specified in the assignment.
 *
 * @author Jakob Jungreithmeir
 * @version 1.0 15-12-2016
 */
class Testing {
    @Test fun testBasicTrain() {
        val wagon = Wagon()
        val zug = Zug(wagon)
        Assert.assertEquals(wagon, zug.getHead())
    }

    @Test fun testAttachTrainHead() {
        val wagon = Wagon()
        val zug = Zug(Wagon(5, false, mutableListOf(FrachtWagon())))
        zug.attachHead(wagon)
        Assert.assertEquals(wagon, zug.getHead())
    }

    @Test fun testAttachTrainTail() {
        val wagon = Wagon()
        val zug = Zug(Wagon(5, false, mutableListOf(FrachtWagon())))
        zug.attachTail(wagon)
        Assert.assertEquals(wagon, zug.getTail())
    }

    @Test fun testDetachTrainHead() {
        val zug = Zug(Wagon(5, false, mutableListOf(FrachtWagon())))
        val wagon = Wagon()
        zug.attachTail(wagon)
        zug.detachHead()
        Assert.assertEquals(wagon, zug.getTail())
    }

    @Test fun testDetachTrainTail() {
        val wagon = Wagon()
        val zug = Zug(wagon)
        zug.attachTail(Wagon(5, false, mutableListOf(FrachtWagon())))
        zug.detachTail()
        Assert.assertEquals(wagon, zug.getTail())
    }

    @Test fun testWagonTypes() {
        val zug = Wagon(initialTypes = mutableListOf(SpeiseWagon(), ReiseWagon(), ReiseWagon()))
        Assert.assertEquals(2, zug.getTypes().size)
    }

    @Test fun testFoodWagonAddFood() {
        val initFood: Int = 100
        val food: Int = 50
        val zug = Zug(Wagon(10, true, mutableListOf(SpeiseWagon(initFood))))
        val foodWagon = zug.getHead().getFunctionality(Type.SPEISEWAGON)
        foodWagon?.add(food)
        Assert.assertEquals(initFood + food, foodWagon?.resource)
    }

    @Test fun testFoodWagonRemoveFood() {
        val initFood: Int = 100
        val food: Int = 50
        val zug = Zug(Wagon(10, true, mutableListOf(SpeiseWagon(initFood))))
        val foodWagon = zug.getHead().getFunctionality(Type.SPEISEWAGON)
        foodWagon?.remove(food)
        Assert.assertEquals(initFood - food, foodWagon?.resource)
    }

    @Test fun testFoodWagonRemoveFoodOverdraw() {
        val initFood: Int = 100
        val food: Int = 150
        val zug = Zug(Wagon(10, true, mutableListOf(SpeiseWagon(initFood))))
        val foodWagon = zug.getHead().getFunctionality(Type.SPEISEWAGON)
        foodWagon?.remove(food)
        Assert.assertEquals(initFood, foodWagon?.resource)
    }

    @Test fun testTravelWagonAddPassengers() {
        val maxPassengers: Int = 100
        val passengers: Int = 50
        val zug = Zug(Wagon(maxPassengers, true, mutableListOf(ReiseWagon(maxPassengers, 0))))
        val passengerWagon = zug.getHead().getFunctionality(Type.REISEWAGON)
        passengerWagon?.add(passengers)
        Assert.assertEquals(passengers, passengerWagon?.resource)
    }

    @Test fun testTravelWagonRemovePassengers() {
        val maxPassengers: Int = 100
        val leavingPassengers: Int = 50
        val initPassengers: Int = 75
        val zug = Zug(Wagon(maxPassengers, true, mutableListOf(ReiseWagon(maxPassengers, initPassengers))))
        val passengerWagon = zug.getHead().getFunctionality(Type.REISEWAGON)
        passengerWagon?.remove(leavingPassengers)
        Assert.assertEquals(initPassengers - leavingPassengers, passengerWagon?.resource)
    }

    @Test fun testTravelWagonAddPassengersOverdraw() {
        val maxPassengers: Int = 100
        val initPassengers: Int = 0
        val passengers: Int = 150
        val zug = Zug(Wagon(maxPassengers, true, mutableListOf(ReiseWagon(maxPassengers, initPassengers))))
        val passengerWagon = zug.getHead().getFunctionality(Type.REISEWAGON)
        passengerWagon?.add(passengers)
        Assert.assertEquals(initPassengers, passengerWagon?.resource)
    }

    @Test fun testTravelWagonRemovePassengersOverdraw() {
        val maxPassengers: Int = 100
        val initPassengers: Int = 100
        val passengers: Int = 150
        val zug = Zug(Wagon(maxPassengers, true, mutableListOf(ReiseWagon(maxPassengers, initPassengers))))
        val passengerWagon = zug.getHead().getFunctionality(Type.REISEWAGON)
        passengerWagon?.remove(passengers)
        Assert.assertEquals(initPassengers, passengerWagon?.resource)
    }

    @Test fun testCargoWagonAdd() {
        val initCargo: Int = 0
        val maxCargo: Int = 1000
        val cargo: Int = 500
        val zug = Zug(Wagon(1, true, mutableListOf(FrachtWagon(maxCargo, initCargo))))
        val cargoWagon = zug.getHead().getFunctionality(Type.FRACHTWAGON)
        cargoWagon?.add(cargo)
        Assert.assertEquals(cargo, cargoWagon?.resource)
    }

    @Test fun testCargoWagonAddOverdraw() {
        val initCargo: Int = 0
        val maxCargo: Int = 200
        val cargo: Int = 500
        val zug = Zug(Wagon(1, true, mutableListOf(FrachtWagon(maxCargo, initCargo))))
        val cargoWagon = zug.getHead().getFunctionality(Type.FRACHTWAGON)
        cargoWagon?.add(cargo)
        Assert.assertEquals(initCargo, cargoWagon?.resource)
    }

    @Test fun testCargoWagonRemove() {
        val initCargo: Int = 500
        val maxCargo: Int = 1000
        val cargo: Int = 200
        val zug = Zug(Wagon(1, true, mutableListOf(FrachtWagon(maxCargo, initCargo))))
        val cargoWagon = zug.getHead().getFunctionality(Type.FRACHTWAGON)
        cargoWagon?.remove(cargo)
        Assert.assertEquals(initCargo - cargo, cargoWagon?.resource)
    }


    @Test fun testCargoWagonRemoveOverdraw() {
        val initCargo: Int = 500
        val maxCargo: Int = 1000
        val cargo: Int = 700
        val zug = Zug(Wagon(1, true, mutableListOf(FrachtWagon(maxCargo, initCargo))))
        val cargoWagon = zug.getHead().getFunctionality(Type.FRACHTWAGON)
        cargoWagon?.remove(cargo)
        Assert.assertEquals(initCargo, cargoWagon?.resource)
    }

}
