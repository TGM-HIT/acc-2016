/**
 * @author Markus Reichl
 * @version 27.11.2016
 */

class Spielzeuglade {
    private Spielzeug[] spielzeuglade;

    Spielzeuglade(int maxItems) {
        this.spielzeuglade = new Spielzeug[maxItems];
    }

    void addItem(Spielzeug s) {
        for (int i = 0; i < this.spielzeuglade.length; i++) {
            if (this.spielzeuglade[i] == null) {
                this.spielzeuglade[i] = s;
                return;
            }
        }

        System.out.println("Die Spielzeuglade ist zu voll für deine " + s.name + "!");
    }

    void listItems() {
        for (int i = 0; i < this.spielzeuglade.length - 1; i++) {
            if (this.spielzeuglade[i] != null) {
                System.out.println(this.spielzeuglade[i].name);
            }
        }
    }
}
