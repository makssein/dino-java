package com.dino.app.controllers;

import javafx.fxml.FXML;

public class DifficultyController extends BaseController {

    @FXML
    protected void onEasyStartButtonClick() {
        screenController.setScene("gameScene", "easy");
    }
    @FXML
    protected void onMediumStartButtonClick() {
        screenController.setScene("gameScene", "medium");
    }

    @FXML
    protected void onHardStartButtonClick() {
        screenController.setScene("gameScene", "hard");
    }

    @FXML
    protected void onGoBackButtonClick() {
        screenController.setScene("mainScene");
    }
}