package com.example.uhr_decker_jhuber_nschickm;

import View.TimerViewGUI;
import View.WeckerViewGUI;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author nschickm
 */
public class TimerController {
    public AnchorPane anchorpane;
    protected TimerViewGUI timerViewGUI;


    public void initialize(){
        timerViewGUI = new TimerViewGUI(anchorpane);
    }
}


