package edu.uw.sp18.tcss360a.group6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private static String BIDDER_VIEW_BIDS_FXML = "/scenes/ViewBids.fxml";
    private static String BIDDER_PLACE_BID_FXML = "/scenes/PlaceBid.fxml";
    private static String BIDDER_CANCEL_BID_FXML = "/scenes/BidderCancelBid.fxml";
    private static String EMPLOYEE_MAIN_FXML = "/scenes/EmployeeMain.fxml";
    private static String EMPLOYEE_VIEW_ALL_FXML = "/scenes/EmployeeViewAllAuctions.fxml";
    private static String EMPLOYEE_VIEW_BETWEEN_DATES_FXML = "/scenes/EmployeeViewAuctionsBetweenDates.fxml";
    private static String EMPLOYEE_CANCEL_FXML = "/scenes/EmployeeCancelAnAuction.fxml";
    private static String EMPLOYEE_CHANGE_MAX_FXML = "/scenes/EmployeeChangeMaxAuctions.fxml";
    private static String AUCTION_ADD_SUCCESS_FXML = "/scenes/AuctionAddSuccess.fxml";
    private static String EMPLOYEE_VIEW_AUCTIONS_ERROR_FXML = "/scenes/EmployeeViewAuctionsError.fxml";

    private static final String STAGE_TITLE = "Auction Central";

    private static FXApplication instance;

    private SceneController sceneController;

    public FXApplication() {
        instance = this;
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Parent login = FXMLLoader.load(getClass()
                .getResource(LOGIN_FXML));
        //contact persons
        final Parent contactMain = FXMLLoader.load(getClass()
                .getResource(CONTACT_MAIN_FXML));
        final Parent contactViewAuctions = FXMLLoader.load(getClass()
                .getResource(CONTACT_VIEW_AUCTIONS_FXML));
        final Parent contactAddItem = FXMLLoader.load(getClass()
                .getResource(CONTACT_ADD_ITEM_FXML));
        final Parent contactSubmitAuction = FXMLLoader.load(getClass()
                .getResource(CONTACT_SUBMIT_AUCTION_FXML));
        //bidders
        final Parent bidderMain = FXMLLoader.load(getClass()
                .getResource(BIDDER_MAIN_FXML));
        final Parent employeeViewAuctionsError = FXMLLoader.load(getClass()
                .getResource(EMPLOYEE_VIEW_AUCTIONS_ERROR_FXML));
        final Parent viewBids = FXMLLoader.load(getClass()
                .getResource(BIDDER_VIEW_BIDS_FXML));
        final Parent placeBid = FXMLLoader.load(getClass()
                .getResource(BIDDER_PLACE_BID_FXML));
        final Parent bidderCancelBid = FXMLLoader.load(getClass()
                .getResource(BIDDER_CANCEL_BID_FXML));
        //employees
        final Parent employeeMain = FXMLLoader.load(getClass()
                .getResource(EMPLOYEE_MAIN_FXML));
        final Parent employeeViewAll = FXMLLoader.load(getClass()
                .getResource(EMPLOYEE_VIEW_ALL_FXML));
        final Parent employeeBetweenDates = FXMLLoader.load(getClass()
                .getResource(EMPLOYEE_VIEW_BETWEEN_DATES_FXML));
        final Parent employeeCancel = FXMLLoader.load(getClass()
                .getResource(EMPLOYEE_CANCEL_FXML));
        final Parent employeeChangeMax = FXMLLoader.load(getClass()
                .getResource(EMPLOYEE_CHANGE_MAX_FXML));
        final Parent auctionAddSuccess = FXMLLoader.load(getClass()
                .getResource(AUCTION_ADD_SUCCESS_FXML));


        final Scene scene = new Scene(login);
        this.sceneController = new SceneController(scene);
        this.sceneController.addScreen("login", login);
        //contact persons
        this.sceneController.addScreen("contactMain", contactMain);
        this.sceneController
                .addScreen("contactViewAuctions", contactViewAuctions);
        this.sceneController.addScreen("contactAddItem", contactAddItem);
        this.sceneController.addScreen("contactSubmitAuction", contactSubmitAuction);
        //bidders
        this.sceneController.addScreen("bidderMain", bidderMain);
        this.sceneController.addScreen("viewBids", viewBids);
        this.sceneController.addScreen("placeBid", placeBid);
        this.sceneController.addScreen("cancelBid", bidderCancelBid);
        //employees
        this.sceneController.addScreen("employeeMain", employeeMain);
        this.sceneController
                .addScreen("employeeViewAllAuctions", employeeViewAll);
        this.sceneController
                .addScreen("employeeBetweenDates", employeeBetweenDates);
        this.sceneController.addScreen("employeeCancel", employeeCancel);
        this.sceneController
                .addScreen("employeeChangeMax", employeeChangeMax);
        this.sceneController
                .addScreen("auctionAddSuccess", auctionAddSuccess);
        this.sceneController
                .addScreen("employeeViewAuctionsError", employeeViewAuctionsError);


        stage.setTitle(STAGE_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public SceneController getSceneController() {
        return this.sceneController;
    }

    public static void main(String... args) {
        Bootstrap bootstrap = new Bootstrap();
        Application.launch(FXApplication.class);
    }

    public static FXApplication getInstance() {
        return instance;
    }
}
