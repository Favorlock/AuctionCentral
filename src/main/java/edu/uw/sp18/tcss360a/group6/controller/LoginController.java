package edu.uw.sp18.tcss360a.group6.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginController {

    @FXML
    private TextField userNameTextField;

    @FXML
    public void onEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            System.out.println(String.format("Hello %s", this.userNameTextField.getText()));
        }
    }

}
