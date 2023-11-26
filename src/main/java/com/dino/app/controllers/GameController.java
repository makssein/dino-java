package com.dino.app.controllers;

import com.dino.app.objects.DinoObject;
import com.dino.app.objects.ForrestObject;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

public class GameController extends BaseController {
    @FXML
    private HBox node;

    @FXML
    private Canvas canvas;

    private AnimationTimer animationTimer;

    private DinoObject dino;
    private ForrestObject forrest;
    private boolean isPlaying = true;

    @FXML
    private void initialize() {
        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                keyPressed(event);
            }
        });

        canvas.setFocusTraversable(true);

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
    }

    private void keyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.SPACE && !dino.getIsJumping() && isPlaying) {
            dino.setIsJumping(true);
            dino.jump();
        }
    }

    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.drawImage(dino.getDinoImage(), dino.getX(), dino.getY(), dino.getDinoSizeHeight(), dino.getDinoSizeWidth());

        forrest.getTrees().forEach((t) -> {
            gc.drawImage(t.getTreeImage(), t.getX(), t.getY(), t.getTreeSizeWidth(), t.getTreeSizeHeight());
        });
    }

    private void update() {
        clearCanvas();

        if(isPlaying) {
//            score += 1;
//            displayScore();
            forrest.moveTrees();
            checkCollision();
        }

        draw();
    }

    private void checkCollision() {
        int dinoWidth = (int) dino.getDinoImage().getWidth();

        forrest.getTrees().forEach((t) -> {
            int treeWidth =  t.getTreeSizeWidth();
            int treeHeight =  t.getTreeSizeWidth();

            if(
                    (double) treeWidth  / 2 + (double) dinoWidth / 2 >=
                            Math.abs(t.getX() - ((double) treeWidth / 2) + 45 - dino.getX() - 10) &&
                            treeHeight >= dino.getY()
            ) {
                isPlaying = false;
                dino.setDinoGameOver();
            }
        });
    }

    private void clearCanvas() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void startGame() {
        if(dino == null)  {
            dino = new DinoObject((int) node.getScene().getHeight());
        }

        if(forrest == null) {
            forrest = new ForrestObject((int) node.getScene().getHeight(), (int) node.getScene().getWidth());
        }

        animationTimer.start();
    }
}