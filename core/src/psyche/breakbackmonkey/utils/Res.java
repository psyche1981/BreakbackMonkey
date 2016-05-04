package psyche.breakbackmonkey.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Res 
{
	public static SpriteBatch sb;
	public static ShapeRenderer sr;
	
	
	
	public static void load()
	{
		sb = new SpriteBatch();
		sr = new ShapeRenderer();
	}
}
