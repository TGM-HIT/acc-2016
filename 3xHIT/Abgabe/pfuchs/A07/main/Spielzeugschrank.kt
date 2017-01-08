package main

class Spielzeugschrank(val size: Int, val sizeLade: Int) {
	private var laden:MutableList<Spielzeuglade>;
	private var input:String? = "";
	
	init {
		laden = mutableListOf<Spielzeuglade>();
		
		var i = 0;
		while (i < size) {
			laden.add(Spielzeuglade(mutableListOf<Spielzeug>(), sizeLade));
			i++;
		}
		
		menu(0);
	}
	
	fun openEdit(lines: Int) {
		// x steht für reihe, y für ladennummer
		var x = (Math.sqrt(size+0.0)).toInt();
		var y = size/x;
		var z = (size+0.0)/x;
		// Wenn die Gleitkommazahl z (ist y ungecastet) größer als y ist
		if (z > y)
			y++; // wird y um 1 erhöht
		
		var count = 0;
		
		println("Editable drawers:")
		for (i in 1..x) {
			for (j in 1..y)
				if (count < size) {
					print(""+i+"."+j+"\t")
					count++;
				}
			println()
		}
		println("Please choose one of them")
		println("Type \"back\" to return to menu")
		println("Type \"exit\" to exit the program")
		println("Type the number of a drawer (e.g: \"1.3\") to edit the drawer")
		
		for (i in 1..(8-lines-(x+1)))
			println()
		
		print(">> ")
		input = readLine();
		count = 0;
		for (i in 1..x)
			for (j in 1..y)
				if (count < size) {
					if (input.equals(""+i+"."+j)) {
						editLade(i-1, j-1, 0);
						return;
					}
					count++;
				}
		if (input != null && input.toString().toLowerCase().equals("back")) {
			menu(0)
			return
		} else if (input == null || input.toString().toLowerCase().equals("exit"))
			System.exit(0)
		else {
			println("Invalid input, please try again!")
			openEdit(1)
			return
		}
	}
	
	fun editLade(i: Int, j: Int, lines:Int) {
		println("Inhalt:")
		var aktLade = laden.get(i*Math.sqrt(size+0.0).toInt()+j);
		
		
		for (spielzeug in aktLade.spielzeug)
			println(aktLade.getType() + "-" + spielzeug.getName()+": From "+spielzeug.getMindAge()+" to "+spielzeug.getAltLim())
		
		print("\n\nAdd Spielzeug via \"add\"\nReturn via \"back\"\nExit via \"exit\"")
		
		for (i in 1..(7-aktLade.spielzeug.size-lines))
			println()
		print(">> ")
		input = readLine();
		when (input.toString().toLowerCase()) {
			"remove",
			"rem" -> remSpielzeug(aktLade, i, j, 0);
			"back" -> menu(0)
			"exit" -> System.exit(0)
			"add" -> addSpielzeug(aktLade, i, j, null)
			else -> {
				println("Invalid input!")
				editLade(i, j, 1);
			}
		}
	}
	
	fun remSpielzeug(aktLade: Spielzeuglade, i: Int, j: Int, lines:Int) {
		if (aktLade.spielzeug.size == 0) {
			println("There is no toy in this drawer! Add some toys via \"add\"! :)")
			editLade(i, j, 1)
			return;
		}
		
		while (true) {
			println("Here is a list of the actual toys, please choose the toy you want to delete by typing the number:")
			
			var count = 0;
			for (s in aktLade.spielzeug) {
				count++;
				println("" + count + ": " + s.getName() + ", from " +s.getMindAge() + " to " +s.getAltLim())
			}
			
			for (i in 1..(10-count-lines))
				println()
			println()
			
			print(">> ")
			input = readLine()
			
			try {
				var toyToRemove = input.toString().toInt();
				if (toyToRemove < 1 || toyToRemove > count) {
					println("Input invalid, please try again!")
					remSpielzeug(aktLade, i, j, 1)
					return;
				}
				var count2 = 0
				for (s in aktLade.spielzeug) {
					count2++;
					if (count2 == toyToRemove) {
						aktLade.rem(s)
						editLade(i, j, 1)
						return;
					}
				}
			} catch (e: NumberFormatException) {
				if (input.toString().toLowerCase().equals("exit"))
					System.exit(0)
				else if (input.toString().toLowerCase().equals("back")) {
					editLade(i, j, 0);
					return;
				}
				println("Invalid input, please try again!")
				remSpielzeug(aktLade, i, j, 1)
				return;
			}
		}
	}
	
