package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import javafx.fxml.FXML;

/**
 * GUI to display an auction with all of its Items that can be bid on.
 * Allows user to bid on one of these Items if they decide to.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/23/2018
 */
public class BidderPlaceBidViewAuctionController {

    private static Auction auction;

    @FXML
    private FXApplication application = FXApplication.getInstance();

    public BidderPlaceBidViewAuctionController() {
        super();
    }

    public static void setAuction(Auction anAuction) { //TODO: display the ???
        auction = anAuction;
    }

    @FXML
    public void selectAnotherAuction() {
        application.getSceneController().activate("placeBid");
    }

    @FXML
    public void back() {
        application.getSceneController().activate("bidderMain");
    }
}
