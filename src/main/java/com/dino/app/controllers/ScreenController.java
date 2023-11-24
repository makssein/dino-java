package com.dino.app.controllers;

import com.dino.app.views.MainView;
import com.dino.app.views.SecondView;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class ScreenController {
    private HashMap<String, Scene> scenes = new HashMap<>(); ;
    private Stage main;

    public ScreenController(Stage main) throws IOException {
        this.main = main;

        MainView mView = new MainView();
        Scene mScene = mView.getScene();
        MainController mController = mView.getController();

        SecondView sView = new SecondView();
        Scene sScene = sView.getScene();

        this.addScene("mScene", mScene);
        this.addScene("sScene", sScene);

        mController.setScreenController(this);
    }

    private void addScene(String name, Scene scene){
        scenes.put(name, scene);
    }

    public void setScene(String name) {
        main.setScene(scenes.get(name));
    }
}