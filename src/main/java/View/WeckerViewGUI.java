package View;

import com.example.uhr_decker_jhuber_nschickm.Fxmlloader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Time;

/**
 * @author nschickm
 * Die Weckzeit muss in "hh:mm" erfolgen
 */
public class WeckerViewGUI {

    protected Label weckTimeshow;
    protected javafx.scene.control.TextField weckTime;
    protected AnchorPane anchorPane;
    protected javafx.scene.control.Label l;

    File wecker;

    /**
     * Konstruktor
     *
     * @param anchorPane
     */
    public WeckerViewGUI(AnchorPane anchorPane, javafx.scene.control.TextField weckTime) {
        this.anchorPane = anchorPane;
        this.weckTime = weckTime;

    }


    /**
     * Wird ausgegeben
     *
     * @throws IOException
     */
    public void display() throws IOException {

        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("Wecker.fxml");

        String stime;


        stime = weckTime.getText();

        System.out.println("eeee " +stime);
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
        } else {
            weckTimeshow.setText("Wecker laeutet nicht");
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

