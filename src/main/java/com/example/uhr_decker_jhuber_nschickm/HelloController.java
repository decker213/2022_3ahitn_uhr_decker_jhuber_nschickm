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

/**
 * @author decker, jhuber, nschickm
 */
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
    public TextField TimerTime;
    public Label TimerTimeshow;
    public Button timerbtnid1;
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
    private WeckerViewGUI wevg;
    private BinaryController bc;
    private WeckerController wc;
    private TimerController tc;
    private TimerViewGUI tivg;



    @FXML
    private BorderPane mainpane;

    @FXML
    private Button showAnalogUhrbtn;

    /**
     *  Analoguhr wird angezeigt
     * @param event
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
     *  Binaryuhr wird angezeigt
     * @param event
     * @throws IOException
     */
    @FXML
    void showBinaryUhr(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Binaryclock.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.show();
    }

    /**
     *  Digitaluhr wird angezeigt
     * @param actionEvent
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
     *  Labels werden angezeigt und mit Daten versehen
     * @param event
     * @throws IOException
     */
    public void showWeatherTemp(ActionEvent event) throws IOException {
        wvg.display(stadt.getText());
    }

    /**
     * Zur Startseite kommen, geht nicht ganzes Fenster schließt sich anstatt der aktuellen Scene
     * @param event
     */
    public void showMainPage(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

    }

    /**
     *  Das Wecker fxml wird angezeigt
     * @param event
     * @throws IOException
     */
    public void wecker(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Wecker.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.show();
    }

    public void initialize() {
        bvg = new BinaryViewGUI(mainpane);
        wvg = new WeatherViewGUI(mainpane, wetter, temperatur, stadt, date);;
    }


    public void timer(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Timer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.show();
    }
}

