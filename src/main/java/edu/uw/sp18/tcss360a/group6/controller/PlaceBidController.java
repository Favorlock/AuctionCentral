package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;
/**
 * GUI for users to place a bid on an Item in an Auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class PlaceBidController {

    private FXApplication application = FXApplication.getInstance();

    @FXML
    public void back() {
        application.getSceneController().activate("bidderMain");
    }
}
