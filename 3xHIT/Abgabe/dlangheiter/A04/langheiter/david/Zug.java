package langheiter.david;

import java.util.ArrayList;
import java.util.List;

public class Zug {
	List<Wagon> wagons;
	
	public Zug(Wagon wagon) {
		wagons = new ArrayList<>();
		wagons.add(wagon);
	}
	
	public Zug(List<Wagon> wagons) {
		this.wagons = wagons;
	}
	
	public Wagon getWagon(int index) {
		return wagons.get(index);
	}
	
	public void wagonAnhaengen(Wagon wagon) {
		wagons.add(wagon);
	}
	
	public int laenge() {
		return wagons.size();
	}
	
	public Wagon wagonAbhaengen() {
		if(wagons.size() == 1) {
			return null;
		}
		return wagons.remove(wagons.size()-1);
	}
	
}
