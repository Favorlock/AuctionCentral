package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * GUI for employee to attempt to change the maximum amount of auctions
 * allowed.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class AuctionAddSuccessController {

    private FXApplication application = FXApplication.getInstance();
    @FXML
    public void addItems() {application.getSceneController().activate("contactAddItem"); }
    @FXML
    public void back() {
        application.getSceneController().activate("employeeMain");
    }
    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }
}
