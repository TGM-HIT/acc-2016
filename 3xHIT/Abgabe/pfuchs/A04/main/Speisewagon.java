package main;

public class Speisewagon extends Wagon {
	private double mengeFleischKg;
	private int mengeKakaoG;
	private double mengeMilchL;
	private double mengeKaffeebohnenKg;
	
	private int mengeSachertorten;
	private int mengeKarottenG;
	private int mengeErdäpfelG;
	private int mengeMarinadeMl;
	private int mengeBlattsalatG;
	
	private String name;
	
	/**
	 * Constructor<br>
	 * Creates a Speisewagon with default values of food
	 * @param string 
	 */
	public Speisewagon(String name) {
		this(3, 500, 20, 1, 10, 3000, 3000, 4000, 2000);
		this.name = name;
		
		System.out.println("You can easily order food at your beautiful " + name + "-wagon");
	}
	
	/**
	 * Constructor<br>
	 * Creates a Speisewagon with user-defined values of food
	 * 
	 * @param fleisch
	 * @param kakao
	 * @param milch
	 * @param kaffee
	 * @param sachertorte
	 * @param karotten
	 * @param erdäpfel
	 * @param marinade
	 * @param blattsalat
	 */
	public Speisewagon(int fleisch, int kakao, double milch, int kaffee, int sachertorte, int karotten, int erdäpfel, int marinade, int blattsalat) {
		super(0);
		
		setMengeFleischKg(fleisch);
		setMengeKakaoG(kakao);
		setMengeMilchL(milch);
		setMengeKaffeebohnenKg(kaffee);
		setMengeSachertorten(sachertorte);
		setMengeKarottenG(karotten);
		setMengeErdäpfelG(erdäpfel);
		setMengeMarinadeMl(marinade);
		setMengeBlattsalatG(blattsalat);
	}
	
	/**
	 * Makes a delicious salad
	 * @param salat the salad to make
	 */
	public void makeSalat(Salat salat) {
		try {
			int[] nahrungsmittel = salat.rezept();
			if (salat instanceof Blattsalat)
				setMengeBlattsalatG(nahrungsmittel[0]);
			else if (salat instanceof Erdäpfelsalat)
				setMengeErdäpfelG(nahrungsmittel[0]);
			else if (salat instanceof Karottensalat)
				setMengeKarottenG(nahrungsmittel[0]);
			
			setMengeMarinadeMl(nahrungsmittel[1]);
			
			System.out.println("Your delicious salad just got served in " + name + "-wagon! =3");
		} catch (NotEnoughIngredientsException e) {
			System.out.println("You didn't have enough ingredients");
		}
	}
	
	/**
	 * Makes a warm nice cocoa
	 */
	public void makeKakao() {
		if (getMengeKakaoG() < 5 || getMengeMilchL() < 0.5) {
			System.out.println("Sie haben nicht genug Nahrungsmittelin " + name + "-wagon gelagert");
			return;
		}
		
		setMengeKakaoG(getMengeKakaoG()-5);
		setMengeMilchL(getMengeMilchL()-0.5);
		
		System.out.println("Here is your nice warm cocoa from " + name + "-wagon! ^o^");
	}
	
	/**
	 * Serves the best tasting cake of Austria besides the Mozarttorte<br>
	 * which we unfortunately don't have on board =<
	 */
	public void makeSachatorte() {
		if (getMengeSachertorten() < 1) {
			System.out.println("Error! We are missing some Sachertorten in " + name + "-wagon!!!");
			return;
		}
		
		setMengeSachertorten(getMengeSachertorten() - 1);
		
		System.out.println("Here is your very-austrian Sachertorte from " + name + "-wagon! <3");
	}

	/**
	 * Get yourself some coffee to wake up
	 */
	public void makeCoffee() {
		if (getMengeKaffeebohnenKg() < 0.05 || getMengeMilchL() < 0.1) {
			System.out.println("No waking up for you today in " + name + "-wagon... >=P");
			return;
		}
		
		setMengeKaffeebohnenKg(getMengeKaffeebohnenKg() - 0.05);
		setMengeMilchL(getMengeMilchL() - 0.1);
		
		System.out.println("Waky, waky, waky UP for more " + name + "-wagons!");
	}
	
