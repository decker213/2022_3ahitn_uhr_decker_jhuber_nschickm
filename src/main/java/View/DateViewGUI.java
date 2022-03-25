package View;


import javafx.scene.control.Label;
/**
 * @author jhuber
 * Ändert den Text des Labels, welches das Datum ausgibt.
 */
public class DateViewGUI extends ViewInterface {

    protected Label l;

    /**
     * Konstruktor
     * @param l das Label was zu ändern ist
     */
    public DateViewGUI(Label l) {
        this.l = l;
    }

    /**
     * Ändert das Label
     * @param date Datum auf das geändert werden soll
     */
    public void display(String date){
        l.setText(date);
    }
}

