package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;
/**
 * Main menu GUI for Contact Person user options. Launches sub-menus.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class ContactMainController {
    private FXApplication application = FXApplication.getInstance();
    @FXML
    public void viewAuctions() { application.getSceneController().activate("contactViewAuctions"); }
    @FXML
    public void submitAuction() {
        application.getSceneController().activate("contactSubmitAuction");
    }
    @FXML
    public void addItem() {
        application.getSceneController().activate("contactAddItem");
    }
    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }
}
