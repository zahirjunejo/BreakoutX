package com.pinball.game.gameObjects;

import com.badlogic.gdx.graphics.Texture;

public class MultiBallBrick extends Brick {
    public MultiBallBrick(float x, float y, float width, float height){
        super(x, y, width, height);
        brickTexture = new Texture("brick_multi.png");
    }

    public float getX(){
        return X;
    }

    public float getY(){
        return Y;
    }
}
