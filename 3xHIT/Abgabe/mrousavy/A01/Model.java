import java.util.ArrayList;

/**
 * Created by b4dpi on 06.12.2016.
 */
public class Model {

    private ArrayList<String> trees;

    public Model(){
        trees = new ArrayList<String>();
    }


    public void addTree(int size){

        String tree = ">> Baum mit Größe " + size + ":";
        String[] lines = new String[size];

        if (size < 1){
            tree += "\nKein Baum :(";
            trees.add(tree);
            return;
        }


        int offset = size;
        int leaves = 1;
        for(int i = 0; i< size; i++) {
            lines[i] = "\n>> ";
            for (int w = offset; w > 0; w--) {
                lines[i] += " ";
            }

            for(int x = 0; x < leaves; x++){
                if(leaves == 1)
                        lines[i] += "*";
                else
                    lines[i] += "#";
            }
            offset--;
            leaves+=2;
        }


        for(int i = 0; i< size; i++){
            tree += lines[i];
        }

        trees.add(tree);
    }

    public String getTree(int index){
        return trees.get(index);
    }

    public int storedTrees(){
        return trees.size();
    }
}
