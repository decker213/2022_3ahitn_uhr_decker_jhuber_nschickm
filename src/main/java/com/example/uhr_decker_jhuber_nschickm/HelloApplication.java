package com.example.uhr_decker_jhuber_nschickm;

import View.BinaryViewGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Time;


public class HelloApplication extends Application implements Runnable {
    BinaryViewGUI bvg;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {
        launch();

    }

    @Override
    public void run() {

    }
}