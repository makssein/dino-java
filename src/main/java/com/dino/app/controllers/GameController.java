package com.dino.app.controllers;

import javafx.fxml.FXML;

public class GameController extends BaseController {

    @FXML
    protected void onAboutButtonClick() {
        screenController.setScene("aboutScene");
    }
    @FXML
    protected void onLeaveGameButtonClick() {
        System.exit(0);
    }
}