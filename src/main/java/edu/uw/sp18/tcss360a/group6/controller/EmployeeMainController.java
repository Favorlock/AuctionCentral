package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;

public class EmployeeMainController {

    private FXApplication application = FXApplication.getInstance();

    @FXML
    public void viewAuctions() {
        //Link to view auctions menu
    }
    @FXML
    public void changeMaxAuctions() {
        //Link to change max auctions menu
    }

    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }
}
