package com.dino.app.views;

import com.dino.app.DinoApplication;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;

import java.io.IOException;

public class MainView extends BaseView {

    public MainView () throws IOException {
        fxmlLoader = new FXMLLoader(DinoApplication.class.getResource("main-view.fxml"));
        scene = new Scene(fxmlLoader.load(), primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight());
    }
}
