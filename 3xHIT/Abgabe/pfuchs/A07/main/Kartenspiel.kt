package main

class Kartenspiel: Spielzeug {
	constructor(name: String) : super(name, 0, 99);
	constructor(name: String, mindestalter: Int = 0, alterslimit: Int = 99) : super(name, mindestalter, alterslimit);
	
	fun addToLade(lade: Spielzeuglade):Boolean {
		if (lade.spielzeug.size == 0)
			lade.setType("Kartenspiel")
		else if (!lade.getType().equals("Kartenspiel")) {
			return false;
		}
		lade.add(this);
		return true;
	}
}