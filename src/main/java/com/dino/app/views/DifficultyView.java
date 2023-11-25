package com.dino.app.views;

import com.dino.app.DinoApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class DifficultyView extends BaseView {
    public DifficultyView() throws IOException {
        fxmlLoader = new FXMLLoader(DinoApplication.class.getResource("difficulty-view.fxml"));
        scene = new Scene(fxmlLoader.load(), primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight());
    }
}
