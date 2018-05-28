package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.math.BigDecimal;

/**
 * GUI for employees to view all auctions between dates that they specify inclusive.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class ContactAddItemFormController {

    @FXML
    private TextField descriptionField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField startBidField;
    @FXML
    private TextField conditionField;
    @FXML
    private TextField sizeField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField commentsField;
    @FXML
    private Label addItemMessageText;

    private static Auction auction;

    private long itemId;
    private long auctionId;
    private String description;
    private int quantity;
    private BigDecimal startBid;
    private String condition;
    private String size;
    private String comments;

    private FXApplication application = FXApplication.getInstance();

    @FXML
    public void onEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            addItem();
        }
    }

    @FXML
    public void addItem() { //TODO: validate all fields are valid
        Bootstrap bootstrap = new Bootstrap();
        itemId = bootstrap.getItemRepository().fetchAll().size() + 2;
        auctionId = auction.getId();

        description = descriptionField.getText();
        quantity = Integer.parseInt(quantityField.getText());
        startBid = new BigDecimal(startBidField.getText());
        condition = conditionField.getText();
        size = sizeField.getText();
        comments = commentsField.getText();

        //create the item and add to the auction
        Item item = new Item(itemId, auctionId, description, quantity,
                startBid, condition, size, "a5", comments);

        showAddItemStatus(auction.addItem(item));
        resetTextFields();
    }
    /** Show if the item added or not on the GUI. */
    private void showAddItemStatus(boolean didAdd) {
        if(didAdd) {
            addItemMessageText.setText("Item was added to the auction. Add another Item");
        } else {
            addItemMessageText.setText("Item was not added to the auction");
        }
    }
    /** set all user entry text fields to blank. */
    private void resetTextFields() {
        descriptionField.setText("");
        quantityField.setText("");
        startBidField.setText("");
        conditionField.setText("");
        sizeField.setText("");
        commentsField.setText("");
    }

    public static void setAuction(Auction anAuction) {
        auction = anAuction;
    }

    @FXML
    public void back() {
        application.getSceneController().activate("contactAddItem");
    }

}
