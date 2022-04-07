package View;


import com.example.uhr_decker_jhuber_nschickm.Fxmlloader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import java.io.IOException;
import java.sql.Time;

public class AnalogViewGUI {

    BorderPane mainpane;

    public AnalogViewGUI(BorderPane borderPane) {
        mainpane = borderPane;
    }

    public void display(Time time) {
        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("Analog-Uhr.fxml");

        double alpha = 270 - time.getMinutes() * 6;
        double start_x = 150;
        double start_y = 150;
        double length = 175;

        double end_x = start_x + length * Math.cos(alpha);
        double end_y = start_y + length * Math.sin(alpha);

        Line line = new Line(start_x, start_y, end_x, end_y);

        mainpane.getChildren().add(line);
        mainpane.setCenter(view);
    }


}

