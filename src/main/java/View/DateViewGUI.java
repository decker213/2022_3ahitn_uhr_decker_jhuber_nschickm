package View;


import javafx.scene.control.Label;

public class DateViewGUI extends ViewInterface {

    protected Label l;

    public DateViewGUI(Label l) {
        this.l = l;
    }

    public void display(String date){
        l.setText(date);
    }
}

