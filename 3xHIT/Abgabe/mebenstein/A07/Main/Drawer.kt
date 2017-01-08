package Main

/**
 @author Michael Ebenstein
 @version 14-12-2016
**/	
class Drawer<T> constructor(size:Int) {
	
	private var size:Int;
	private var items:MutableList<T>;
	
	init{
		this.size = size;
		items = arrayListOf();
	}
	
	fun addItem(item:T):Boolean{
		if(size == 0) return false
		items.add(item);
		size--;
		return true
	}
	
	fun showContent(){
		for(t in items)
			println(t);
	}
}