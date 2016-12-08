/**
 * Created by b4dpi on 06.12.2016.
 */





/**
 * @author Markus Reichl
 * @version 27.11.2016
 *
 * DO NOT MODIFY!
 */

class Controller {
    private Model m;
    private View v;

    Controller() {
        m = new Model();
        v = new View();

        m.addTree(0);
        m.addTree(1);
        m.addTree(2);
        m.addTree(3);
        m.addTree(5);
        m.addTree(7);
        m.addTree(10);

        redraw();
    }

    private void redraw() {
        for(int i = 0; i < m.storedTrees() - 1; i++) {
            v.drawTree(m.getTree(i));
        }
    }

    public static void main(String[] args){
        new Controller();
    }
}
