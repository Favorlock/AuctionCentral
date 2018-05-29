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
        condition = conditionField.getText();
        boolean validQuantity = isValidQuantityEntered();
        boolean validBid = isValidBidEntered();
        boolean validSize = isValidSize();
        comments = commentsField.getText();

        //create the item and add to the auction if valid
        if(validQuantity && validBid && validSize) {
            Item item = new Item(itemId, auctionId, description, quantity,
                    startBid, condition, size, "a5", comments);

            showAddItemStatus(auction.addItem(item));
            resetTextFields();
        }
    }

    /**
     * Returns true if the user entered a valid integer quantity.
     * @return if user enter valid quantity
     */
    private boolean isValidQuantityEntered() {
        boolean parsed = true;
        try {
            quantity = Integer.parseInt(quantityField.getText());
            if (quantity <= 0) {
                quantityField.setText("");
                addItemMessageText.setText("must enter a positive integer");

                parsed = false;
            }
        } catch (NumberFormatException e) {
            quantityField.setText("");
            addItemMessageText.setText("must enter a positive integer");
            parsed = false;
        }
        return parsed;
    }

    /**
     * Get if the user entered a valid bid decimal amount.
     * @return if valid bid entered
     */
    private boolean isValidBidEntered() {
        boolean parsed = true;
        try {
            startBid = new BigDecimal(startBidField.getText());
        } catch (NumberFormatException e) {
            startBidField.setText("");
            addItemMessageText.setText("must enter a valid bid");
            parsed = false;
        }
        return parsed;
    }

    /**
     * Get if the size string entered is valid.
     * @return true if valid size entered
     */
    private boolean isValidSize() {
        boolean parsed = false;

        if(sizeField.getText().equalsIgnoreCase("small") ||
                sizeField.getText().equalsIgnoreCase("medium") ||
                sizeField.getText().equalsIgnoreCase("large") ) {
            size = sizeField.getText();
            parsed = true;
        } else  {
            sizeField.setText("");
            addItemMessageText.setText("must enter small, medium or large");
            parsed = false;
        }
        return parsed;
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

    @FXML
    public void mainMenuContactPerson() {
        application.getSceneController().activate("contactMain");
    }



}
