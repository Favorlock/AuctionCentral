package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.Bid;
import edu.uw.sp18.tcss360a.group6.model.Bidder;
import edu.uw.sp18.tcss360a.group6.util.ListViewCell;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI for users to view the bids they have placed.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class ViewBidsController {

    @FXML
    private ListView listView;

    private FXApplication application = FXApplication.getInstance();

    private ObservableList observableBids = FXCollections.observableArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    public ViewBidsController () {
        Bidder bidder = Session.getInstance().get("user", Bidder.class);
        List<Bid> bids = bidder.getPlacedBids();

        listView = new ListView();

        List<String> bidsString = new ArrayList<>();
        //add the items to the list
        for(Bid anBid : bids) {
            bidsString.add(anBid.getItem().toString()); //.getItem()
        }

        this.observableBids.setAll(bidsString);
        listView.setItems(this.observableBids);
        listView.setCellFactory((Callback<ListView<String>, ListCell<String>>) listView -> new ListViewCell());

        listView.setVisible(true);

        displayBids(); // TODO: this should display them initially ????
    }

    @FXML
    public void displayBids() {
        listView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(observableBids));
    }

    @FXML
    public void back() {
        application.getSceneController().activate("bidderMain");
    }
}
