/**
 * @author Markus Reichl
 * @version 28.11.2016
 */

public class Baumfabrik {
    public static void main(String[] args) {
        drawTree(1);
        drawTree(2);
        drawTree(3);
        drawTree(5);
        drawTree(7);
    }

    private static void drawTree(int size) {
        System.out.println();
        System.out.println("Tree of size: " + size + "\n");

        size *= 2;

        for (int i = 0; i < size; i += 2) {
            for (int j = 0; j < (size - i) / 2; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i + 1; j++) {
                System.out.print("#");
            }

            System.out.println();
        }

        System.out.println();
    }
}