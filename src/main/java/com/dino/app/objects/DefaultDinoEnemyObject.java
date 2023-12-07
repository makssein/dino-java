package com.dino.app.objects;

import javafx.scene.image.Image;

import java.net.URISyntaxException;

public class DefaultDinoEnemyObject {
    protected Image enemyImage;

    protected int enemySpeed;

    protected double enemyX;
    protected int enemyY;

    protected int enemySizeWidth;
    protected int enemySizeHeight;

    protected int sceneHeight;
    protected int sceneWidth;

    protected DefaultDinoEnemyObject(int tSpeed, double tX, int sh, int sw, String img_path) {
        sceneHeight = sh;
        sceneWidth = sw;

        try {
            enemyImage = new Image(getClass().getResource(img_path).toURI().toString());
        } catch (URISyntaxException e) {
            System.out.println("enemy image not found");
        }

        if(tX > 0) {
            enemyX = tX;
        } else {
            enemyX = sceneWidth;
        }

        enemySpeed = tSpeed;
    }

    public Image getImage() {
        return enemyImage;
    }

    public double getX() {
        return enemyX;
    }

    public double getY() {
        return enemyY;
    }

    public void move() {
        enemyX -= enemySpeed;
    }

    public int getSizeHeight() {
        return enemySizeHeight;
    }

    public int getSizeWidth() {
        return enemySizeWidth;
    }
}
