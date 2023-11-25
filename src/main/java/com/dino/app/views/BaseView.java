package com.dino.app.views;

import com.dino.app.controllers.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;

public class BaseView {
    protected Scene scene;
    protected FXMLLoader fxmlLoader;
    protected Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

    public Scene getScene() {
        return scene;
    }

    public BaseController getController() {
        return fxmlLoader.getController();
    }
}
