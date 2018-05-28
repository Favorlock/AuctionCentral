package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.controller.components.ListViewCell;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.Bid;
import edu.uw.sp18.tcss360a.group6.model.Bidder;
import edu.uw.sp18.tcss360a.group6.model.Item;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * GUI for users to view all items in an auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/28/2018
 */
public class BidderViewAllAuctionItemsController implements Initializable{

    private static Auction selectedAuction;

    @FXML
    private ListView listView;

    private FXApplication application = FXApplication.getInstance();

    private ObservableList auctionItems = FXCollections.observableArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    public BidderViewAllAuctionItemsController() {
        List<Item> items = selectedAuction.getInventory();

        this.listView = new ListView();
        this.auctionItems.setAll(items);
        this.listView.setItems(this.auctionItems);
        this.listView.setCellFactory((Callback<ListView<String>, ListCell<String>>)
                listView -> new ListViewCell());
        this.listView.setVisible(true);

    }

    @FXML
    public void displayItems() {
        this.listView.itemsProperty().bind(this.listProperty);
        this.listProperty.set(FXCollections.observableArrayList(this.auctionItems));
        listView.getSelectionModel().select(0);
    }

    public static void setAuction(Auction auction) {selectedAuction = auction; }
    @FXML
    public void selectAnotherAuctionBidder() {
        this.application.getSceneController().activate("bidderViewAllAuctions");
    }
    @FXML
    public void back() {
        this.application.getSceneController().activate("bidderMain");
    }

    @Override
    public void initialize() {
        displayItems();
    }
}
