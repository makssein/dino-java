package com.dino.app.objects;

import javafx.scene.image.Image;

import java.net.URISyntaxException;

public class TreeObject extends DefaultDinoEnemyObject {
    public TreeObject(int tSpeed, double tX, int sh, int sw) {
        sceneHeight = sh;
        sceneWidth = sw;
        enemyY = sceneHeight - enemySizeHeight - 20;

        try {
            enemyImage = new Image(getClass().getResource("/img/tree.png").toURI().toString());
        } catch (URISyntaxException e) {
            System.out.println("dino image not found");
        }

        if(tX > 0) {
            enemyX = tX;
        } else {
            enemyX = sceneWidth;
        }

        enemySpeed = tSpeed;
    }
}
