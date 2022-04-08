package com.example.uhr_decker_jhuber_nschickm;

import Model.Stoppuhr;
import Model.Timer;
import Model.Wecker;
import Model.Zeitzone;
import View.*;
import javafx.application.Platform;
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

@FXML
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
    private WeatherViewGUI wvg;
    private TemperatureViewGUI tvg;
    private BinaryController bc;



    @FXML
    private BorderPane mainpane;

    @FXML
    private Button showAnalogUhrbtn;

    @FXML
    void showAnalogUhr(ActionEvent event) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        avg.display(new Time(System.currentTimeMillis()));
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
        // don't let thread prevent JVM shutdown
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    void showBinaryUhr(ActionEvent event) throws IOException {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            bc.binaryViewGUI.display(new Time(System.currentTimeMillis()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
        // don't let thread prevent JVM shutdown
        thread.setDaemon(true);
        thread.start();
    }

    public void initialize() {
        avg = new AnalogViewGUI(mainpane);
        bc = new BinaryController(mainpane);
        wvg = new WeatherViewGUI(mainpane, cityname, wetter, temperatur, stadt, abfragen);
    }

    public void showWeatherTemp(ActionEvent event) throws IOException {
        wvg.display(stadt.getText());
    }
}

