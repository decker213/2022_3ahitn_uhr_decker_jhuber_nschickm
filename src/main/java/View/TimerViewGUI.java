package View;

import com.example.uhr_decker_jhuber_nschickm.Fxmlloader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * @author nschickm
 * Der Timer muss in "hh:mm" eingegeben werden
 */
public class TimerViewGUI {


    /**
     * Ändert den Inhalt der Textfelder
     * @param l Textfeld
     * @param s String
     * @throws IOException
     */
    public void display(TextField l, String s){
        l.setText(s);

        };

}
