package View;


import com.example.uhr_decker_jhuber_nschickm.Fxmlloader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
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

        double alphamin = 270 - time.getMinutes() * 6;
        double start_x = 300;
        double start_y = 20;
        double lengthmin = 120;

        double end_x = start_x + lengthmin * Math.cos(alphamin);
        double end_y = start_y + lengthmin * Math.sin(alphamin);

        Line line = new Line(start_x, start_y, end_x, end_y);
        Circle circle = new Circle();
        circle.setCenterX(100.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(75.0f);
        circle.setFill(Color.WHITE);

        mainpane.getChildren().add(circle);
        mainpane.getChildren().add(line);
        mainpane.setCenter(view);
    }

}
