package View;

import java.sql.SQLOutput;

/**
 * @author jhuber
 */
public class MenuViewConsole extends ViewInterface {


    /**
     * Gibt das gewünschte Menü aus
     *
     * @param s dieser String gibt an welches Menü ausgegeben werden soll
     */
    public void display(String s) {
        switch (s) {
            case "Menu":
                System.out.println("Menü:");
                System.out.println("Digitaluhr(1)");
                System.out.println("Timer(2)");
                System.out.println("Stoppuhr(3)");
                System.out.println("Wecker(4)");
                System.out.println("Wetter(5)");
                System.out.println("Ende(6)");
                break;
            case "Timer":
                System.out.println("Zurück(0)");
                System.out.println("Länge des Timers in Minuten:");

                break;
            case "Stoppuhr":
                System.out.println("Zurück(0)");
                System.out.println("Stoppuhr starten(1)");
                System.out.println("Stoppuhr stoppen(2)");
                break;
            case "Wecker":
                System.out.println("Zurück(0)");
                System.out.println("Wecker anzeigen");
                break;

        }
    }


}
