package com.dino.app.objects;

public class BirdObject extends DefaultDinoEnemyObject {

    private static String BIRD_DEFAULT_PATH = "/img/bird.png";
    public BirdObject(int tSpeed, double tX, int sh, int sw) {
        super(tSpeed, tX, sh, sw, BIRD_DEFAULT_PATH);

        enemySizeWidth = 250;
        enemySizeHeight = 280;

        enemyY = sceneHeight - enemySizeHeight - 150;
    }
}
