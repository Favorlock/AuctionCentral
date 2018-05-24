package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.model.Bid;
import edu.uw.sp18.tcss360a.group6.model.Bidder;
import edu.uw.sp18.tcss360a.group6.controller.components.ListViewCell;
import javafx.application.Platform;
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

        this.listView = new ListView();
        this.observableBids.setAll(bids);
        this.listView.setItems(this.observableBids);
        this.listView.setCellFactory((Callback<ListView<String>, ListCell<String>>) listView -> new ListViewCell());

        this.listView.setVisible(true);

        Platform.runLater(this::displayBids);
    }

    @FXML
    public void displayBids() {
        this.listView.itemsProperty().bind(this.listProperty);
        this.listProperty.set(FXCollections.observableArrayList(this.observableBids));
    }

    @FXML
    public void back() {
        this.application.getSceneController().activate("bidderMain");
    }
}
