package View;

import javafx.scene.control.Label;

import java.sql.Time;

/**
 * Im Konstruktor wird das zu überschreibende Label übergeben.
 * In der Methode display wird die Zeit angezeigt.
 * @author david
 */
public class StoppuhrViewGUI {
    private Label l;

    public StoppuhrViewGUI(Label label) {
        l = label;
    }

    /**
     * Zeit die übergebene Zeit in Minuten und Sekunden an
     * @param t
     */
    public void display(Time t) {
        if (t != null) {
            l.setText(t.getMinutes() + ":" + t.getSeconds());
        }
    }
}
