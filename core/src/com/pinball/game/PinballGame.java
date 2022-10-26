package com.pinball.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pinball.game.screens.MainMenuScreen;

public class PinballGame extends Game {
	public SpriteBatch batch;
	public ShapeRenderer shapeRenderer;
	public static final int SCREEN_WIDTH = 800;
	public static final int  SCREEN_HEIGHT = 800;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setColor(0,1,0,0);
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () { super.render(); }
	
	@Override
	public void dispose () { }
}
