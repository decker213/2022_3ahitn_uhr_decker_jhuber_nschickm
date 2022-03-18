package View;


/**
 * @author david
 */
public class TemperatureViewConsole extends ViewInterface {

    /**
     * Gibt die Temperatur in °C aus
     * @param temp Temperatur in °C
     */
    public void display(int temp) {
        System.out.println(temp + " C°");
    }
}

