package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.model.ContactPerson;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

import java.awt.*;

/**
 * Main menu GUI for Contact Person user options. Launches sub-menus.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class ContactMainController {
    @FXML
    public Label viewAuctionsLabelCP;
    @FXML
    public Label viewItemsLabelCP;

    private FXApplication application = FXApplication.getInstance();

    @FXML
    public void viewAuctions() {
        ContactPerson currentCP = Session.getInstance().get("user", ContactPerson.class);
        try {
            currentCP.getOrganization().getCurrentAuction();
            application.getSceneController().activate("contactViewAuctions");
        } catch (NullPointerException e) {
            viewAuctionsLabelCP.setTextFill(Paint.valueOf("RED"));
        }
    }

    @FXML
    public void submitAuction() {
        application.getSceneController().activate("contactSubmitAuction");
    }

    @FXML
    public void addItem() {
        ContactPerson currentCP = Session.getInstance().get("user", ContactPerson.class);
        try {
            currentCP.getOrganization().getCurrentAuction();
            application.getSceneController().activate("contactAddItem");
        } catch (NullPointerException e) {
            viewItemsLabelCP.setTextFill(Paint.valueOf("RED"));
        }
    }
}
