package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
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

    @FXML
    private TextField inputDate;

    @FXML
    private FXApplication application = FXApplication.getInstance();

    private LocalDate auctionDate;

    @FXML
    public void onEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            //TODO: fully test business rules
            Bootstrap bootstrap = new Bootstrap();

            ContactPerson contact = Session.getInstance().get("user", ContactPerson.class);
            auctionDate = LocalDate.parse(inputDate.getText());
            long auctionId = bootstrap.getAuctionRepository().fetchAllInChronologicalOrder().size() + 1;
            long orgId = contact.getOrganizationId();

            Auction addedAuction = new Auction(auctionId, orgId, auctionDate);
            if(contact.getOrganization().addAuction(addedAuction)) {
                application.getSceneController().activate("auctionAddSuccess");
            } else {
                application.getSceneController().activate("auctionAddFail");
            }
        }
    }

    @FXML
    public void back() {
        application.getSceneController().activate("contactMain");
    }

}
