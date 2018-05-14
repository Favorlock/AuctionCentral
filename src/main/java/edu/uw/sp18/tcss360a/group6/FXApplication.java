package edu.uw.sp18.tcss360a.group6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXApplication extends Application {

    public static String LOGIN_FXML = "/scenes/Login.fxml";
    public static String BIDDER_MAIN_FXML = "/scenes/BidderMain.fxml";
    public static final String STAGE_TITLE = "Auction Central";

    private static FXApplication instance;

    private SceneController sceneController;

    public FXApplication() {
        instance = this;
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Parent login = FXMLLoader.load(getClass().getResource(LOGIN_FXML));
        final Parent bidderMain = FXMLLoader.load(getClass().getResource(BIDDER_MAIN_FXML));
        final Scene scene = new Scene(login);

        this.sceneController = new SceneController(scene);
        this.sceneController.addScreen("login", login);
        this.sceneController.addScreen("bidderMain", bidderMain);

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
