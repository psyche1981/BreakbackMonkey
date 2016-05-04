package psyche.breakbackmonkey.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.utils.Vars;

public class DesktopLauncher {
	public static void main (String[] arg) 
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Vars.TITLE;
		config.width = Vars.WIDTH * 2;
		config.height = Vars.HEIGHT * 2;
		config.resizable = false;
		new LwjglApplication(new Game(), config);
	}
}
