package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.Session;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.model.Employee;
import edu.uw.sp18.tcss360a.group6.controller.components.ListViewCell;
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
 * GUI for Contact person users add an Item to their Auction(s).
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class EmployeeCancelAnAuctionController implements Initializable{

    @FXML
    public ListView listView;

    @FXML
    private FXApplication application = FXApplication.getInstance();

    private ObservableList auctions = FXCollections.observableArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    public EmployeeCancelAnAuctionController () {

        Bootstrap bootstrap = new Bootstrap();
        List<Auction> auctions = bootstrap.getAuctionRepository().fetchFutureAuctions();
        Employee employee = Session.getInstance().get("user", Employee.class);
        List<Auction> cancelAuctions = new ArrayList<>();
        for (int i = 0; i < auctions.size(); i++) {
            if (employee.canCancelAnAuction(auctions.get(i))) {
                cancelAuctions.add(auctions.get(i));
            }
        }
        listView = new ListView();

        this.auctions.setAll(cancelAuctions);
        listView.setItems(this.auctions);
        listView.setCellFactory((Callback<ListView<String>, ListCell<String>>)
                listView -> new ListViewCell());

        listView.setVisible(true);
    }

    @FXML
    public void displayAuctions() {
        listView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(auctions));
        listView.getSelectionModel().select(0);

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

    @FXML
    public void cancelAuction() {

        Employee employee = Session.getInstance().get("user", Employee.class);
        Auction canceledAuction = (Auction)listView.getSelectionModel().getSelectedItem();

        if (employee.cancelAnAuction(canceledAuction)) {
            updateItems();
        }

    }
    @FXML
    public void back() {
        application.getSceneController().activate("employeeMain");
    }

    @Override
    public void initialize() {
        displayAuctions();
    }
}
