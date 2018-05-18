package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;

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
    public void cancelBid() {
        application.getSceneController().activate("cancelBid");
    }
    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }



}
