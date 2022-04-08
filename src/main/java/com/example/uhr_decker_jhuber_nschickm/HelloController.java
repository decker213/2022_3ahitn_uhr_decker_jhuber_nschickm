package com.example.uhr_decker_jhuber_nschickm;

import Model.Stoppuhr;
import Model.Timer;
import Model.Wecker;
import Model.Zeitzone;
import View.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.awt.*;
import java.io.IOException;
import java.sql.Time;

public class HelloController {


    public Label cityname;
    public Label wetter;
    public Label temperatur;
    public TextField stadt;
    public Button abfragen;
    private Timer timer;
    private Wecker wecker;
    private Zeitzone zeitzone;
    private Stoppuhr stoppuhr;
    private DigitalViewGUI digitalvg;
    private AnalogViewGUI avg;
    private DateViewGUI datevg;
    private BinaryViewGUI bvg;
    private WeatherViewGUI wvg;
    private TemperatureViewGUI tvg;


    @FXML
    private BorderPane mainpane;

    @FXML
    private Button showAnalogUhrbtn;

    @FXML
    void showAnalogUhr(ActionEvent event) {
        avg.display(new Time(System.currentTimeMillis()));
    }

    @FXML
    void showBinaryUhr(ActionEvent event) throws IOException {
        bvg.display(new Time(System.currentTimeMillis()));
    }

    public void initialize() {
        avg = new AnalogViewGUI(mainpane);
        bvg = new BinaryViewGUI(mainpane);
        wvg = new WeatherViewGUI(mainpane, cityname, wetter, temperatur, stadt, abfragen);
    }

    public void showWeatherTemp(ActionEvent event) throws IOException {
        wvg.display(stadt.getText());
    }
}

