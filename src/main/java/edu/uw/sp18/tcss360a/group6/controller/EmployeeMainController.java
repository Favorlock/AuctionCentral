package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;
/**
 * Main menu GUI for Employee user options. Launches sub-menus.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class EmployeeMainController {

    private FXApplication application = FXApplication.getInstance();

    @FXML
    public void viewAllAuctions() { application.getSceneController().activate("employeeViewAllAuctions"); }

    @FXML
    public void viewAuctionsBetweenDates() {
        application.getSceneController().activate("employeeBetweenDates");
    }

    @FXML
    public void changeMaxAuctions() {
        application.getSceneController().activate("employeeChangeMax");
    }

    @FXML
    public void cancelAnAuction() {
        application.getSceneController().activate("employeeCancel");
    }
}
