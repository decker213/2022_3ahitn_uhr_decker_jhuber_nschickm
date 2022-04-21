package View;

import com.example.uhr_decker_jhuber_nschickm.Fxmlloader;
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

    private AnchorPane anchorPane;

    public TimerViewGUI(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;

    }

    public void display() throws IOException {

        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("Timer.fxml");

        JFrame f = new JFrame("Timer");
        final JTextField tf = new JTextField();
        final JTextField tfout = new JTextField();
        tf.setBounds(50, 50, 150, 20);
        tfout.setBounds(50, 250, 150, 20);
        JButton b = new JButton("Set Timer");
        b.setBounds(50, 100, 150, 20);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             tfout.setText(tf.getText());
            }
        });

        f.add(b);
        f.add(tf);
        f.add(tfout);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
}
}
