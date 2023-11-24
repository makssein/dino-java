package com.dino.app;


import com.dino.app.controllers.ScreenController;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class DinoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ScreenController screenController = new ScreenController(stage);
        screenController.setScene("mScene");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}