package com.pinball.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pinball.game.PinballGame;
import com.pinball.game.gameObjects.*;
import com.pinball.game.utilities.BoxCollider;

import java.util.ArrayList;

public class MainGameScreen implements Screen {

    public static final int PADDLE_SPEED = 300;

    PinballGame pinballGame;

    Texture paddle;
    float paddleX = 0;
    float paddleY = 0;
    static final float PADDLE_WIDTH = 150;
    static final float PADDLE_HEIGHT = 50;
    BoxCollider paddleCollider;



    Wall leftWall;
    Wall rightWall;
    Wall topWall;

    ArrayList<Ball> balls;
    ArrayList<Brick> bricks;

    public MainGameScreen(PinballGame pinballGame){
        this.pinballGame = pinballGame;
    }

    @Override
    public void show() {
        paddle = new Texture("paddle.png");
        paddleCollider = new BoxCollider(paddleX, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT);

        leftWall = new Wall(0, 0, PinballGame.SCREEN_WIDTH/100, PinballGame.SCREEN_HEIGHT);
        rightWall = new Wall(PinballGame.SCREEN_WIDTH - PinballGame.SCREEN_WIDTH/100, 0, PinballGame.SCREEN_WIDTH/100, PinballGame.SCREEN_HEIGHT);
        topWall = new Wall(0, PinballGame.SCREEN_HEIGHT - PinballGame.SCREEN_HEIGHT/100, PinballGame.SCREEN_WIDTH, PinballGame.SCREEN_HEIGHT/100);

        bricks = new ArrayList<Brick>();

        for(float x = 0; x < 650 ; x += 80){
            for(float y = 0; y < 500; y += 30 ){

                if(y == 60){
                    bricks.add(new TeleportBrick(x + 50, y + 250, 75, 25));
                } else if(y == 420){
                    bricks.add(new MultiBallBrick(x + 50, y + 250, 75, 25));
                } else{
                    bricks.add(new Brick(x + 50, y + 250, 75, 25));
                }

            }
        }

        balls = new ArrayList<>();
        balls.add(new Ball(PADDLE_WIDTH / 2, PADDLE_HEIGHT + 2));


    }

    @Override
    public void render(float delta) {

        // Update paddle position
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
           if(paddleX > 0){
               paddleX -= PADDLE_SPEED * Gdx.graphics.getDeltaTime();
           }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(paddleX < PinballGame.SCREEN_WIDTH - PADDLE_WIDTH){
                paddleX += PADDLE_SPEED * Gdx.graphics.getDeltaTime();
            }
        }

        for (Ball ball: balls) {
            // Update ball direction
            if(ball.getBallCollider().hasCollided(leftWall.getBoxCollider())){
                ball.deflectX(1);
            }

            if(ball.getBallCollider().hasCollided(rightWall.getBoxCollider())){
                ball.deflectX(-1);
            }

            if(ball.getBallCollider().hasCollided(topWall.getBoxCollider())){
                ball.deflectY(-1);
            }

            if(ball.getBallCollider().hasCollided(paddleCollider)){
                ball.deflectY(1);
            }
        }


        // Move BoxColliders
        paddleCollider.move(paddleX, paddleY);

        for (Ball ball:balls) {
            ball.update();
        }


        ArrayList<Brick> collidedBricks = new ArrayList<>();
        for (Brick brick: bricks) {
            for (Ball ball:balls) {
                if(ball.getBallCollider().hasCollided(brick.getBoxCollider())){
                    if(brick instanceof TeleportBrick){
                        ball.teleportY(PinballGame.SCREEN_HEIGHT - 100);
                    } else if(brick instanceof MultiBallBrick){
//                        balls.add(
//                                new Ball(((MultiBallBrick) brick).getX(), ((MultiBallBrick) brick).getY())
//                        );
                        ball.reflectY();
                    } else{
                        ball.reflectY();
                    }

                    collidedBricks.add(brick);
                }
            }
        }

        for (Brick brick: collidedBricks) {

            if(brick instanceof MultiBallBrick){
                balls.add(
                    new Ball(((MultiBallBrick) brick).getX(), ((MultiBallBrick) brick).getY())
                );
            }

            bricks.remove(brick);


        }

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		pinballGame.batch.begin();
		pinballGame.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

		pinballGame.batch.draw(new Texture("paddle.png"), paddleX, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT);


		for (Ball ball:balls ) {
            ball.render(pinballGame.batch, pinballGame.shapeRenderer, false);
        }

		leftWall.render(pinballGame.batch, pinballGame.shapeRenderer, false);
		rightWall.render(pinballGame.batch, pinballGame.shapeRenderer, false);
		topWall.render(pinballGame.batch, pinballGame.shapeRenderer, false);

		for (Brick brick: bricks) {
            brick.render(pinballGame.batch, pinballGame.shapeRenderer, false);
        }

		pinballGame.batch.end();
        pinballGame.shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) { }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() { }

}
