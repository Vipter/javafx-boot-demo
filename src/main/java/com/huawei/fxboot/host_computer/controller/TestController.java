package com.huawei.fxboot.host_computer.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TestController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    TextField testField;
    @FXML
    public void btnAddTextClick(){
        testField.setText("测试");
    }
}
