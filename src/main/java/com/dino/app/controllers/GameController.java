package com.dino.app.controllers;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameController extends BaseController {
    @FXML
    private Canvas canvas;
    private double playerX = 0;
    private double playerY = 0;

    private AnimationTimer animationTimer;

    @FXML
    private void initialize() {
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };

    }

    public void drawPlayer() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(playerX, playerY, 50, 50);
    }

    public void update() {
        clearCanvas();
        playerX += 1;
        drawPlayer();
    }

    private void clearCanvas() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void startGame() {
        animationTimer.start();
    }
}