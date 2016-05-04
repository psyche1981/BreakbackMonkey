package psyche.breakbackmonkey.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import psyche.breakbackmonkey.Game;

public class DesktopLauncher {
	public static void main (String[] arg) 
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Game.TITLE;
		config.width = Game.WIDTH * 2;
		config.height = Game.HEIGHT * 2;
		config.resizable = false;
		new LwjglApplication(new Game(), config);
	}
}
