package Main

/**
 @author Michael Ebenstein
 @version 14-12-2016
**/	
class Schrank<T> constructor(size:Int) {
	private var size:Int;
	private var drawers:MutableList<Drawer<T>>;
	
	init{
		this.size = size;
		drawers = arrayListOf();
		
		for(i in 0..size-1){
			drawers.add(Drawer<T>(10));
		}
	}
	
	
	fun addItem(item:T):Boolean{
		
		for(d:Drawer<T> in drawers)
			if(d.addItem(item))return true
		
		return false;
	}
}
