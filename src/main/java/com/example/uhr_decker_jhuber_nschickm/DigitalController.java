package com.example.uhr_decker_jhuber_nschickm;

import View.DigitalViewGUI;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Time;

public class DigitalController {

    @FXML
    public Label DigitalTimeLabel;
    protected DigitalViewGUI digitalViewGUI;

    public void initialize(){
        digitalViewGUI = new DigitalViewGUI(DigitalTimeLabel);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        digitalViewGUI.display(new Time(System.currentTimeMillis()));
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
