package com.example.uhr_decker_jhuber_nschickm;

import View.TimerViewGUI;
import View.WeckerViewGUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Time;

/**
 * @author jhuber
 * TimerController steuert den Thread, die Buttons und die Textfelder die für den Timer zustädnig sind
 */
public class TimerController {
    public AnchorPane anchorpane;
    public TextField hours;
    public TextField minutes;
    public TextField seconds;
    protected TimerViewGUI timerViewGUI;
    protected boolean stop = false;


    /**
     * initialisiert die TimerViewGUI
     */
    public void initialize() {
        timerViewGUI = new TimerViewGUI();
    }

    /**
     * startet den Timer
     * @param actionEvent Click auf den Start-Button
     */
    public void startTimer(ActionEvent actionEvent) {
        stop = false;
        hours.setEditable(false);
        minutes.setEditable(false);
        seconds.setEditable(false);
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        if (Integer.parseInt(seconds.getText()) == 0) {
                            timerViewGUI.display(seconds, "59");
                            if (Integer.parseInt(minutes.getText()) == 0 && Integer.parseInt(hours.getText()) > 0) {
                                timerViewGUI.display(minutes, "59");
                                timerViewGUI.display(hours, String.valueOf(Integer.parseInt(hours.getText()) - 1));
                            } else {
                                timerViewGUI.display(minutes, String.valueOf(Integer.parseInt(minutes.getText()) - 1));
                            }
                        } else {
                            timerViewGUI.display(seconds, String.valueOf(Integer.parseInt(seconds.getText()) - 1));
                        }

                    }
                };

                while ((!(seconds.getText().equals("1") && minutes.getText().equals("0") && hours.getText().equals("0")))&& !stop) {
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

    /**
     * Stoppt den Timer
     * @param actionEvent Click auf den Stopp-Button
     */
    public void stopTimer(ActionEvent actionEvent) {
        stop = true;
        hours.setEditable(true);
        minutes.setEditable(true);
        seconds.setEditable(true);
    }
}


