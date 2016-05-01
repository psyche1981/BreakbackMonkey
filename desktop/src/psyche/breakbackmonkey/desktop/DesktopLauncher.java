package psyche.breakbackmonkey.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import psyche.breakbackmonkey.Game;

public class DesktopLauncher {
	public static void main (String[] arg) 
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Game.TITLE;
		config.width = Game.WIDTH * Game.SCALE;
		config.height = Game.HEIGHT * Game.SCALE;
		config.resizable = false;
		new LwjglApplication(new Game(), config);
	}
}
