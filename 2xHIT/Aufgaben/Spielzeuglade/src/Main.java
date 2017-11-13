/**
 * @author Markus Reichl
 * @version 27.11.2016
 */

public class Main {
    public static void main(String[] args) {
        Spielzeuglade s = new Spielzeuglade(5);

        s.addItem(new Spielzeug("Auto", 0, 100));
        s.listItems();

        s.addItem(new Spielzeug("Keks", 0, 100));
        s.addItem(new Spielzeug("Maus", 0, 100));
        s.addItem(new Spielzeug("Lego", 0, 100));
        s.addItem(new Spielzeug("Ritter", 0, 100));
        s.addItem(new Spielzeug("Burg", 0, 100));
        s.listItems();
    }
}
