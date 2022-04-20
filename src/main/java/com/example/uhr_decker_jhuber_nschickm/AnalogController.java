package com.example.uhr_decker_jhuber_nschickm;

import View.AnalogViewGUI;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.sql.Time;

public class AnalogController {
    @FXML
    private AnchorPane hour;
    @FXML
    private AnchorPane min;
    @FXML
    private AnchorPane seconds;
    AnalogViewGUI analogViewGUI;
    BorderPane mainpane;

    AnalogController(BorderPane mainpane) {
        this.mainpane = mainpane;
        initialize();
    }

    public void initialize() {
        analogViewGUI = new AnalogViewGUI(hour, min, seconds, mainpane);
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        analogViewGUI.display(new Time(System.currentTimeMillis()));
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
}