package com.dino.app;

import com.dino.app.controllers.BaseController;
import com.dino.app.views.DifficultyView;
import com.dino.app.views.MainView;
import com.dino.app.views.AboutView;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class ScreenChanger {
    private final HashMap<String, Scene> scenes = new HashMap<>(); ;
    private final Stage main;

    public ScreenChanger(Stage main) throws IOException {
        this.main = main;

        MainView mView = new MainView();
        AboutView sView = new AboutView();
        DifficultyView dView = new DifficultyView();

        this.addScene("mainScene", mView.getScene());
        this.addScene("aboutScene", sView.getScene());
        this.addScene("difficultyScene", dView.getScene());

        BaseController mainController = mView.getController();
        BaseController secondController = sView.getController();
        mainController.setScreenController(this);
        secondController.setScreenController(this);
    }

    private void addScene(String name, Scene scene){
        scenes.put(name, scene);
    }

    public void setScene(String name) {
        main.setScene(scenes.get(name));
    }
}