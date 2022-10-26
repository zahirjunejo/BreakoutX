package com.pinball.game.utilities;

public class BoxCollider {
    float x = 0, y = 0, width = 0, height = 0;

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public BoxCollider(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(float x, float y){
        this.x = x;
        this.y = y;
    }


    public boolean hasCollided(BoxCollider boxCollider){
        return x < boxCollider.x + boxCollider.width
                && y < boxCollider.y + boxCollider.height
                && x + width > boxCollider.x
                && y + height > boxCollider.y;
    }

}
