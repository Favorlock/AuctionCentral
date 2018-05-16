package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;

public class PlaceBidController {

    private FXApplication application = FXApplication.getInstance();
    @FXML
    public void back() {
        application.getSceneController().activate("bidderMain");
    }
    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }

}
