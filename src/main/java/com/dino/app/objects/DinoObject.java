package com.dino.app.objects;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.net.URISyntaxException;

public class DinoObject {
    private int jumpSpeed = 50;
    private double gravity = 1.5;

    private boolean isJumping = false;
    private Image dinoImage;

    private int dinoX = 50;
    private int dinoY = 0;
    private final int dinoDefaultY;

    private int sceneHeight;

    private final int dinoSizeWidth = 240;
    private final int dinoSizeHeight = 240;

    public DinoObject(int sh) {
        sceneHeight = sh;
        dinoDefaultY = sceneHeight - dinoSizeHeight - 20;
        restartDino();
    }

    public Image getDinoImage() {
        return dinoImage;
    }

    public void setDinoGameOver() {
        try {
            dinoImage = new Image(getClass().getResource("/img/dino_gameover.png").toURI().toString());
        } catch (URISyntaxException e) {
            System.out.println("dino image not found");
        }
    }

    public void restartDino() {
        try {
            dinoImage = new Image(getClass().getResource("/img/dino.png").toURI().toString());
        } catch (URISyntaxException e) {
            System.out.println("dino image not found");
        }

        dinoX = 50;
        dinoY = dinoDefaultY;
    }

    public int getDinoSizeHeight() {
        return dinoSizeHeight;
    }

    public int getDinoSizeWidth() {
        return dinoSizeWidth;
    }

    public void jump() {
        final int[] currentJumpSpeed = {jumpSpeed};
        final Timeline jumpTimer = new Timeline();

        jumpTimer.getKeyFrames().add(
            new KeyFrame(Duration.millis(16), event -> {
                dinoY -= currentJumpSpeed[0];
                currentJumpSpeed[0] -= gravity;
                if (dinoY >= dinoDefaultY) {
                    dinoY = dinoDefaultY;
                    isJumping = false;

                    jumpTimer.stop();
                }
            })
        );

        jumpTimer.setCycleCount(Animation.INDEFINITE);
        jumpTimer.play();
    }

    public int getY() {
        return dinoY;
    }

    public int getX() {
        return dinoX;
    }

    public boolean getIsJumping() {
        return isJumping;
    }

    public void setIsJumping(boolean j) {
        isJumping = j;
    }
}
