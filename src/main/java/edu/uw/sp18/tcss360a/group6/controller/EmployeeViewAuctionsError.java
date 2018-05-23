package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.model.Employee;
import javafx.fxml.FXML;

/**
 * GUI for Employee users to view items between dates when they entered the
 * date in the incorrect format.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/23/2018
 */
public class EmployeeViewAuctionsError {

    @FXML
    private FXApplication application = FXApplication.getInstance();

    public EmployeeViewAuctionsError() {
        super();
    }

    @FXML
    public void back() {
        application.getSceneController().activate("employeeMain");
    }
}
