package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;

public class ContactViewAuctionsController {

    private FXApplication application = FXApplication.getInstance();
    @FXML
    public void back() {
        application.getSceneController().activate("contactMain");
    }
    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }
}