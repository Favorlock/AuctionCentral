package edu.uw.sp18.tcss360a.group6.controller;


import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.ContactPerson;
import edu.uw.sp18.tcss360a.group6.controller.components.ListViewCell;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.util.List;


/**
 * GUI for contact person to view all auctions they have submitted.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class ContactViewAuctionsController implements Initializable{

    @FXML
    public ListView listView;

    @FXML
    private FXApplication application = FXApplication.getInstance();

    private  ObservableList auctions = FXCollections.observableArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    public ContactViewAuctionsController () {
        super ();

        ContactPerson contact = Session.getInstance().get("user", ContactPerson.class);
        Bootstrap bootstrap = new Bootstrap();
        //TODO: dispaly only auctions associated with contact person
        List<Auction> auction = contact.getOrganization().getAuctions();

        listView = new ListView();

        this.auctions.setAll(auction);
        listView.setItems(this.auctions);
        listView.setCellFactory((Callback<ListView<String>, ListCell<String>>) listView -> new ListViewCell());

        listView.setVisible(true);

        displayAuctions(); // TODO: this should display them initially ????
    }

    @FXML
    public void displayAuctions() {
        listView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(auctions));
    }

    @FXML
    public void back() {
        application.getSceneController().activate("contactMain");
    }

    @Override
    public void initialize() {
        displayAuctions();
    }
}
