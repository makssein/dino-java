package com.dino.app.objects;

public class TreeObject extends DefaultDinoEnemyObject {

    private static String TREE_DEFAULT_PATH = "/img/tree.png";
    public TreeObject(int tSpeed, double tX, int sh, int sw) {
        super(tSpeed, tX, sh, sw, TREE_DEFAULT_PATH);

        enemySizeWidth = 146;
        enemySizeHeight = 280;

        enemyY = sceneHeight - enemySizeHeight - 20;
    }
}
