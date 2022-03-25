package View;


import javafx.scene.control.Label;

public class WeatherViewGUI extends ViewInterface {

    protected Label l;

    public WeatherViewGUI(Label l) {
        this.l = l;
    }

    public void display(String weather){
        l.setText(weather);
    }

}

