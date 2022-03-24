package com.example.uhr_decker_jhuber_nschickm;

import Model.Stoppuhr;
import Model.Timer;
import Model.Wecker;
import Model.Zeitzone;
import View.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.sql.Time;

public class HelloController {

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
    private Label welcomeText;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    protected void onHelloButtonClick() {
        avg.display(new Time(System.currentTimeMillis()));
    }

    public void initialize() {
        avg = new AnalogViewGUI(AnchorPane);
    }
}