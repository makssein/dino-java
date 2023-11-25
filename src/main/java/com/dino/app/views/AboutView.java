package com.dino.app.views;

import com.dino.app.DinoApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.io.IOException;

public class AboutView extends BaseView {

    public AboutView() throws IOException {
        fxmlLoader = new FXMLLoader(DinoApplication.class.getResource("about-view.fxml"));
        scene = new Scene(fxmlLoader.load(), primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight());
    }
}
