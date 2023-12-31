package com.dino.app.controllers;

import javafx.fxml.FXML;

public class MainController extends BaseController {

    @FXML
    protected void onStartGameButtonClick() {
        screenController.setScene("difficultyScene");
    }
    @FXML
    protected void onAboutButtonClick() {
        screenController.setScene("aboutScene");
    }
    @FXML
    protected void onLeaveGameButtonClick() {
        System.exit(0);
    }
}