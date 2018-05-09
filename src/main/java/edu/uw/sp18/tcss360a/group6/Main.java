package edu.uw.sp18.tcss360a.group6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static String FXML_SOURCE = "edu/uw/sp18/tcss360a/group6/Main.fxml";
    public static final String STAGE_TITLE = "Auction Central";

    @Override
    public void start(Stage stage) throws Exception {
        final Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(FXML_SOURCE));
        final Scene scene = new Scene(root);

        stage.setTitle(STAGE_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String... args) {
        Application.launch(Main.class);
    }

}
