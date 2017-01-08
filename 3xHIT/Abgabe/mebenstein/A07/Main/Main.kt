package Main

/**
 @author Michael Ebenstein
 @version 14-12-2016
**/	

fun main(args: Array<String>){
	
	var schrank = Schrank<Lego>(10);
	
	for(i in 0..110){
		var l = Lego()
		if(schrank.addItem(l))
			println("Added ${i} ${l.name}");
		else
			println("Not enought place")
	}
	
}
	