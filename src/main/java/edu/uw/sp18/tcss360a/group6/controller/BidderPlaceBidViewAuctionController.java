package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.Bootstrap;
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
import javafx.scene.control.TextField;
import javafx.util.Callback;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GUI to display an auction with all of its Items that can be bid on.
 * Allows user to bid on one of these Items if they decide to.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/23/2018
 */
public class BidderPlaceBidViewAuctionController implements Initializable {

    private static Auction auction;

    @FXML
    public ListView listView;

    @FXML
    private FXApplication application = FXApplication.getInstance();

    @FXML
    private TextField bidderAmount;

    private ObservableList items = FXCollections.observableArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    public BidderPlaceBidViewAuctionController() {
        super();

        Bootstrap bootstrap = new Bootstrap();
//        Item item = bootstrap.getItemRepository().fetchAll().stream().filter(item -> item.getId() == theItem.getId());
/*
        List<Long> bidItemIds = bidder.getPlacedBids().stream()
                .map(Bid::getItemId)
                .distinct()
                .collect(Collectors.toList());
        List<Item> items = auction.getInventory().stream()
                .filter(item -> !bidItemIds.contains(item.getId()))
                .collect(Collectors.toList());
 */

        List<Item> auctionItems = auction.getInventory();
        //TODO: can see auction with no items, put items in all auctions

        listView = new ListView();
        this.items.setAll(auctionItems);
        listView.setItems(this.items);
        listView.setCellFactory((Callback<ListView<String>, ListCell<String>>)
                listView -> new ListViewCell());

        listView.setVisible(true);
    }

    public static void setAuction(Auction anAuction) {
        auction = anAuction;
    }

    @FXML
    public void displayItems() {
        listView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(items));
    }
    @FXML
    public void clearText() {
        bidderAmount.setText("");
    }

    @FXML
    public void placeBidOnItem() { //TODO: CODE DEFENSIVE FOR INVALID BID IN TEXT FIELD
        // check if user entered valid input into the text field
        try {
            BigDecimal bidAmount = new BigDecimal(bidderAmount.getText());

            Item theItem = (Item)listView.getSelectionModel().getSelectedItem();
            Bidder theBidder = Session.getInstance().get("user", Bidder.class);

            theBidder.addBid(bidAmount, theItem, auction);
        } catch (NumberFormatException e) {
            bidderAmount.setText("Enter valid bid amount");
        }
    }

    @FXML
    public void selectAnotherAuction() {
        application.getSceneController().activate("placeBid");
    }

    @FXML
    public void back() {
        application.getSceneController().activate("bidderMain");
    }

    @Override
    public void initialize() {
        displayItems();
    }
}
