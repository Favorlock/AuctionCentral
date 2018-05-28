package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.controller.components.ListViewCell;
import edu.uw.sp18.tcss360a.group6.model.Bid;
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
 * GUI for Contact person users add an Item to their Auction(s).
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class BidderCancelBidController implements Initializable{

    @FXML
    private ListView listView;

    @FXML
    private Text cancelBidText;

    private FXApplication application = FXApplication.getInstance();

    private ObservableList observableBids = FXCollections.observableArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    private Bidder bidder;

    public BidderCancelBidController() {
        bidder = Session.getInstance().get("user", Bidder.class);
        List<Bid> bids = bidder.getPlacedBids();
        listView = new ListView();

        this.observableBids.setAll(bids);
        listView.setItems(this.observableBids);
        listView.setCellFactory((Callback<ListView<String>, ListCell<String>>) listView -> new ListViewCell());

        listView.setVisible(true);
    }

    @FXML
    public void displayBids() {
        listView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(observableBids));
        listView.getSelectionModel().select(0);

    }

    @FXML
    public void cancelBid() {
        Bid bid = (Bid) listView.getSelectionModel().getSelectedItem();
        didCancelBidText(bidder.cancelBid(bid));
    }
    private void updateItems() {
        final int selectedId = listView.getSelectionModel().getSelectedIndex();
        if (selectedId != -1) {
            Object itemToRemove = listView.getSelectionModel().getSelectedItem();
            final int newSelectedId = (selectedId == listView.getItems().size() - 1) ? selectedId - 1 : selectedId;
            listView.getItems().remove(selectedId);
            listView.getSelectionModel().select(newSelectedId);
        }
    }

    private void didCancelBidText(boolean didCancel) {
        if (didCancel) {
            cancelBidText.setText("Canceled bid");
            updateItems();
        } else {
            cancelBidText.setText("Did not Canceled bid");
        }
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
