package com.example.uhr_decker_jhuber_nschickm;

import View.BinaryViewGUI;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.Time;

/**
 * @author nschickm
 * Mittels eines Threads wird Binaryuhr aktualisiert
 */
public class BinaryController {

    public BorderPane borderpane;
    protected BinaryViewGUI binaryViewGUI;

    public void initialize(){
        binaryViewGUI = new BinaryViewGUI(borderpane);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            binaryViewGUI.display(new Time(System.currentTimeMillis()));
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


}
