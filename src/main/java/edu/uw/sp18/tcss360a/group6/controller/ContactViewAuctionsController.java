package edu.uw.sp18.tcss360a.group6.controller;


import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.util.ListViewCell;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
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
    @FXML private ListView listView;
    private FXApplication application = FXApplication.getInstance();
    private  ObservableList names = FXCollections.observableArrayList();
    public ContactViewAuctionsController () {
        super ();

         listView = new ListView();

        List<String> name = new ArrayList<>();
        name.add("Adam");
        name.add("Alfred");
        name.add("Albert");
        names.setAll(name);
        listView.setItems(names);
        listView.setCellFactory((Callback<ListView<String>, ListCell<String>>) listView -> new ListViewCell());
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
