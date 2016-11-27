/**
 * @author Markus Reichl
 * @version 27.11.2016
 */

public class Main {
    public static void main(String[] args) {
        int tag01 = getNumber(args[0]);

        System.out.print(tag01);
        System.out.print(" -> ");
        System.out.print(getTag((tag01 + 23) % 7));
    }

    private static int getNumber(String tag) {
        int n = -1;

        if (tag.equals("Montag")) n = 0;
        if (tag.equals("Dienstag")) n = 1;
        if (tag.equals("Mittwoch")) n = 2;
        if (tag.equals("Donnerstag")) n = 3;
        if (tag.equals("Freitag")) n = 4;
        if (tag.equals("Samstag")) n = 5;
        if (tag.equals("Sonntag")) n = 6;

        return n;
    }

    private static String getTag(int tag) {
        String s = "";

        if (tag == 0) s = "Montag";
        if (tag == 1) s = "Dienstag";
        if (tag == 2) s = "Mittwoch";
        if (tag == 3) s = "Donnerstag";
        if (tag == 4) s = "Freitag";
        if (tag == 5) s = "Samstag";
        if (tag == 6) s = "Sonntag";

        return s;
    }
}