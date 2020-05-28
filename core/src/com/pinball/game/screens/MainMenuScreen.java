package com.pinball.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.pinball.game.PinballGame;

public class MainMenuScreen implements Screen {

    PinballGame pinballGame;

    Texture exitButtonActive;
    Texture exitButtonInactive;
    Texture playButtonActive;
    Texture playButtonInactive;

    final static int EXIT_BUTTON_HEIGHT = 100;
    final static int EXIT_BUTTON_WIDTH = 330;
    final static int EXIT_BUTTON_X = 100;
    final static int EXIT_BUTTON_Y = 100;

    final static int PLAY_BUTTON_HEIGHT = 100;
    final static int PLAY_BUTTON_WIDTH = 330;
    final static int PLAY_BUTTON_X = 100;
    final static int PLAY_BUTTON_Y = 200;

    public MainMenuScreen(PinballGame pinballGame){
        this.pinballGame = pinballGame;
    }

    @Override
    public void show() {
        exitButtonActive = new Texture("exit_button_active.png");
        exitButtonInactive = new Texture("exit_button_inactive.png");

        playButtonActive = new Texture("play_button_active.png");
        playButtonInactive = new Texture("play_button_inactive.png");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        pinballGame.batch.begin();

//        System.out.println("mouseX: " + Gdx.input.getX());
//        System.out.println("mouseY: " + Gdx.input.getY());

        int mouseY = PinballGame.SCREEN_HEIGHT - Gdx.input.getY();

        // Check if play button was pressed.
        if(Gdx.input.getX() < PLAY_BUTTON_X + PLAY_BUTTON_WIDTH && Gdx.input.getX() > PLAY_BUTTON_X
                && mouseY > PLAY_BUTTON_Y && mouseY < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT){
            pinballGame.batch.draw(playButtonActive, PLAY_BUTTON_X, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                this.dispose();
                pinballGame.setScreen(new MainGameScreen(pinballGame));
            }
        } else {
            pinballGame.batch.draw(playButtonInactive, PLAY_BUTTON_X, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        }

        // Check if exit button is pressed.
        if(Gdx.input.getX() < EXIT_BUTTON_X + EXIT_BUTTON_WIDTH && Gdx.input.getX() > EXIT_BUTTON_X
                && mouseY > EXIT_BUTTON_Y && mouseY < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT){
            pinballGame.batch.draw(exitButtonActive, EXIT_BUTTON_X, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                this.dispose();
                Gdx.app.exit();
            }

        } else {
            pinballGame.batch.draw(exitButtonInactive, EXIT_BUTTON_X, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        }

        pinballGame.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
