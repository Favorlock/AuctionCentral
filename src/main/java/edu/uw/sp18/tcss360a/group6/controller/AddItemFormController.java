package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GUI for employees to view all auctions between dates that they specify inclusive.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class AddItemFormController {

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

    private long id;
    private long auctionId;
    private String description;
    private int quantity;
    private BigDecimal startBid;
    private String condition;
    private String size;
    private String location;
    private String comments;

    private FXApplication application = FXApplication.getInstance();

    @FXML
    public void onEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {


        }
    }

    @FXML
    public void back() {
        application.getSceneController().activate("contactAddItem");
    }

}
