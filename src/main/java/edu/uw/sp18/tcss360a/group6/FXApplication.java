package edu.uw.sp18.tcss360a.group6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXApplication extends Application {

    private static String LOGIN_FXML = "/scenes/Login.fxml";
    private static String BIDDER_MAIN_FXML = "/scenes/BidderMain.fxml";
    private static String CONTACT_MAIN_FXML = "/scenes/ContactMain.fxml";
    private static String EMPLOYEE_MAIN_FXML = "/scenes/EmployeeMain.fxml";
    private static String BIDDER_VIEW_BIDS_FXML = "/scenes/ViewBids.fxml";
    private static String BIDDER_PLACE_BID_FXML = "/scenes/PlaceBid.fxml";
    private static String BIDDER_CANCEL_BID_FXML = "/scenes/CancelBid.fxml";
    private static String CONTACT_VIEW_AUCTIONS_FXML = "/scenes/ContactViewAuctions.fxml";

    private static final String STAGE_TITLE = "Auction Central";

    private static FXApplication instance;

    private SceneController sceneController;

    public FXApplication() {
        instance = this;
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Parent login = FXMLLoader.load(getClass().getResource(LOGIN_FXML));
        final Parent bidderMain = FXMLLoader.load(getClass().getResource(BIDDER_MAIN_FXML));
        final Parent contactMain = FXMLLoader.load(getClass().getResource(CONTACT_MAIN_FXML));
        final Parent employeeMain = FXMLLoader.load(getClass().getResource(EMPLOYEE_MAIN_FXML));
        final Parent viewBids = FXMLLoader.load(getClass().getResource(BIDDER_VIEW_BIDS_FXML));
        final Parent placeBid = FXMLLoader.load(getClass().getResource(BIDDER_PLACE_BID_FXML));
        final Parent cancelBid = FXMLLoader.load(getClass().getResource(BIDDER_CANCEL_BID_FXML));
        final Parent contactViewAuctions = FXMLLoader.load(getClass().getResource(CONTACT_VIEW_AUCTIONS_FXML));

        final Scene scene = new Scene(login);

        this.sceneController = new SceneController(scene);
        this.sceneController.addScreen("login", login);
        this.sceneController.addScreen("bidderMain", bidderMain);
        this.sceneController.addScreen("contactMain", contactMain);
        this.sceneController.addScreen("employeeMain", employeeMain);
        this.sceneController.addScreen("viewBids", viewBids);
        this.sceneController.addScreen("placeBid", placeBid);
        this.sceneController.addScreen("cancelBid", cancelBid);
        this.sceneController.addScreen("contactViewAuctions", contactViewAuctions);

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
