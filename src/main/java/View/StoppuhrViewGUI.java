package View;

import javafx.scene.control.Label;

import java.sql.Time;

public class StoppuhrViewGUI {
    private Label l;

    public StoppuhrViewGUI(Label label) {
        l = label;
    }

    public void display(Time t) {
        if (t != null) {
            l.setText(t.getMinutes() + ":" + t.getSeconds());
        }
    }
}
