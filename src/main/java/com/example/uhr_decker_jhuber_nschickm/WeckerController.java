package com.example.uhr_decker_jhuber_nschickm;

import View.BinaryViewGUI;
import View.WeckerViewGUI;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class WeckerController {
    public AnchorPane anchorpane;
    protected WeckerViewGUI weckerViewGUI;

    public void initialize(){
        weckerViewGUI = new WeckerViewGUI(anchorpane);
    }
}
