package com.dino.app.controllers;

import javafx.fxml.FXML;

public class AboutController extends BaseController {
    @FXML
    protected void onGoBackButtonClick() {
        screenController.setScene("mainScene");
    }
}