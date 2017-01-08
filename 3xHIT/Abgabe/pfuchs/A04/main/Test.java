package main;

public class Test {

	public static void main(String[] args) {
		Zug zug = new Zug();
		Speisewagon essen = new Speisewagon("Essen01");
		zug.addWagonBack(essen);
		essen.buchen();
		for (int i = 0; i < 30; i++)
			essen.makeSachatorte();
		for (int i = 0; i < 10; i++)
			essen.makeCoffee();
		essen.makeKakao();
		zug.addWagonFront(new Reisewagon(300));
	}

}
