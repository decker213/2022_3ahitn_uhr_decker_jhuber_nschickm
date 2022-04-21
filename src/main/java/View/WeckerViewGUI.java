package View;

import com.example.uhr_decker_jhuber_nschickm.Fxmlloader;
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
    protected TextField weckTime;
    private BorderPane mainpane;

    File wecker;

    /**
     * Konstruktor
     *
     * @param borderPane
     */
    public WeckerViewGUI(BorderPane borderPane) {
        mainpane = borderPane;

    }

    /**
     * Wird ausgegeben
     *
     * @throws IOException
     */
    public void display() throws IOException {

        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("Wecker.fxml");

        //Buttons und Textfelder hier erstellt, weil die Wecker.fxml (Zeile 36) nicht richtig aufgerufen wird
        JFrame f = new JFrame("Wecker");
        final JTextField tf = new JTextField();
        final JTextField tfout = new JTextField();
        tf.setBounds(50, 50, 150, 20);
        tfout.setBounds(50, 250, 150, 20);
        JButton b = new JButton("Set Wecker");
        b.setBounds(50, 100, 150, 20);
        b.addActionListener(new ActionListener() {

            String stime;

            /**
             * Wird ausgefuehrt, wenn der "Set Wecker" - Button geklickt wird
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                //  tf.setText("Welcome to Javatpoint.");
                stime = tf.getText();


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
                    tfout.setText("Wecker laeutet");
                } else {
                    tfout.setText("Wecker laeutet nicht");
                }
            }
        });

        f.add(b);
        f.add(tf);
        f.add(tfout);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        mainpane.setCenter(view);
    }

    /**
     * Die Weckzeit wird aus der Textdatei ausgelesen und mit der aktuellen Uhrzeit vergliechen
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


