package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;

public class EmployeeMainController {

    private FXApplication application = FXApplication.getInstance();

    @FXML
    public void viewAllAuctions() {
        application.getSceneController().activate("viewAllAuctions");
    }

    @FXML
    public void viewAuctionsBetweenDates() {
        application.getSceneController().activate("viewAuctionsBetweenDates");
    }

    @FXML
    public void changeMaxAuctions() {
        application.getSceneController().activate("changeMaxAuctions");
    }

    @FXML
    public void cancelAnAuction() {
        application.getSceneController().activate("cancelAnAuction");
    }

    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }
}
