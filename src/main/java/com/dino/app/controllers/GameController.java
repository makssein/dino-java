package com.dino.app.controllers;

import com.dino.app.objects.DinoObject;
import com.dino.app.objects.ForrestObject;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

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

    private AudioClip gameOverSound;
    private MediaPlayer gameSound;

    @FXML
    private void initialize() {

        canvas.setOnKeyPressed(this::keyPressed);

        canvas.setOnKeyReleased(this::keyReleased);

        gameOverSound = new AudioClip(getClass().getResource("/sounds/game_over.wav").toString());
        gameOverSound.setVolume(0.2);

        Media media = new Media(getClass().getResource("/sounds/game_music.wav").toString());
        gameSound = new MediaPlayer(media);
        gameSound.setVolume(0.2);
        gameSound.seek(Duration.ZERO);
        gameSound.setCycleCount(MediaPlayer.INDEFINITE);

        canvas.setFocusTraversable(true);

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
    }

    private void keyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE && !dino.getIsJumping() && isPlaying && !dino.getIsSitDown()) {
            dino.setIsJumping(true);
            dino.jump();
        } else if (event.getCode() == KeyCode.S && !dino.getIsJumping() && isPlaying && !dino.getIsSitDown()) {
            dino.setIsSitDown(true);
            dino.sitDown();
        } else if (event.getCode() == KeyCode.ESCAPE) {
            screenController.setScene("mainScene");
        } else if (event.getCode() == KeyCode.R && !isPlaying) {
            restartGame();
        }
    }

    private void keyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.S && isPlaying && dino.getIsSitDown()) {
            dino.standUp();
        }
    }

    private void restartGame() {
        forrest.clearEnemies();
        dino.restartDino();

        isPlaying = true;
        score = 0;

        gameSound.seek(Duration.ZERO);
        gameSound.play();
    }

    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.drawImage(dino.getDinoImage(), dino.getX(), dino.getY(), dino.getDinoSizeHeight(), dino.getDinoSizeWidth());

        forrest.getEnemies().forEach((e) -> {
            gc.drawImage(e.getImage(), e.getX(), e.getY(), e.getSizeWidth(), e.getSizeHeight());
        });

        Font font = Font.font("Pixel Cyr", 40);
        gc.setFont(font);
        gc.setFill(Color.WHITE);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(javafx.geometry.VPos.TOP);

        Text text = new Text("Счет: " + score);
        double textWidth = text.getLayoutBounds().getWidth();

        if(!isPlaying) {
            gc.setFill(Color.rgb(85, 53, 199, 1));
            Text restartText = new Text("Ваш счет: " + score + "\nНажмите R, чтобы сыграть еще раз");

            gc.strokeText(restartText.getText(), (canvas.getWidth() - textWidth * 4) / 2, 250);
            gc.setStroke(Color.WHITE);
            gc.setLineWidth(1);
            gc.fillText(restartText.getText(), (canvas.getWidth() - textWidth * 4) / 2, 250);

        } else {
            gc.fillText(text.getText(), (canvas.getWidth() - textWidth * 4) / 2, 0);
        }
    }

    private void update() {
        clearCanvas();

        if (isPlaying) {
            score += 1;
            forrest.moveEnemies();
            checkCollision();
        }

        draw();
    }

    private void checkCollision() {
        int dinoWidth = dino.getDinoSizeWidth();

        forrest.getEnemies().forEach((e) -> {
            int enemyWidth = e.getSizeWidth();
            int enemyHeight = e.getSizeHeight();

            if (
                    ((dino.getX() <= e.getX() && (dino.getX() + dinoWidth) >= e.getX() ||
                            dino.getX() > e.getX() && e.getX() + enemyWidth >= dino.getX())) &&
                            (dino.getY() >= e.getY() && (dino.getY() - dino.getDinoSizeHeight()) <= e.getY() ||
                            dino.getY() < e.getY() && (dino.getY() >= e.getY() - enemyHeight))
            ) {
                isPlaying = false;
                gameOverSound.play();
                dino.gameOver();
                gameSound.stop();
            }
        });
    }

    private void clearCanvas() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void startGame(String difficulty) {
        if (dino == null) {
            dino = new DinoObject((int) node.getScene().getHeight());
        }

        if (forrest == null) {
            forrest = new ForrestObject((int) node.getScene().getHeight(), (int) node.getScene().getWidth());
        }

        switch (difficulty) {
            case "easy" -> forrest.setEnemySpeed(15);
            case "medium" -> forrest.setEnemySpeed(20);
            case "hard" -> forrest.setEnemySpeed(25);
        }

        restartGame();
        animationTimer.start();

        gameSound.play();

    }

    public void stopGame() {
        animationTimer.stop();

        gameSound.stop();
    }
}