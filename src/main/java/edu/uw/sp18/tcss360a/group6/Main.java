package edu.uw.sp18.tcss360a.group6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static String LOGIN_FXML = "/scenes/Login.fxml";
    public static final String STAGE_TITLE = "Auction Central";

    private SceneController sceneController;

    @Override
    public void start(Stage stage) throws Exception {
        final Parent login = FXMLLoader.load(getClass().getResource(LOGIN_FXML));
        final Scene scene = new Scene(login);

        this.sceneController = new SceneController(scene);
        this.sceneController.addScreen("login", login);

        stage.setTitle(STAGE_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public SceneController getSceneController() {
        return this.sceneController;
    }

    public static void main(String... args) {
        Application.launch(Main.class);
    }

}
