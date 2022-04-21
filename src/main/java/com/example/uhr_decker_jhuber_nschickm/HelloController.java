package com.example.uhr_decker_jhuber_nschickm;

import Model.Stoppuhr;
import Model.Timer;
import Model.Wecker;
import Model.Zeitzone;
import View.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
    public Button weckerbtn;
    public TextField weckTime;
    public Label weckTimeshow;
    public Button weckerbtnid;
    public Label date;
    private Timer timer;
    private Wecker wecker;
    private Zeitzone zeitzone;
    private Stoppuhr stoppuhr;
    private DigitalViewGUI digitalvg;
    private DateViewGUI datevg;
    private BinaryViewGUI bvg;
    private WeatherViewGUI wvg;
    private TemperatureViewGUI tvg;
    private WeckerViewGUI wevg;
    private BinaryController bc;
    private WeckerController wc;
    private Button stoppuhrbtn;
    StoppuhrController stoppuhrController;

    @FXML
    private BorderPane mainpane;

    @FXML
    private Button showAnalogUhrbtn;

    @FXML
    void Stoppuhrbtnclicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Stoppuhr.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.show();
    }

    @FXML
    void showAnalogUhr(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Analog-Uhr.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.show();
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

    public void showDigitaluhr(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Digital-Uhr.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.show();
    }


    public void showWeatherTemp(ActionEvent event) throws IOException {
        wvg.display(stadt.getText());
    }

    // Zur Startseite kommen, geht nicht ganzes Fenster schließt sich anstatt der aktuellen Scene
    public void showMainPage(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

    }

    public void wecker(ActionEvent event) throws IOException {
        //wevg.display();
        wc.weckerViewGUI.display();
        wc.weckerViewGUI.iscurrentWecker();
        System.out.println(wc.weckerViewGUI.iscurrentWecker());
    }

    public void initialize() {
        bc = new BinaryController(mainpane);
        bvg = new BinaryViewGUI(mainpane);
        wvg = new WeatherViewGUI(mainpane, wetter, temperatur, stadt, date);
        wevg = new WeckerViewGUI(mainpane);
        wc = new WeckerController(mainpane);
    }

}

