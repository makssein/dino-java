package com.dino.app.objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ForrestObject {
    private int treeSpeed;
    final Random random = new Random();

    private final ArrayList<TreeObject> forrest = new ArrayList<>();
    private int sceneHeight;
    private int sceneWidth;

    public ForrestObject(int sh, int sw) {
        sceneHeight = sh;
        sceneWidth = sw;
    }

    public void setTreeSpeed(int tSpeed) {
        treeSpeed = tSpeed;
    }

    private final int TREES_MAX_NUMBER = 3;

    public void createTree() {
        TreeObject lastTree;
        if (!forrest.isEmpty()) {
            lastTree = forrest.get(forrest.size() - 1);
        } else {
            lastTree = null;
        }

        double tX = 0;

        treeSpeed = 10;

        if(lastTree != null) {
            tX = lastTree.getX() + treeSpeed * 10 * (5 + random.nextInt(5));
        }

        forrest.add(new TreeObject(treeSpeed, tX, sceneHeight, sceneWidth));
    }

    public void moveTrees() {
        if(forrest.size() < TREES_MAX_NUMBER) {
            createTree();
        }

        Iterator<TreeObject> iterator = forrest.iterator();
        while (iterator.hasNext()) {
            TreeObject tree = iterator.next();
            tree.move();

            if (tree.getX() + 10 < 0) {
                iterator.remove();
            }
        }
    }

    public ArrayList<TreeObject> getTrees() {
        return forrest;
    }

    public void clearTrees() {
        forrest.clear();
    }
}
