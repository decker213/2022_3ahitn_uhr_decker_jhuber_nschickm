package View;


import com.example.uhr_decker_jhuber_nschickm.Fxmlloader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

import java.io.IOException;
import java.sql.Time;

public class AnalogViewGUI {

    private AnchorPane h;
    private AnchorPane min;
    private AnchorPane sec;

    public AnalogViewGUI(AnchorPane h, AnchorPane min, AnchorPane sec) {
        this.h = h;
        this.min = min;
        this.sec = sec;
    }

    public void display(Time time) {
        double alphah = time.getHours() * 6;
        double alphamin = time.getMinutes() * 6 - alphah;
        double alphasec = time.getSeconds() * 6 - alphah;

        h.setRotate(alphah);
        min.setRotate(alphamin);
        sec.setRotate(alphasec);
    }

}