package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.model.User;
import edu.uw.sp18.tcss360a.group6.model.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class BidderMainController {

    private FXApplication application = FXApplication.getInstance();

    @FXML
    public void viewBids() {
        application.getSceneController().activate("viewBids");
    }
    @FXML
    public void placeBid() {
        application.getSceneController().activate("placeBid");
    }
    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }



}
