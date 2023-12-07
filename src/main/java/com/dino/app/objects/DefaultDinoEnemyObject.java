package com.dino.app.objects;

import javafx.scene.image.Image;

public class DefaultDinoEnemyObject {
    protected Image enemyImage;

    protected int enemySpeed;

    protected double enemyX;
    protected int enemyY;

    protected final int enemySizeWidth = 146;
    protected final int enemySizeHeight = 280;

    protected int sceneHeight;
    protected int sceneWidth;


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
