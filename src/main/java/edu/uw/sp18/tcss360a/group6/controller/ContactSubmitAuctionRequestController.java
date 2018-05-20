package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.ContactPerson;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.time.LocalDate;

/**
 * GUI for Contact person users to submit a request for a new auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class ContactSubmitAuctionRequestController {
    private FXApplication application = FXApplication.getInstance();
    //TODO: import actual user
    private ContactPerson contact = new ContactPerson(100,100, "hunded"); //context.get("user", ContactPerson.class);

    private LocalDate startDate;

    @FXML
    private TextField auctionDate;
    @FXML
    public void onEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            startDate = LocalDate.parse(auctionDate.getText());

        }
    }
    @FXML
    public void back() {
        application.getSceneController().activate("contactMain");
    }
    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }
}
