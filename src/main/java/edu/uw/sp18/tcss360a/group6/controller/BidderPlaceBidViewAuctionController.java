package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.Item;
import edu.uw.sp18.tcss360a.group6.util.ListViewCell;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.util.List;

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
    public ListView listView;

    @FXML
    private FXApplication application = FXApplication.getInstance();

    private ObservableList auctions = FXCollections.observableArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    public BidderPlaceBidViewAuctionController() {
        super();

//        List<Item> auctionItems = auction.getInventory(); //Todo: get items for an auction here
//
//        listView = new ListView();
//        this.auctions.setAll(auction);
//        listView.setItems(this.auctions);
//        listView.setCellFactory((Callback<ListView<String>, ListCell<String>>)
//                listView -> new ListViewCell());
//
//        listView.setVisible(true);
    }

    public static void setAuction(Auction anAuction) {
        auction = anAuction;
    }

    @FXML
    public void displayItems() {
        listView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(auctions));
    }

    @FXML
    public void placeBidOnItem() {

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
