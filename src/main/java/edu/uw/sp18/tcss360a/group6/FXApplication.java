package edu.uw.sp18.tcss360a.group6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * Driver to run the GUI.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class FXApplication extends Application {

    private static String LOGIN_FXML = "/scenes/Login.fxml";
    private static String CONTACT_MAIN_FXML = "/scenes/ContactMain.fxml";
    private static String CONTACT_VIEW_AUCTIONS_FXML = "/scenes/ContactViewAuctions.fxml";
    private static String CONTACT_SUBMIT_AUCTION_FXML = "/scenes/ContactSubmitAuctionRequest.fxml";
    private static String CONTACT_ADD_ITEM_FXML = "/scenes/ContactAddItem.fxml";
    private static String BIDDER_MAIN_FXML = "/scenes/BidderMain.fxml";
    private static String BIDDER_VIEW_BIDS_FXML = "/scenes/BidderViewBids.fxml";
    private static String BIDDER_PLACE_BID_FXML = "/scenes/BidderPlaceBid.fxml";
    private static String BIDDER_CANCEL_BID_FXML = "/scenes/BidderCancelBid.fxml";
    private static String BIDDER_PLACE_BID_VIEW_AUCTION_FXML = "/scenes/BidderPlaceBidViewAuction.fxml";
    private static String BIDDER_VIEW_ALL_AUCTIONS_FXML = "/scenes/BidderViewAllAuctions.fxml";
    private static String BIDDER_VIEW_ALL_AUCTION_ITEMS_FXML = "/scenes/BidderViewAllAuctionItems.fxml";
    private static String EMPLOYEE_MAIN_FXML = "/scenes/EmployeeMain.fxml";
    private static String EMPLOYEE_VIEW_ALL_FXML = "/scenes/EmployeeViewAllAuctions.fxml";
    private static String EMPLOYEE_VIEW_BETWEEN_DATES_FXML = "/scenes/EmployeeViewAuctionsBetweenDates.fxml";
    private static String EMPLOYEE_CANCEL_FXML = "/scenes/EmployeeCancelAnAuction.fxml";
    private static String EMPLOYEE_CHANGE_MAX_FXML = "/scenes/EmployeeChangeMaxAuctions.fxml";
    private static String AUCTION_ADD_SUCCESS_FXML = "/scenes/AuctionAddSuccess.fxml";
    private static String EMPLOYEE_VIEW_AUCTIONS_ERROR_FXML = "/scenes/EmployeeViewAuctionsError.fxml";
    private static String EMPLOYEE_VIEW_RANGE_SUCCESS_FXML = "/scenes/EmployeeViewRangeSuccess.fxml";
    private static String EMPLOYEE_VIEW_AUCTION_ITEMS_FXML = "/scenes/EmployeeViewAuctionItems.fxml";
    private static String AUCTION_ADD_FAIL_FXML = "/scenes/AuctionAddFail.fxml";
    private static String ADD_ITEM_FORM_FXML = "/scenes/ContactAddItemForm.fxml";
    private static String CONTACT_VIEW_ITEMS_FXML = "/scenes/ContactViewItems.fxml";
    private static String AUCTION_ADD_INPUT_FAIL_FXML = "/scenes/AuctionAddInputFail.fxml";

    private static final String STAGE_TITLE = "Auction Central";

    private static FXApplication instance;

    private SceneController sceneController;

    public FXApplication() {
        instance = this;
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Scene scene = new Scene(new AnchorPane());
        this.sceneController = new SceneController(scene);
        this.sceneController.addScreen("login", LOGIN_FXML);
        //contact persons
        this.sceneController.addScreen("contactMain", CONTACT_MAIN_FXML);
        this.sceneController
                .addScreen("contactViewAuctions", CONTACT_VIEW_AUCTIONS_FXML);
        this.sceneController.addScreen("contactAddItem", CONTACT_ADD_ITEM_FXML);
        this.sceneController.addScreen("contactSubmitAuction", CONTACT_SUBMIT_AUCTION_FXML);
        this.sceneController
                .addScreen("addItemForm", ADD_ITEM_FORM_FXML);
        this.sceneController
                .addScreen("contactViewItems", CONTACT_VIEW_ITEMS_FXML);
        this.sceneController
                .addScreen("auctionAddSuccess", AUCTION_ADD_SUCCESS_FXML);
        this.sceneController
                .addScreen("auctionAddFail", AUCTION_ADD_FAIL_FXML);
        //bidders
        this.sceneController.addScreen("bidderMain", BIDDER_MAIN_FXML);
        this.sceneController.addScreen("viewBids", BIDDER_VIEW_BIDS_FXML);
        this.sceneController.addScreen("placeBid", BIDDER_PLACE_BID_FXML);
        this.sceneController.addScreen("cancelBid", BIDDER_CANCEL_BID_FXML);
        this.sceneController
                .addScreen("placeBidViewAuction", BIDDER_PLACE_BID_VIEW_AUCTION_FXML);
        this.sceneController
                .addScreen("auctionAddInputFail", AUCTION_ADD_INPUT_FAIL_FXML);
        this.sceneController.addScreen("bidderViewAllAuctions", BIDDER_VIEW_ALL_AUCTIONS_FXML);
        this.sceneController.addScreen("bidderViewAllAuctionItems", BIDDER_VIEW_ALL_AUCTION_ITEMS_FXML);
        //employees
        this.sceneController.addScreen("employeeMain", EMPLOYEE_MAIN_FXML);
        this.sceneController
                .addScreen("employeeViewAllAuctions", EMPLOYEE_VIEW_ALL_FXML);
        this.sceneController
                .addScreen("employeeBetweenDates", EMPLOYEE_VIEW_BETWEEN_DATES_FXML);
        this.sceneController.addScreen("employeeCancel", EMPLOYEE_CANCEL_FXML);
        this.sceneController
                .addScreen("employeeChangeMax", EMPLOYEE_CHANGE_MAX_FXML);
        this.sceneController
                .addScreen("auctionAddSuccess", AUCTION_ADD_SUCCESS_FXML);
        this.sceneController
                .addScreen("employeeViewAuctionsError", EMPLOYEE_VIEW_AUCTIONS_ERROR_FXML);
        this.sceneController
                .addScreen("employeeViewRangeSuccess", EMPLOYEE_VIEW_RANGE_SUCCESS_FXML);
        this.sceneController
                .addScreen("employeeViewItems", EMPLOYEE_VIEW_AUCTION_ITEMS_FXML);
        this.sceneController.activate("login");

        stage.setTitle(STAGE_TITLE);
        stage.setScene(scene);
        stage.setMinHeight(500);
        stage.setMinWidth(725);
        stage.show();
    }

    public SceneController getSceneController() {
        return this.sceneController;
    }

    /**
     * Start the GUI .
     * @param args for command line input
     */
    public static void main(String... args) {
        Bootstrap bootstrap = new Bootstrap();
        Application.launch(FXApplication.class);
    }

    public static FXApplication getInstance() {
        return instance;
    }
}
