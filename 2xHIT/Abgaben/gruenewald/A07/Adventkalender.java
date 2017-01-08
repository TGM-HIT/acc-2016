
/**
 * Adventkalender
 * @author Sebastian Grünewald
 * @version 16-12-2016
 */

import java.util.*;
import java.text.*;
import java.util.concurrent.TimeUnit;

public class Adventkalender {
    public static void main (String[] args) {
        Date d = new Date();
        SimpleDateFormat tag = new SimpleDateFormat("dd");
        SimpleDateFormat monat = new SimpleDateFormat("MMMM");

        int heute = Calendar.getInstance().get(Calendar.DATE);
        
        String weihnachten = "24/12/2016 00:00:00";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date weih = null; 

        try {
            weih = format.parse(weihnachten);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        long millis = weih.getTime() - d.getTime();

        long tage = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(tage);

        long stunden = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(stunden);

        long minuten = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minuten);

        long sekunden = TimeUnit.MILLISECONDS.toSeconds(millis);

        System.out.println("Heute ist der "+tag.format(d)+". "+monat.format(d)+", nur noch "+tage+" Tage "+stunden+" Stunden \n"+minuten+" Minuten und "+sekunden+" Sekunden bis Weihnachten!\n");

        System.out.println(" Mo | Di | Mi | Do | Fr | Sa | So");
        String endergebnis = "";
        int tageZählen = 1;
        for (int i =- 2; i < 32; i++) {
            endergebnis = endergebnis + " ";
            if ((i < 1) || (i > 31)) {
                endergebnis = endergebnis + "  ";
            } else if (i < 10) {	
                endergebnis = endergebnis + "0" + i;
            } else {
                if (i == 24) {
                    endergebnis = endergebnis + "*"+i+"*";
                }
                if (i == heute) {
                    endergebnis = endergebnis + "-"+i+"-";
                }
                if (i != 24 && i != heute) {
                    endergebnis = endergebnis + i;
                }
            }
            endergebnis = endergebnis + " ";
            if (tageZählen != 7) {
                endergebnis = endergebnis + "|";
                tageZählen = tageZählen + 1;
            } else {
                endergebnis = endergebnis + "\n";
                tageZählen = 1;
            }
        }
        System.out.println(endergebnis);
    }
}
