package com.pinball.game.gameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pinball.game.utilities.BoxCollider;

public class Wall {
    Texture wallTexture;
    BoxCollider boxCollider;

    float X = 0;
    float Y = 0;
    float WIDTH = 0;
    float HEIGHT = 0;

    public Wall(float x, float y, float width, float height){
        wallTexture = new Texture("wall.png");

        this.X = x;
        this.Y = y;
        this.WIDTH = width;
        this.HEIGHT = height;

        boxCollider = new BoxCollider(this.X, this.Y, this.WIDTH, this.HEIGHT);
    }

    public void render(SpriteBatch spriteBatch){
        spriteBatch.draw(wallTexture, this.X, this.Y, this.WIDTH, this.HEIGHT);
    }

    public BoxCollider getBoxCollider(){
        return boxCollider;
    }

}
