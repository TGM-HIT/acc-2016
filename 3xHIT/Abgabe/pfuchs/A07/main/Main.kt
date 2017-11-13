package main

fun main(args: Array<String>) {
	var drawers = 0;
	while (true) {
		println("Please insert how many toys each drawer can carry!")
		try {
			print(">> ")
			drawers = readLine().toString().toInt();
			break;
		} catch (e: NumberFormatException) {
			println("Please insert a number, no one cares if you insert a letter when a clean number is asked, it's just useless!");
		}
	}
	var size_cabinet = 0;
	while (true) {
	println("Please insert how many drawers your cabinet has!")
		try {
			print(">> ")
			size_cabinet = readLine().toString().toInt();
			break;
		} catch(e: NumberFormatException) {
			println("Please insert a number, it's not very efficient if you insert a letter when a clean number is asked!")
		}
	}
	Spielzeugschrank(size_cabinet, drawers);
}