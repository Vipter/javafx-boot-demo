package com.spartajet.fxboot.demo.controller;

import com.spartajet.fxboot.demo.MainController;
import com.spartajet.fxboot.demo.base.LoginUserInfo;
import com.spartajet.fxboot.demo.service.LoginUserService;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;
@FXMLController
public class LoginController implements Initializable {
    @SuppressWarnings("unused")
    private MainController mainController;
    @FXML
    private TextField name;
    @FXML
    private PasswordField pwd;
    @FXML
    private TextField user;
    @Autowired
    private LoginUserService userService;
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void submit(){

    }

    @FXML
    public void getUser(){
        LoginUserInfo u = userService.getUser(1);
        user.setText(u.getUserName());
    }

    public void setMainApp(MainController mainController) {
        this.mainController = mainController;
    }

}
