package com.dino.app.controllers;

import javafx.fxml.FXML;

public class MainController {

    private ScreenController screenController;
    @FXML
    protected void onHelloButtonClick() {
        screenController.setScene("sScene");
    }

    @FXML
    protected void onLeaveGameButtonClick() {
        System.exit(0);
    }

    public void setScreenController(ScreenController sc) {
        screenController = sc;
    }
}