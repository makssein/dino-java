package com.dino.app.objects;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

import java.net.URISyntaxException;

public class DinoObject {
    private int jumpSpeed = 45;
    private double gravity = 1.8;

    private boolean isJumping = false;
    private boolean isSitDown = false;
    private Image dinoImage;
    private Image dinoGameOverImage;
    private Image dinoSatDownImage;
    private Image dinoDefaultImage;

    private int dinoX = 50;
    private int dinoY = 0;
    private final int dinoDefaultY;

    private int sceneHeight;

    private int dinoSizeWidth = 240;
    private int dinoSizeHeight = 240;

    private final AudioClip jumpSound;

    private static final String DINO_GAMEOVER_PATH = "/img/dino_gameover.png";
    private static final String DINO_SAT_DOWN_PATH = "/img/dino_sat_down.png";
    private static final String DINO_DEFAULT_PATH = "/img/dino.png";

    public DinoObject(int sh) {
        sceneHeight = sh;
        dinoDefaultY = sceneHeight - dinoSizeHeight - 20;

        jumpSound = new AudioClip(getClass().getResource("/sounds/jump.wav").toString());

        dinoGameOverImage = loadDinoImage(DINO_GAMEOVER_PATH);
        dinoSatDownImage = loadDinoImage(DINO_SAT_DOWN_PATH);
        dinoDefaultImage = loadDinoImage(DINO_DEFAULT_PATH);

        restartDino();
    }

    public Image getDinoImage() {
        return dinoImage;
    }

    public void restartDino() {
        dinoImage = dinoDefaultImage;

        dinoX = 50;
        dinoY = dinoDefaultY;
        dinoSizeHeight = 240;
        dinoSizeWidth = 240;
    }

    public void gameOver() {
        restartDino();
        dinoImage = dinoGameOverImage;
    }

    private Image loadDinoImage(String img_path) {
        Image img = null;
        try {
            img = new Image(getClass().getResource(img_path).toURI().toString());
        } catch (URISyntaxException e) {
            System.out.println("dino image not found");
        }

        return img;
    }

    public void jump() {
        final int[] currentJumpSpeed = {jumpSpeed};
        final Timeline jumpTimer = new Timeline();

        jumpSound.play();

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

    public void sitDown() {
        dinoSizeWidth = 119;
        dinoY = dinoDefaultY + 240 - dinoSizeWidth;

        dinoImage = dinoSatDownImage;
    }

    public void standUp() {
        isSitDown = false;
        restartDino();
    }

    public int getY() {
        return dinoY;
    }

    public int getDinoSizeHeight() {
        return dinoSizeHeight;
    }

    public int getDinoSizeWidth() {
        return dinoSizeWidth;
    }

    public int getX() {
        return dinoX;
    }

    public boolean getIsJumping() {
        return isJumping;
    }

    public boolean getIsSitDown() {
        return isSitDown;
    }

    public void setIsJumping(boolean j) {
        isJumping = j;
    }

    public void setIsSitDown(boolean j) {
        isSitDown = j;
    }
}
