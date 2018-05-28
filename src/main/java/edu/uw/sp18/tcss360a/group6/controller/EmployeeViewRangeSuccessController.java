package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.model.Auction;
import edu.uw.sp18.tcss360a.group6.controller.components.ListViewCell;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.List;

/**
 * GUI for employees to view all auctions in chronological order.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class EmployeeViewRangeSuccessController implements Initializable {

    @FXML
    public ListView listView;

    @FXML
    private FXApplication application = FXApplication.getInstance();

    private static LocalDate startDate;
    private static LocalDate endDate;

    private ObservableList auctions = FXCollections.observableArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();
    public EmployeeViewRangeSuccessController () {
        Bootstrap bootstrap = new Bootstrap();
        List<Auction> auction = bootstrap.getAuctionRepository()
                .fetchAuctionsInPeriod(startDate, endDate);
//        List<Auction> auction = bootstrap.getAuctionRepository().fetchAllInChronologicalOrder();

        listView = new ListView();


        this.auctions.setAll(auction);
        listView.setItems(this.auctions);
        listView.setCellFactory((Callback<ListView<String>, ListCell<String>>)
                listView -> new ListViewCell());

        listView.setVisible(true);

        displayAuctions();
    }

    public static void setDates(LocalDate start, LocalDate end) {
        startDate = start;
        endDate = end;
    }

    @FXML
    private void displayAuctions() {
        listView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(auctions));
        listView.getSelectionModel().select(0);
    }

    @FXML
    public void back() {
        application.getSceneController().activate("employeeBetweenDates");
    }

    @Override
    public void initialize() {
        displayAuctions();
    }
}
