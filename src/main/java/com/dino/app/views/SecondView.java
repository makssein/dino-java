package com.dino.app.views;

import com.dino.app.DinoApplication;
import com.dino.app.controllers.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class SecondView {
    Scene scene;
    private FXMLLoader fxmlLoader;
    public SecondView() throws IOException {
        fxmlLoader = new FXMLLoader(DinoApplication.class.getResource("second-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 320, 240);
    }

    public Scene getScene() {
        return scene;
    }

    public MainController getController() {
        return fxmlLoader.getController();
    }
}
