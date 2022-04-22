package com.example.uhr_decker_jhuber_nschickm;

import Model.Stoppuhr;
import View.DigitalViewGUI;
import View.StoppuhrViewGUI;
import View.Sys;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.paint.Stop;

import javafx.scene.control.Label;

import java.sql.Time;

/**
 * @author decker
 * StoppuhrController Klasse, die den Thread und den Button für die Stoppuhr steuert
 */
public class StoppuhrController {
    @FXML
    private Label DigitalTimeLabel;
    private StoppuhrViewGUI stoppuhrViewGUI;
    private Stoppuhr stoppuhr = new Stoppuhr();
    Time time = new Time(0);

    @FXML
    void startstopbtnclicked(ActionEvent event) {
        time = stoppuhr.click();
    }

    public void initialize() {
        stoppuhrViewGUI = new StoppuhrViewGUI(DigitalTimeLabel);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        if (stoppuhr.getStart() != null) {
                            stoppuhrViewGUI.display(new Time(System.currentTimeMillis() - stoppuhr.getStart().getTime()));
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
}
