package com.dino.app.controllers;

import com.dino.app.ScreenChanger;
import javafx.stage.Stage;

public class BaseController {
    protected ScreenChanger screenController;

    public void setScreenController(ScreenChanger sc) {
        screenController = sc;
    }
}
