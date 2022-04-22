package com.example.uhr_decker_jhuber_nschickm;

import Model.SoundUtils;
import View.BinaryViewGUI;
import View.WeckerViewGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.*;
import java.sql.Time;

/**
 * WeckerController der die Elemente des Weckers steuert
 * @author nschikm
 */
public class WeckerController {
    public AnchorPane anchorpane;

    public TextField weckTime;
    public javafx.scene.control.Label weckTimeshow;
    public Button weckerbtn;
    public static float SAMPLE_RATE = 8000f;

    protected WeckerViewGUI weckerViewGUI;


    File wecker;

    public void initialize(){
        weckerViewGUI = new WeckerViewGUI(anchorpane, weckTime);
    }

    public void wecker(ActionEvent event) throws IOException, LineUnavailableException, UnsupportedAudioFileException, InterruptedException {


        String stime;

        stime = weckTime.getText();


        //Die Weckzeit wird in die Datei WeckerTime gespeichert
        wecker = new File("WeckerTime");
        FileWriter fwWecker = null;
        try {
            fwWecker = new FileWriter(wecker);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            fwWecker.write(String.valueOf(stime));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            fwWecker.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Wecker laeutet ausgabe
        boolean rv = false;

        //Thread
        try {
            rv = iscurrentWecker();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (rv) {
            weckTimeshow.setText("Wecker laeutet");
            for (int i = 0; i < 5; i++) {
                SoundUtils.tone(1000,100);
                Thread.sleep(1000);
            }

        }

    }



    /**
     * Die Weckzeit wird aus der Textdatei ausgelesen und mit der aktuellen Uhrzeit verglichen
     *
     * @return true wenn die Weckzeit und aktuelle Uhrzeit gleich sind
     * false wenn die Weckzeit und aktuelle Uhrzeit nicht sind
     * @throws IOException
     */
    public boolean iscurrentWecker() throws IOException {
        boolean rv = false;
        Time timenow = new Time(System.currentTimeMillis());


        //auslesen
        BufferedReader br = new BufferedReader(new FileReader(wecker));
        String st;
        String WeckTimeEintrag = null;
        while ((st = br.readLine()) != null) {
            WeckTimeEintrag = st;

        }

        //aktuelle Uhrzeit
        String[] parts = timenow.toString().split(":");

        //mit der aktullen Uhrzeit verlgeichen
        if ((parts[0] + ":" + parts[1]).equals(String.valueOf(WeckTimeEintrag))) {
            //Wecker laeutet
            rv = true;
        } else {
            //Wecker laeutet nicht
        }
        return rv;
    }
}

