package com.example.uhr_decker_jhuber_nschickm;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class Fxmlloader {
    private Pane view;

    public Pane getPage(String filename) {
        try {
            URL fileurl = Fxmlloader.class.getResource(filename);

            if (fileurl == null) {
                throw new java.io.FileNotFoundException("FXML File not found");
            }

            view = FXMLLoader.load(fileurl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }
}
