package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.model.*;
import edu.uw.sp18.tcss360a.group6.controller.components.ListViewCell;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * GUI for Contact person users add an Item to their Auction(s).
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class ContactAddItemController {
    @FXML
    public ListView listView;
    @FXML
    private FXApplication application = FXApplication.getInstance();
    private ObservableList auctions = FXCollections.observableArrayList();
    private ListProperty<String> listProperty = new SimpleListProperty<>();
    public ContactAddItemController () {
        super ();

        Bootstrap bootstrap = new Bootstrap();
        //TODO: display only auctions associated with contact person
        ContactPerson user = Session.getInstance().get("user", ContactPerson.class);
        Auction auction = user.getOrganization().getCurrentAuction();

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
    public void openSelection() {
        application.getSceneController().activate("addItemForm");
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
