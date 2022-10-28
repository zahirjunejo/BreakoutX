package com.pinball.game.gameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pinball.game.utilities.BoxCollider;

public class Ball {
    public static int BALL_SPEED = 100;
    Texture ballTexture;
    ShapeRenderer shapeRenderer = new ShapeRenderer();

    float ballX;
    float ballY;
    int directionX;
    int directionY;
    static final float BALL_WIDTH = 10;
    static final float BALL_HEIGHT = 10;
    BoxCollider ballCollider;

    public Ball(float x, float y){
        ballTexture = new Texture("ball.png");
        this.ballX = x;
        this.ballY = y;
        directionX = 1;
        directionY = 1;
        ballCollider =  new BoxCollider(this.ballX, this.ballY, BALL_WIDTH, BALL_HEIGHT);
    }

    public void deflectX(int directionX){
        this.directionX = directionX;
    }

    public void deflectY(int directionY){
        this.directionY = directionY;
    }

    public void reflectY(){
        this.directionY = this.directionY * -1;
    }

    public void teleportY(float yDest){
        ballY = yDest;
//        ballCollider.move(this.ballX, this.ballY);
    }

    public void update(){
        this.ballX += BALL_SPEED * Gdx.graphics.getDeltaTime() * this.directionX;
        this.ballY += BALL_SPEED * Gdx.graphics.getDeltaTime() * this.directionY;
        ballCollider.move(this.ballX, this.ballY);
    }

    public void render(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer, boolean isDebugMode){
        spriteBatch.draw(ballTexture, ballX, ballY, BALL_WIDTH, BALL_HEIGHT);

        if(isDebugMode){
            shapeRenderer.rect(ballCollider.getX(), ballCollider.getY(), ballCollider.getWidth(), ballCollider.getHeight());
        }

    }

    public BoxCollider getBallCollider(){
        return ballCollider;
    }
}