	fun addSpielzeug(aktLade:Spielzeuglade, i:Int, j:Int, text:String?) {
		var name = "";
		var mindAge = 0;
		var altBeschr = 99;
		
		for (i in 1..15)
			println()
		
		if (text != null)
			println(text)
		
		try {
			println("Add a new toy")
			println("Is the toy a Lego, Holzspielzeug or Kartenspiel?")
			print(">> ")
			var type = readLine().toString().toLowerCase();
			when (type) {
				"lego",
				"holzspielzeug",
				"holz",
				"kartenspiel" -> {
					if (!aktLade.getType().equals("") && !aktLade.getType().toLowerCase().equals(type)) {
						println("This drawer can only contain " + aktLade.getType())
						editLade(i, j, 1)
						return
					}
				}
				else -> {
					println("Please insert a valid type")
					editLade(i, j, 1)
					return
				}
			}
			print("Name: ")
			name = readLine().toString();
			print("Mindestalter: ")
			mindAge = readLine().toString().toInt();
			print("Altersbeschränkung: ")
			altBeschr = readLine().toString().toInt();
			
			when (type) {
				"lego" -> {
					if (Lego(name, mindAge, altBeschr).addToLade(aktLade))
						editLade(i, j, 1);
					else {
						println("This drawer can't contain LEGO!")
						editLade(i, j, 1)
						return
					}
				}
				"holz",
				"holzspielzeug" ->  {
					if(Holzspielzeug(name, mindAge, altBeschr).addToLade(aktLade))
						editLade(i, j, 1)
					else {
						println("This drawer can't contain Holzspielzeug!")
						editLade(i, j, 1)
						return
					}
				}
				"kartenspiel" -> {
					if(Kartenspiel(name, mindAge, altBeschr).addToLade(aktLade))
						editLade(i, j , 1)
					else {
						println("This drawer can't contain a Kartenspiel!")
						editLade(i, j, 1)
						return
					}
				}
			}
		} catch (e: NumberFormatException) {
			println("Invalid input: Please insert a number!")
			editLade(i, j, 1);
			return;
		}
		
		editLade(i, j, 1);
	}
	
	fun menu(lines:Int) {
		var x = (Math.sqrt(size+0.0)).toInt();
		var y = size/x;
		var z = (size+0.0)/x;
		if (z > y)
			y++;
		
		var count1 = 0;
		var count2 = 0;
		var count3 = 0;
		
		print("+")
		for (i in 1..y)
			print("-------------------+");
		println()
		for (i in 1..x) {
			print("|")
			for (j in 1..y)
				if (count1 < size) {
					print(" +---------------+ |");
					count1++;
				} else print("                   |");
			println()
			print("|")
			for (j in 1..y)
				if (count2 < size) {
					print(" |     "+i+" o "+j+"     | |");
					count2++;
				} else print("                   |");
			println()
			print("|")
			for (j in 1..y)
				if (count3 < size) {
					print(" +---------------+ |");
					count3++;
				} else print("                   |");
			println()
		}
		print("+")
		for (i in 1..y)
			print("-------------------+");
		for (i in 1..(8-lines-2*(x+1)))
			println()
		
		if (8-lines-2*(x+1)<1)
			println()
		println("Use \"exit\" to exit the program, type \"edit\" to edit a drawer")
		print(">> ")
		input = readLine();
		
		if (input is String && input.equals("edit"))
			openEdit(0);
		else if (input.equals("exit") || input.equals("") || input.equals("ex") || input == null)
			System.exit(0)
		else {
			println("Invalid input! Please try again!")
			menu(1);
		}
	}
}