package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.model.Bidder;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Main menu GUI for Bidder user options. Launches sub-menus.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class BidderMainController implements Initializable {

    @FXML
    private Label viewbids;
    @FXML
    private Label placebid;
    @FXML
    private Label cancelbid;

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

    @Override
    public void initialize() {
        Bidder bidder = Session.getInstance().get("user", Bidder.class);
        if(bidder.getPlacedBids().size() == 0) {
            viewbids.setDisable(true);
            cancelbid.setDisable(true);
        }

        if(!bidder.canBid()) {
            placebid.setDisable(true);
        }

    }
}
