package main

data class Spielzeuglade(val spielzeug: MutableList<Spielzeug>, val size:Int) {
	private var typ:String = "";
	
	fun setType(type:String) {
		this.typ = type;
	}
	
	fun getType():String {
		return this.typ;
	}
	
	fun add(spielzeug: Spielzeug) {			
		if (this.spielzeug.size < size) {
			this.spielzeug.add(spielzeug);
			for (i in 1..13)
				println()
			println("Toy added successfully")
		}
		else println("Drawer is full!")
	}
	
	fun rem(spielzeug: Spielzeug) {
		if (this.spielzeug.contains(spielzeug)) {
			this.spielzeug.remove(spielzeug);
			println("Toy successfully removed!")
		}
		else println("Toy is not in the drawer!")
	}
	
	fun getSpielzeugByName(name: String):Spielzeug? {
		for (spielzeug in this.spielzeug)
			if(spielzeug.checkName(name))
				return spielzeug;
		return null;
	}
}