package View;


/**
 * @author david
 */
public class WeatherVIewConsole extends ViewInterface {

    /**
     * Gibt Details zu den Wetter Daten aus
     * @param s Wetterdaten, welche ausgegeben werden
     */
    public void display(String s) {
        System.out.println("Wetter: " + s);
    }
}

