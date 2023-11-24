package com.dino.app.views;

import com.dino.app.DinoApplication;
import com.dino.app.controllers.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class MainView {
    Scene scene;
    private FXMLLoader fxmlLoader;
    public MainView () throws IOException {
        fxmlLoader = new FXMLLoader(DinoApplication.class.getResource("main-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 320, 240);
    }

    public Scene getScene() {
        return scene;
    }

    public MainController getController() {
        return fxmlLoader.getController();
    }
}
