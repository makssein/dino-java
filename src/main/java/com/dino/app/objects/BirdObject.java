package com.dino.app.objects;

import javafx.scene.image.Image;

import java.net.URISyntaxException;

public class BirdObject extends DefaultDinoEnemyObject {
    public BirdObject(int tSpeed, double tX, int sh, int sw) {
        sceneHeight = sh;
        sceneWidth = sw;
        enemyY = sceneHeight - enemySizeHeight - 100;

        try {
            enemyImage = new Image(getClass().getResource("/img/bird.png").toURI().toString());
        } catch (
                URISyntaxException e) {
            System.out.println("dino image not found");
        }

        if (tX > 0) {
            enemyX = tX;
        } else {
            enemyX = sceneWidth;
        }

        enemySpeed = tSpeed;
    }
}
