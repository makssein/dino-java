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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GameController extends BaseController {
    @FXML
    private HBox node;

    @FXML
    private Canvas canvas;

    private AnimationTimer animationTimer;

    private DinoObject dino;
    private ForrestObject forrest;
    private boolean isPlaying = true;
    private int score = 0;

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
        } else if(event.getCode() == KeyCode.ESCAPE) {
            screenController.setScene("mainScene");
        } else if(event.getCode() == KeyCode.R && !isPlaying) {
            restartGame();
        }
    }

    private void restartGame() {
        forrest.clearTrees();
        dino.restartDino();

        isPlaying = true;
        score = 0;
    }

    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.drawImage(dino.getDinoImage(), dino.getX(), dino.getY(), dino.getDinoSizeHeight(), dino.getDinoSizeWidth());

        forrest.getTrees().forEach((t) -> {
            gc.drawImage(t.getTreeImage(), t.getX(), t.getY(), t.getTreeSizeWidth(), t.getTreeSizeHeight());
        });

        Font font = Font.font("Pixel Cyr", 40);
        gc.setFont(font);
        gc.setFill(Color.WHITE);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(javafx.geometry.VPos.TOP);

        Text text = new Text("Счет: " + score);
        double textWidth = text.getLayoutBounds().getWidth();

        gc.fillText(text.getText(), (canvas.getWidth() - textWidth * 4) / 2, 0);
    }

    private void update() {
        clearCanvas();

        if(isPlaying) {
            score += 1;
            forrest.moveTrees();
            checkCollision();
        }

        draw();
    }

    private void checkCollision() {
        int dinoWidth = dino.getDinoSizeWidth();

        forrest.getTrees().forEach((t) -> {
            int treeWidth =  t.getTreeSizeWidth();
            int treeHeight =  t.getTreeSizeWidth();

            if(
                    (dino.getX() <= t.getX() && (dino.getX() + dinoWidth) >= t.getX() ||
                        dino.getX() > t.getX() && t.getX() + treeWidth >= dino.getX())
                    && dino.getY() >= t.getY() - treeHeight
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

    public void startGame(String difficulty) {
        if(dino == null)  {
            dino = new DinoObject((int) node.getScene().getHeight());
        }

        if(forrest == null) {
            forrest = new ForrestObject((int) node.getScene().getHeight(), (int) node.getScene().getWidth());
        }

        switch (difficulty) {
            case "easy" -> forrest.setTreeSpeed(15);
            case "medium" -> forrest.setTreeSpeed(20);
            case "hard" -> forrest.setTreeSpeed(25);
        }

        restartGame();
        animationTimer.start();
    }

    public void stopGame() {
        animationTimer.stop();
    }
}