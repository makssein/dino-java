package com.dino.app.objects;

import javafx.scene.image.Image;

import java.net.URISyntaxException;

public class TreeObject {

    private Image treeImage;

    private final int treeSpeed;

    private double treeX;
    private final int treeY;

    private final int treeSizeWidth = 146;
    private final int treeSizeHeight = 280;

    private int sceneHeight;
    private int sceneWidth;

    public TreeObject(int tSpeed, double tX, int sh, int sw) {
        sceneHeight = sh;
        sceneWidth = sw;
        treeY = sceneHeight - treeSizeHeight - 20;

        try {
            treeImage = new Image(getClass().getResource("/img/tree.png").toURI().toString());
        } catch (URISyntaxException e) {
            System.out.println("dino image not found");
        }

        if(tX > 0) {
            treeX = tX;
        } else {
            treeX = sceneWidth;
        }

//        treeX = 1920;

        treeSpeed = tSpeed;
    }

    public Image getTreeImage() {
        return treeImage;
    }

    public double getX() {
        return treeX;
    }

    public double getY() {
        return treeY;
    }

    public void move() {
        treeX -= treeSpeed;
    }

    public int getTreeSizeHeight() {
        return treeSizeHeight;
    }

    public int getTreeSizeWidth() {
        return treeSizeWidth;
    }
}
