package main

open class Spielzeug(name: String, mindestalter: Int = 0, alterslimit: Int = 99) {
	private var name:String = "";
	private var mindestalter:Int = 0;
	private var alterslimit:Int = 99;
		
	init {
		this.name = name;
		this.mindestalter = mindestalter;
		this.alterslimit = alterslimit;
	}
	
	fun checkName(name: String):Boolean {
		return this.name.equals(name);
	}
	
	fun getName():String {
		return name;
	}
	
	fun getMindAge():Int {
		return mindestalter;
	}
	
	fun getAltLim():Int {
		return alterslimit;
	}
}