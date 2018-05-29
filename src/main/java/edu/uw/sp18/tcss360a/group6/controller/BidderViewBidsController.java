package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.controller.components.ListViewCell;
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
 * GUI for users to view the bids they have placed.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class BidderViewBidsController implements Initializable{

    @FXML
    private ListView listView;

    private FXApplication application = FXApplication.getInstance();

    private ObservableList observableBids = FXCollections.observableArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    public BidderViewBidsController() {
        Bidder bidder = Session.getInstance().get("user", Bidder.class);
        List<Bid> bids = bidder.getPlacedBids();
        List<Item> items = new ArrayList<>();
        for (Bid bid: bids) {
            items.add(bid.getItem());
        }
        this.listView = new ListView();
        this.observableBids.setAll(items);
        this.listView.setItems(this.observableBids);
        this.listView.setCellFactory((Callback<ListView<String>, ListCell<String>>)
                listView -> new ListViewCell());
        this.listView.setVisible(true);
    }

    @FXML
    public void displayBids() {
        this.listView.itemsProperty().bind(this.listProperty);
        this.listProperty.set(FXCollections.observableArrayList(this.observableBids));
        listView.getSelectionModel().select(0);
    }

    @FXML
    public void back() {
        this.application.getSceneController().activate("bidderMain");
    }

    @Override
    public void initialize() {
        displayBids();
    }
}