	/**
	 * Some animals-died-for-it-meat
	 */
	public void getSomeMeat() {
		if (getMengeFleischKg() < 0.3) {
			System.out.println("Stay hungry and enjoy our journey in " + name + "-wagon ^-^");
			return;
		}
		
		setMengeFleischKg(getMengeFleischKg()-0.3);
		System.out.println("Congratulations! You are the case some animals died, you bastard!");
	}
	
	/**
	 * @return the mengeFleischKg
	 */
	public double getMengeFleischKg() {
		return mengeFleischKg;
	}

	/**
	 * @param mengeFleischKg the mengeFleischKg to set
	 */
	public void setMengeFleischKg(double mengeFleischKg) {
		if (mengeFleischKg < 0) throw new IllegalArgumentException();
		this.mengeFleischKg = mengeFleischKg;
	}

	/**
	 * @return the mengeKakaoL
	 */
	public int getMengeKakaoG() {
		return mengeKakaoG;
	}

	/**
	 * @param mengeKakaoL the mengeKakaoL to set
	 */
	public void setMengeKakaoG(int mengeKakaoG) {
		if (mengeKakaoG < 0) throw new IllegalArgumentException();
		this.mengeKakaoG = mengeKakaoG;
	}

	/**
	 * @return the mengeMilchL
	 */
	public double getMengeMilchL() {
		return mengeMilchL;
	}

	/**
	 * @param mengeMilchL the mengeMilchL to set
	 */
	public void setMengeMilchL(double mengeMilchL) {
		if (mengeMilchL < 0) throw new IllegalArgumentException();
		this.mengeMilchL = mengeMilchL;
	}

	/**
	 * @return the mengeKaffeebohnenKg
	 */
	public double getMengeKaffeebohnenKg() {
		return mengeKaffeebohnenKg;
	}

	/**
	 * @param mengeKaffeebohnenKg the mengeKaffeebohnenKg to set
	 */
	public void setMengeKaffeebohnenKg(double mengeKaffeebohnenKg) {
		if (mengeKaffeebohnenKg < 0) throw new IllegalArgumentException();
		this.mengeKaffeebohnenKg = mengeKaffeebohnenKg;
	}

	/**
	 * @return the mengeSachertorten
	 */
	public int getMengeSachertorten() {
		return mengeSachertorten;
	}

	/**
	 * @param mengeSachertorten the mengeSachertorten to set
	 */
	public void setMengeSachertorten(int mengeSachertorten) {
		if (mengeSachertorten < 0) throw new IllegalArgumentException();
		this.mengeSachertorten = mengeSachertorten;
	}

	/**
	 * @return the mengeKarottenG
	 */
	public int getMengeKarottenG() {
		return mengeKarottenG;
	}

	/**
	 * @param mengeKarottenG the mengeKarottenG to set
	 */
	public void setMengeKarottenG(int mengeKarottenG) {
		if (mengeKarottenG < 0) throw new IllegalArgumentException();
		this.mengeKarottenG = mengeKarottenG;
	}

	/**
	 * @return the mengeErdäpfelG
	 */
	public int getMengeErdäpfelG() {
		return mengeErdäpfelG;
	}

	/**
	 * @param mengeErdäpfelG the mengeErdäpfelG to set
	 */
	public void setMengeErdäpfelG(int mengeErdäpfelG) {
		if (mengeErdäpfelG < 0) throw new IllegalArgumentException();
		this.mengeErdäpfelG = mengeErdäpfelG;
	}

	/**
	 * @return the mengeMarinadeMl
	 */
	public int getMengeMarinadeMl() {
		return mengeMarinadeMl;
	}

	/**
	 * @param mengeMarinadeMl the mengeMarinadeMl to set
	 */
	public void setMengeMarinadeMl(int mengeMarinadeMl) {
		if (mengeMarinadeMl < 0) throw new IllegalArgumentException();
		this.mengeMarinadeMl = mengeMarinadeMl;
	}

	/**
	 * @return the mengeBlattsalatG
	 */
	public int getMengeBlattsalatG() {
		return mengeBlattsalatG;
	}

	/**
	 * @param mengeBlattsalatG the mengeBlattsalatG to set
	 */
	public void setMengeBlattsalatG(int mengeBlattsalatG) {
		if (mengeBlattsalatG < 0) throw new IllegalArgumentException();
		this.mengeBlattsalatG = mengeBlattsalatG;
	}
}