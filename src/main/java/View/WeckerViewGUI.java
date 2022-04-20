package View;

import com.example.uhr_decker_jhuber_nschickm.Fxmlloader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
 */
public class WeckerViewGUI {

    protected Label weckTimeshow;
    protected TextField weckTime;
    private BorderPane mainpane;

    File wecker;

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
            String stime;
            public void actionPerformed(ActionEvent e) {
                //  tf.setText("Welcome to Javatpoint.");
                stime = tf.getText();
                tfout.setText(stime);

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

                final JTextField tfouttime=new JTextField();
                tfouttime.setBounds(50,300,150,20);

                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(wecker));
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                String st = null;
                while (true) {
                    try {
                        if (!((st = br.readLine()) != null)) break;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    
                    this.stime = st;
                    System.out.println("aaa " + stime);
                    tfouttime.setText(this.stime);
                }
                
                
                f.add(tfouttime);
            }
        });

        f.add(b);f.add(tf);f.add(tfout);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);





        mainpane.setCenter(view);
    }
    public boolean iscurrentWecker() throws IOException {
        boolean rv = false;
        Time timenow = new Time(System.currentTimeMillis());


        BufferedReader br = new BufferedReader(new FileReader(wecker));
        String st;
        String WeckTimeEintrag = null;
        while ((st = br.readLine()) != null) {
            WeckTimeEintrag = st;
            System.out.println("this " + WeckTimeEintrag);
        }

        String[] parts = timenow.toString().split(":");

        String stime=null;
        System.out.println("aa" + stime);
        JTextField uhr = new JTextField();
        uhr.setBounds(50,50,230,20);
        if ((parts[0] + ":" + parts[1]).equals(String.valueOf(stime))) {
           System.out.println("true");
           uhr.setText("True");
            rv = true;
        }

        System.out.println("false");
        uhr.setText("False");
        return rv;



    }


}


