package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;
/**
 * GUI for employee to attempt to cancel an auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class EmployeeCancelAnAuctionController {

    private FXApplication application = FXApplication.getInstance();
    @FXML
    public void back() {
        application.getSceneController().activate("employeeMain");
    }
    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }
}
