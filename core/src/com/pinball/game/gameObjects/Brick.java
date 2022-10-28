package com.pinball.game.gameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pinball.game.utilities.BoxCollider;

public class Brick {
    protected Texture brickTexture;
    BoxCollider boxCollider;

    float X = 0;
    float Y = 0;
    float WIDTH = 0;
    float HEIGHT = 0;

    public Brick(float x, float y, float width, float height){
        brickTexture = new Texture("brick_basic.png");

        this.X = x;
        this.Y = y;
        this.WIDTH = width;
        this.HEIGHT = height;

        boxCollider = new BoxCollider(this.X, this.Y, this.WIDTH, this.HEIGHT);
    }

    public void render(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer, boolean isDebugMode){
        spriteBatch.draw(brickTexture, this.X, this.Y, this.WIDTH, this.HEIGHT);

        if(isDebugMode){
            shapeRenderer.rect(boxCollider.getX(), boxCollider.getY(), boxCollider.getWidth(), boxCollider.getHeight());
        }
    }

    public BoxCollider getBoxCollider(){
        return boxCollider;
    }

}
