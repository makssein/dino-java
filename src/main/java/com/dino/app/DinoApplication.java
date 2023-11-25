package com.dino.app;


import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class DinoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ScreenChanger screenController = new ScreenChanger(stage);
        screenController.setScene("mainScene");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}