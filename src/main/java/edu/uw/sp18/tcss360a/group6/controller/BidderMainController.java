package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.ContactPerson;
import javafx.fxml.FXML;

import java.util.List;

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
    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }



}
