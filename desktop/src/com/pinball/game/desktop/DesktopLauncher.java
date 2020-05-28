package com.pinball.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pinball.game.PinballGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.width = PinballGame.SCREEN_WIDTH;
		config.height = PinballGame.SCREEN_HEIGHT;

		new LwjglApplication(new PinballGame(), config);
	}
}
