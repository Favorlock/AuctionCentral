package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.SceneController;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.model.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
public class EmployeeChangeMaxAuctionsController {

    private FXApplication application = FXApplication.getInstance();

    @FXML
    private TextField newMax;

    @FXML
    public void onEnter(KeyEvent event) { //TODO: show the current auction max on gui and new max
        if (event.getCode().equals(KeyCode.ENTER)) {
            Employee employee = Session.getInstance().get("user", Employee.class);
            int max = Integer.parseInt(newMax.getText());
            System.out.println("old Max: " + employee.getAuctionCapacity());
            employee.setAuctionCapacity(max);
            System.out.println("new Max: " + employee.getAuctionCapacity());
        }
    }

    @FXML
    public void back() {
        application.getSceneController().activate("employeeMain");
    }
}
