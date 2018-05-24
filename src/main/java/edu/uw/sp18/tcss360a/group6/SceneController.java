package edu.uw.sp18.tcss360a.group6;

import edu.uw.sp18.tcss360a.group6.controller.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneController {

    private Map<String, String> scenePathMap = new HashMap<>();
    private Scene primaryScene;

    public SceneController(Scene primaryScene) {
        this.primaryScene = primaryScene;
    }

    public void addScreen(String name, String path) {
        this.scenePathMap.put(name, path);
    }

    public void removeScreen(String name) {
        this.scenePathMap.remove(name);
    }

    public void activate(String name) {
        String path = this.scenePathMap.get(name);
        if (path != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
                Parent parent = loader.load();
                Object controller = loader.getController();
                if (controller instanceof Initializable) {
                    ((Initializable) controller).initialize();
                }
                this.primaryScene.setRoot(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
