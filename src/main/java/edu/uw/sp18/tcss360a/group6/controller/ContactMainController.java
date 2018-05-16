package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;

public class ContactMainController {

    private FXApplication application = FXApplication.getInstance();

    @FXML
    public void viewAuctions() {
        application.getSceneController().activate("contactViewAuctions");
    }
    @FXML
    public void submitAuction() {
        //Link to submit auctions menu
    }
    @FXML
    public void addItem() {
        //Link to add item menu
    }
    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }
}
