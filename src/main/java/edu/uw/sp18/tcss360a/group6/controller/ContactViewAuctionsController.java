package edu.uw.sp18.tcss360a.group6.controller;


import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.util.ListViewCell;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;


/**
 * GUI for contact person to view all auctions they have submitted.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class ContactViewAuctionsController {
    @FXML
    public ListView listView;
    @FXML
    private FXApplication application = FXApplication.getInstance();
    private  ObservableList names = FXCollections.observableArrayList();
    private ListProperty<String> listProperty = new SimpleListProperty<>();

    public ContactViewAuctionsController () {
        super ();

        Bootstrap bootstrap = new Bootstrap();
        List<Auction> auctions = bootstrap.getAuctionRepository().fetchAllInChronologicalOrder();

        listView = new ListView();

        List<String> name = new ArrayList<>();
        //add the items to the list
        for(Auction anAuction : auctions) {
            name.add(anAuction.toString());
        }

        names.setAll(name);
        listView.setItems(names);
        listView.setCellFactory((Callback<ListView<String>, ListCell<String>>) listView -> new ListViewCell());

        listView.setVisible(true);

        displayAuctions(); // TODO: this should display them initially ????

    }

    @FXML
    public void displayAuctions() {
        listView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(names));
    }

    @FXML
    public void back() {
        application.getSceneController().activate("contactMain");
    }
    @FXML
    public void logout() {
        application.getSceneController().activate("login");
    }


}
