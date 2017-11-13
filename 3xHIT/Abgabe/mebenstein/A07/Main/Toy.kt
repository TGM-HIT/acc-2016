package Main

/**
 @author Michael Ebenstein
 @version 14-12-2016
**/	
open class Toy (val name:String,val minage:Int,val maxage:Int)

class Lego:Toy("Lego",6,16)

class WoodenToy:Toy("Wodden Toy",2,12)

class CardDeck:Toy("Card Deck",8,99);