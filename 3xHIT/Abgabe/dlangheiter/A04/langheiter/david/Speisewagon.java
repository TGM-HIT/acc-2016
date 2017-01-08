package langheiter.david;

public class Speisewagon extends Reisewagon {
	private int nahrung;
	
	public Speisewagon(boolean open, int maxPersons) {
		this(open, maxPersons, 0);
	}
	
	public Speisewagon(boolean open, int maxPersons, int nahrung) {
		super(open, maxPersons);
		this.nahrung = nahrung;
	}
		
	public int getNahrung() {
		return nahrung;
	}
	
	public boolean nahrungAusgeben(int menge) {
		if(menge > nahrung) {
			return false;
		}
		nahrung -= menge;
		return true;
	}
	
}
