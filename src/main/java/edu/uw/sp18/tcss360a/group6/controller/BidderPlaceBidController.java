package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.controller.components.ListViewCell;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.Bidder;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.util.List;

/**
 * GUI for users to place a bid on an Item in an Auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class BidderPlaceBidController implements Initializable {

    @FXML
    public ListView listView;

    @FXML
    public static Text bidMessageText;

    @FXML
    private FXApplication application = FXApplication.getInstance();

    private ObservableList auctions = FXCollections.observableArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    public BidderPlaceBidController() {
        Bidder bidder = Session.getInstance().get("user", Bidder.class);
        List<Auction> auction = bidder.getAuctionsICanBidIn();
        listView = new ListView();

        this.auctions.setAll(auction);
        listView.setItems(this.auctions);
        listView.setCellFactory((Callback<ListView<String>, ListCell<String>>)
                listView -> new ListViewCell());

        listView.setVisible(true);
    }

    @FXML
    private void displayAuctions() {
        listView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(auctions));
        listView.getSelectionModel().select(0);

    }

    @FXML
    public void placeBid() {
        Auction selectedAuction = (Auction)listView.getSelectionModel().getSelectedItem();
        BidderPlaceBidViewAuctionController.setAuction(selectedAuction);
        application.getSceneController().activate("placeBidViewAuction");
    }

    @FXML
    public void back() {
        application.getSceneController().activate("bidderMain");
    }

    @Override
    public void initialize() {
        displayAuctions();
    }
}
