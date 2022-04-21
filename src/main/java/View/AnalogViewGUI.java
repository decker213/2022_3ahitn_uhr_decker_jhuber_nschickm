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

/**
 * @author decker
 */
public class AnalogViewGUI {

    private AnchorPane h;
    private AnchorPane min;
    private AnchorPane sec;

    /**
     * @param h Anchorpane in der der Stunden Zeiger rotiert wird
     * @param min Anchorpane in der der Minuten Zeiger rotiert wird
     * @param sec Anchorpane in der der Sekunden Zeiger rotiert wird
     */
    public AnalogViewGUI(AnchorPane h, AnchorPane min, AnchorPane sec) {
        this.h = h;
        this.min = min;
        this.sec = sec;
    }

    /**
     * Zeigt die Zeit im analogen Format an
     * @param time Zeit, welche angezeigt wird
     */
    public void display(Time time) {
        double alphah;
        double alphamin;
        double alphasec;

        if (time.getHours() < 12) {
            alphah = (time.getHours() - 12) * 30;
        } else {
            alphah = time.getHours() * 30;
        }

        alphamin = time.getMinutes() * 6 - alphah;
        alphasec = time.getSeconds() * 6 - alphah;

        h.setRotate(alphah);
        min.setRotate(alphamin);
        sec.setRotate(alphasec);
    }

}