package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * GUI for employees to view all auctions between dates that they specify inclusive.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class EmployeeViewAuctionsBetweenDatesController {

    @FXML
    private TextField startDate;
    @FXML
    private TextField endDate;

    private FXApplication application = FXApplication.getInstance();
    @FXML
    public void onEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {

        }
    }
    @FXML
    public void back() {
        application.getSceneController().activate("employeeMain");
    }
    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }
}
