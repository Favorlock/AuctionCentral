package edu.uw.sp18.tcss360a.group6;

import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.HashMap;
import java.util.Map;

public class SceneController {

    private Map<String, Parent> screenMap = new HashMap<>();
    private Scene primaryScene;

    public SceneController(Scene primaryScene) {
        this.primaryScene = primaryScene;
    }

    public void addScreen(String name, Parent parent) {
        this.screenMap.put(name, parent);
    }

    public void removeScreen(String name) {
        this.screenMap.remove(name);
    }

    public void activate(String name) {

        this.primaryScene.setRoot(this.screenMap.get(name));
    }

}
