package View;


import com.example.uhr_decker_jhuber_nschickm.HelloApplication;
import com.example.uhr_decker_jhuber_nschickm.HelloControllerAnalog;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Time;

public class AnalogViewGUI {

    AnchorPane anchorPane1;

    public AnalogViewGUI(AnchorPane anchorPane) {
        this.anchorPane1 = anchorPane;
    }

    public void display(Time time) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view2.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        HelloControllerAnalog helloControllerAnalog = fxmlLoader.getController();

        double alpha = 270 - time.getMinutes() * 6;
        double start_x = 200;
        double start_y = 200;
        double length = 175;

        double end_x = start_x + length * Math.cos(alpha);
        double end_y = start_y + length * Math.sin(alpha);

        Line line = new Line(start_x, start_y, end_x, end_y);

        anchorPane.getChildren().add(line);
        anchorPane1.getChildren().add(anchorPane);
    }
}

