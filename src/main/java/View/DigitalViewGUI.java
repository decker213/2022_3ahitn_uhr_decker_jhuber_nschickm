package View;


import javafx.scene.control.Label;

import java.sql.Time;

public class DigitalViewGUI extends ViewInterface {

    protected Label l;

    public DigitalViewGUI(Label l) {
        this.l = l;
    }

    public void display(Time t){
        l.setText(String.valueOf(t));
    }

}

