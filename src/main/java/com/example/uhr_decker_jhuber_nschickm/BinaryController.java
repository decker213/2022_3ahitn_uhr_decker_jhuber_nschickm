package com.example.uhr_decker_jhuber_nschickm;

import View.BinaryViewGUI;
import javafx.scene.layout.BorderPane;

public class BinaryController {
    protected BorderPane mainpane;
    protected BinaryViewGUI binaryViewGUI;

    BinaryController(BorderPane mainpane){
    this.mainpane = mainpane;
    binaryViewGUI = new BinaryViewGUI(mainpane);
    }


}
