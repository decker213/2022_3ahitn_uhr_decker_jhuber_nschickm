package com.example.uhr_decker_jhuber_nschickm;

import View.TimerViewGUI;
import View.WeckerViewGUI;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author nschickm
 */
public class TimerController {
    protected TimerViewGUI timerViewGUI;
    protected BorderPane mainpane;


    TimerController(BorderPane mainpane) {
        this.mainpane = mainpane;
        timerViewGUI = new TimerViewGUI(mainpane);
    }
}


