package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;

/**
 * Main menu GUI for Bidder user options. Launches sub-menus.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class BidderMainController {

    private FXApplication application = FXApplication.getInstance();

    @FXML
    public void viewBids() {
        application.getSceneController().activate("viewBids");
    }

    @FXML
    public void placeBid() {
        application.getSceneController().activate("placeBid");
    }

    @FXML
    public void cancelBid() {
        application.getSceneController().activate("cancelBid");
    }
}
