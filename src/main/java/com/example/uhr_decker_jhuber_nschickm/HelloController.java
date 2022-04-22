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

    /**
     * Öffnet die Stoppuhr
     * @param event Click auf den Stoppuhr-Button
     * @throws IOException
     */
    @FXML
    void Stoppuhrbtnclicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Stoppuhr.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.show();
    }

    /**
     * Öffnet die Analoguhr
     * @param event Click auf den Analoguhr-Button
     * @throws IOException
     */
    @FXML
    void showAnalogUhr(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Analog-Uhr.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.show();
    }

    /**
     * Öffnet die Binäruhr
     * @param event Click auf Binäruhrbutton
     * @throws IOException
     */
    @FXML
    void showBinaryUhr(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BinaryClock.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.show();

    }

    /**
     * Öffnet die Digitaluhr
     * @param actionEvent CLick auf den Digitaluhr-Button
     * @throws IOException
     */
    public void showDigitaluhr(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Digital-Uhr.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.show();
    }

    /**
     * Zeigt wetter in ausgewählter Stadt an
     * @param event Click auf den Wetter-Button(abfragen)
     * @throws IOException
     */
    public void showWeatherTemp(ActionEvent event) throws IOException {
        wvg.display(stadt.getText());
    }



    // Zur Startseite kommen, geht nicht ganzes Fenster schließt sich anstatt der aktuellen Scene

    /**
     * Schließt das Fenster
     * @param event Click auf X button
     */
    public void showMainPage(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

    }

    /**
     * Öffnet den Wecker
     * @param event CLick auf Wecker-Button
     * @throws IOException
     */
    public void wecker(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Wecker.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.show();
    }

    /**
     * Initialisiert dei WeatherViewGUI
     */
    public void initialize() {
        wvg = new WeatherViewGUI(mainpane, wetter, temperatur, stadt, date);
    }

    /**
     * Öffnet den Timer
     * @param actionEvent Click auf den Timer-Button
     * @throws IOException
     */
    public void showTimer(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Timer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.show();
    }
}

