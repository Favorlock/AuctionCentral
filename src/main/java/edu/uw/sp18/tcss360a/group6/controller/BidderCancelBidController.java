package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.model.Bid;
import edu.uw.sp18.tcss360a.group6.model.Bidder;
import edu.uw.sp18.tcss360a.group6.controller.components.ListViewCell;
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
 * GUI for Contact person users add an Item to their Auction(s).
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class BidderCancelBidController implements Initializable{

    @FXML
    private ListView listView;

    private FXApplication application = FXApplication.getInstance();

    private ObservableList observableBids = FXCollections.observableArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    private Bidder bidder;

    public BidderCancelBidController() {

        Bidder bidder = Session.getInstance().get("user", Bidder.class);
        Bootstrap bootstrap = new Bootstrap(); //TODO: delete bootstrap
        //TODO: display only bids associated with bidder
//        List<Bid> bids = bootstrap.getBidRepository().fetchAll();
        List<Bid> bids = bidder.getPlacedBids();

        listView = new ListView();


        this.observableBids.setAll(bids);
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
    public void cancelBid() {
        Bid bid = (Bid) listView.getSelectionModel().getSelectedItem();
        bidder.cancelBid(bid);
    }

    @FXML
    public void back() {
        application.getSceneController().activate("bidderMain");
    }

    @Override
    public void initialize() {
        displayBids();
    }
}
