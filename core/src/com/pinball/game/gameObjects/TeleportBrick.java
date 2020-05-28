package com.pinball.game.gameObjects;

import com.badlogic.gdx.graphics.Texture;

public class TeleportBrick extends Brick {

    public TeleportBrick(float x, float y, float width, float height){
        super(x, y, width, height);
        brickTexture = new Texture("brick_teleport.png");
    }


}
