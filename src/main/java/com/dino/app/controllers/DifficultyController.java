package com.dino.app.controllers;

import javafx.fxml.FXML;

public class DifficultyController extends BaseController {

    @FXML
    protected void onEasyStartButtonClick() {
        screenController.setScene("gameScene");
    }
    @FXML
    protected void onMediumStartButtonClick() {
        screenController.setScene("gameScene");
    }

    @FXML
    protected void onHardStartButtonClick() {
        screenController.setScene("gameScene");
    }
}