package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.model.Auction;
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
    @FXML
    public Label changeMaxAuctionLabel;
    @FXML
    public Label currentNewMaxLabel;

    private FXApplication application = FXApplication.getInstance();

    @FXML
    private TextField newMax;

    @FXML
    public void onEnter(KeyEvent event) {
        currentNewMaxLabel.setText("Current Max " + Auction.MAX_UPCOMING_AUCTIONS + ". Enter a new Max: ");
        if (event.getCode().equals(KeyCode.ENTER)) {
            Employee employee = Session.getInstance().get("user", Employee.class);
            try {
                int max = Integer.parseInt(newMax.getText());
                if (employee.setAuctionCapacity(max)){
                    changeMaxAuctionLabel.setText("You have sucessfully changed the maximum number" +
                            " of upcoming auctions allowed");
                } else {
                    changeMaxAuctionLabel.setText("The amount entered must be a " +
                            "positive integer greater than the number of upcoming auctions.");
                }
            } catch (NumberFormatException e) {
                changeMaxAuctionLabel.setText("The amount entered must be a " +
                        "positive integer greater than the number of upcoming auctions.");
            }
        }
    }
    @FXML
    public void back() {
        application.getSceneController().activate("employeeMain");
    }
}
