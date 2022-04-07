package View;


import javafx.scene.control.Label;
/**
 * @author jhuber
 * Ändert den Text des Labels, welches das Wetter ausgibt.
 */
public class WeatherViewGUI  {

    protected Label l;

    /**
     * Konstruktor
     * @param l das Label was zu ändern ist
     */
    public WeatherViewGUI(Label l) {
        this.l = l;
    }

    /**
     * Ändert das Label
     * @param weather Wetter auf das geändert werden soll
     */
    public void display(String weather){
        l.setText(weather);
    }

}

