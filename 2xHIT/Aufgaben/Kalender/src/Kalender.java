import java.util.Calendar;

/**
 * @author Markus Reichl
 * @version 11.12.2016
 */

public class Kalender {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        System.out.println("Today is the: " + cal.get(Calendar.DAY_OF_MONTH) + "th December!");
        System.out.println("Only " + (24 - cal.get(Calendar.DAY_OF_MONTH)) + " days until Christmas!");

        for (int i = 0; i < 24; i++) {
            System.out.print(i + 1);
            if ((i + 1) % 7 == 0) {
                System.out.println();
            } else {
                System.out.print(" | ");
            }
        }
        System.out.println(cal.get(Calendar.MONDAY));
    }
}
