package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.controller.components.ListViewCell;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.Item;
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
 * GUI to display all items in an auction.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/26/2018
 */
public class EmployeeViewAuctionItemsController implements Initializable {

    public static Auction selectedAuction;
    @FXML
    public ListView listView;
    @FXML
    private FXApplication application = FXApplication.getInstance();

    private ObservableList items = FXCollections.observableArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    public EmployeeViewAuctionItemsController() {
        List<Item> auctionItems = selectedAuction.getInventory();

        listView = new ListView();
        this.items.setAll(auctionItems);
        listView.setItems(this.items);
        listView.setCellFactory((Callback<ListView<String>, ListCell<String>>)
                listView -> new ListViewCell());

        listView.setVisible(true);
    }

    @FXML
    public void displayItems() {
        listView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(items));
        listView.getSelectionModel().select(0);

    }
    /**
     * Set the static auction variable for this class.
     * @param theAuction Auction to set for this class
     */
    public static void setAuction(Auction theAuction) {
        selectedAuction = theAuction;
    }

    @FXML
    public void back() {
        application.getSceneController().activate("employeeMain");
    }

    @FXML
    public void selectAnotherAuction() {
        application.getSceneController().activate("employeeViewAllAuctions");
    }

    @Override
    public void initialize() {
        displayItems();
    }

}
