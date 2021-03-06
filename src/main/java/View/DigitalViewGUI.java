package View;


import javafx.scene.control.Label;

import java.sql.Time;

/**
 * @author jhuber
 * Ändert den Text des Labels, welches die Uhrzeit im Digital-Format ausgibt.
 */
public class DigitalViewGUI {
    protected Label l;

    /**
     * Konstruktor
     *
     * @param l das Label was zu ändern ist
     */
    public DigitalViewGUI(Label l) {
        this.l = l;
    }


    /**
     * Ändert das Label
     *
     * @param t die Zeit auf die das Label gesetzt wird
     */
    public void display(Time t) {
        if (t.getHours() <= 12) {
            l.setText(String.valueOf(t) + "\n" + String.valueOf(t.getHours()) + ":" +String.valueOf(t.getMinutes()) + " am");
        }else {
            l.setText(String.valueOf(t) + "\n" + String.valueOf(t.getHours()-12) + ":" +String.valueOf(t.getMinutes()) + " pm");
        }
    }

}

