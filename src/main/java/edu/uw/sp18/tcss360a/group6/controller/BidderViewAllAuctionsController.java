package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.controller.components.ListViewCell;
import edu.uw.sp18.tcss360a.group6.model.Auction;
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
 * GUI for users to view all auctions in the system.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/28/2018
 */
public class BidderViewAllAuctionsController implements Initializable{

    @FXML
    private ListView listView;

    private FXApplication application = FXApplication.getInstance();

    private ObservableList auctions = FXCollections.observableArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    public BidderViewAllAuctionsController() {
        Bootstrap bootstrap = new Bootstrap();
        List<Auction> auction = bootstrap.getAuctionRepository().fetchAllInChronologicalOrder();
        listView = new ListView();
        this.auctions.setAll(auction);
        listView.setItems(this.auctions);
        listView.setCellFactory((Callback<ListView<String>, ListCell<String>>) listView -> new ListViewCell());
        listView.setVisible(true);
    }

    @FXML
    public void displayAuctions() {
        listView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(auctions));
        listView.getSelectionModel().select(0);
    }

    @FXML
    public void bidderOpenItems() {
        Auction selectedAuction = (Auction)listView.getSelectionModel().getSelectedItem();
        BidderViewAllAuctionItemsController.setAuction(selectedAuction);
        application.getSceneController().activate("bidderViewAllAuctionItems");
    }

    @FXML
    public void back() {
        this.application.getSceneController().activate("bidderMain");
    }

    @Override
    public void initialize() {
        displayAuctions();
    }
}
