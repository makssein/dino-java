package com.dino.app.objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ForrestObject {
    private int enemySpeed;
    final Random random = new Random();

    private final ArrayList<DefaultDinoEnemyObject> forrest = new ArrayList<>();
    private int sceneHeight;
    private int sceneWidth;

    public ForrestObject(int sh, int sw) {
        sceneHeight = sh;
        sceneWidth = sw;
    }

    public void setEnemySpeed(int eSpeed) {
        enemySpeed = eSpeed;
    }

    private final int EMENY_MAX_NUMBER = 3;

    private void createEnemy() {
        DefaultDinoEnemyObject lastEnemy;
        if (!forrest.isEmpty()) {
            lastEnemy = forrest.get(forrest.size() - 1);
        } else {
            lastEnemy = null;
        }

        double eX = 0;

        if(lastEnemy != null) {
            eX = lastEnemy.getX() + enemySpeed * 10 * (5 + random.nextInt(5));
        }

        forrest.add(new TreeObject(enemySpeed, eX, sceneHeight, sceneWidth));
    }

    public void moveEnemies() {
        if(forrest.size() < EMENY_MAX_NUMBER) {
            createEnemy();
        }

        Iterator<DefaultDinoEnemyObject> iterator = forrest.iterator();
        while (iterator.hasNext()) {
            DefaultDinoEnemyObject enemy = iterator.next();
            enemy.move();

            if (enemy.getX() + enemy.getSizeWidth() < 0) {
                iterator.remove();
            }
        }
    }

    public ArrayList<DefaultDinoEnemyObject> getEnemies() {
        return forrest;
    }

    public void clearEnemies() {
        forrest.clear();
    }
}
