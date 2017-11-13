import java.util.ArrayList;

/**
 * @author Markus Reichl
 * @version 27.11.2016
 *
 * SOLVED!
 */

class Model {
    private ArrayList<Integer> trees;

    Model() {
        this.trees = new ArrayList<>();
    }

    void addTree(int size) { this.trees.add(size); }

    int getTree(int position) {
        if (position < this.trees.size() - 1) {
            return this.trees.get(position);
        } else {
            return -1;
        }
    }

    int storedTrees() { return this.trees.size(); }
}
