package com.example.uhr_decker_jhuber_nschickm;

import View.BinaryViewGUI;
import View.WeckerViewGUI;
import javafx.scene.layout.BorderPane;

public class WeckerController {
    protected BorderPane mainpane;
    protected WeckerViewGUI weckerViewGUI;

    WeckerController(BorderPane mainpane){
        this.mainpane = mainpane;
        weckerViewGUI = new WeckerViewGUI(mainpane);
    }
}
