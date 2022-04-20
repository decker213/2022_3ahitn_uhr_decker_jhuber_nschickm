package View;

import com.example.uhr_decker_jhuber_nschickm.Fxmlloader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Time;

public class WeckerViewGUI {

    protected Label weckTimeshow;
    protected TextField weckTime;
    String stime;
    private BorderPane mainpane;


    public WeckerViewGUI(BorderPane borderPane) {
        mainpane = borderPane;

    }

    public void display() throws IOException {

        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("Wecker.fxml");
    //    weckTimeshow.setText(weckTime.getText());



        JFrame f=new JFrame("Button Example");
        final JTextField tf=new JTextField();
        final JTextField tfout=new JTextField();
        tf.setBounds(50,50, 150,20);
        tfout.setBounds(50,250,150,20);
        JButton b=new JButton("Set Wecker");
        b.setBounds(50,100,95,30);
        b.addActionListener(new ActionListener(){
            String s;
            public void actionPerformed(ActionEvent e) {
                //  tf.setText("Welcome to Javatpoint.");
                stime = tf.getText();
                   tfout.setText(stime);
            }
        });

        File wecker = new File("WeckerTime");
        FileWriter fwWecker = new FileWriter(wecker);
        fwWecker.write(String.valueOf(stime));

        fwWecker.close();

        BufferedReader br = new BufferedReader(new FileReader(wecker));
        String st;
        while ((st = br.readLine()) != null) {
            this.stime = st;
            System.out.println(stime);
        }

        f.add(b);f.add(tf);f.add(tfout);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);




        mainpane.setCenter(view);
    }

}


