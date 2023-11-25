package com.dino.app.views;

import com.dino.app.DinoApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class GameView extends BaseView {
    public GameView () throws IOException {
        fxmlLoader = new FXMLLoader(DinoApplication.class.getResource("game-view.fxml"));
        scene = new Scene(fxmlLoader.load(), primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight());
    }
}
