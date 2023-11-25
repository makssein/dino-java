package com.dino.app;

import com.dino.app.controllers.BaseController;
import com.dino.app.controllers.GameController;
import com.dino.app.views.DifficultyView;
import com.dino.app.views.GameView;
import com.dino.app.views.MainView;
import com.dino.app.views.AboutView;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class ScreenChanger {
    private final HashMap<String, Scene> scenes = new HashMap<>(); ;
    private final Stage main;

    private GameController gameController;

    public ScreenChanger(Stage main) throws IOException {
        this.main = main;

        MainView mView = new MainView();
        AboutView sView = new AboutView();
        DifficultyView dView = new DifficultyView();
        GameView gView = new GameView();

        this.addScene("mainScene", mView.getScene());
        this.addScene("aboutScene", sView.getScene());
        this.addScene("difficultyScene", dView.getScene());
        this.addScene("gameScene", gView.getScene());

        BaseController mainController = mView.getController();
        BaseController secondController = sView.getController();
        BaseController difficultyController = dView.getController();
        this.gameController = (GameController) gView.getController();

        mainController.setScreenController(this);
        secondController.setScreenController(this);
        difficultyController.setScreenController(this);
    }

    private void addScene(String name, Scene scene){
        scenes.put(name, scene);
    }

    public void setScene(String name) {
        Platform.runLater(() ->main.setScene(scenes.get(name)));

        if(name.equals("gameScene")) {
            gameController.startGame();
        }
    }
}

