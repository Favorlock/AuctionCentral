package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LogoutController extends Label {

    private FXApplication application = FXApplication.getInstance();

    @FXML
    public void logout() {
        Session.clear();
        this.application.getSceneController().activate("login");
    }

}
