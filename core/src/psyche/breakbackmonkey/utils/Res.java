package psyche.breakbackmonkey.utils;

import java.util.HashMap;





import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Res 
{
	public static SpriteBatch sb;
	public static ShapeRenderer sr;
	public static HashMap<String, Texture> textures;
	
		
	public static void load()
	{
		sb = new SpriteBatch();
		sr = new ShapeRenderer();
		
		loadTextures();
	}
	
	private static void loadTextures()
	{
		textures = new HashMap<String, Texture>();
		textures.put("red", new Texture(Gdx.files.internal("textures/red.png")));
		textures.put("blue", new Texture(Gdx.files.internal("textures/blue.png")));
		textures.put("white", new Texture(Gdx.files.internal("textures/white.png")));
		textures.put("green", new Texture(Gdx.files.internal("textures/green.png")));
		textures.put("yellow", new Texture(Gdx.files.internal("textures/yellow.png")));
		
	}
	
	
	
}
