package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * GUI for users to view the bids they have placed.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class ViewBidsController {

    @FXML
    private TextField myBidsView;
    private FXApplication application = FXApplication.getInstance();
    @FXML
    public void back() {
        application.getSceneController().activate("bidderMain");
    }
    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }
}
