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
	
	private static Texture[] the_texture;
	private static final int NUM_TEXTURES = 5;
	
		
	public static void load()
	{
		sb = new SpriteBatch();
		sr = new ShapeRenderer();
		
		loadTextures();
	}
	
	public static void dispose()
	{
		//shapes and batches
		sb.dispose();
		sr.dispose();
		
		//textures
		for(int i = 0; i < the_texture.length; i++)
		{
			the_texture[i].dispose();
		}
		textures.clear();
	}
	
	private static void loadTextures()
	{
		the_texture = new Texture[NUM_TEXTURES];
		the_texture[0] = new Texture(Gdx.files.internal("textures/red.png"));
		the_texture[1] = new Texture(Gdx.files.internal("textures/blue.png"));
		the_texture[2] = new Texture(Gdx.files.internal("textures/white.png"));
		the_texture[3] = new Texture(Gdx.files.internal("textures/green.png"));
		the_texture[4] = new Texture(Gdx.files.internal("textures/yellow.png"));
		
		textures = new HashMap<String, Texture>();
		textures.put("red", the_texture[0]);
		textures.put("blue", the_texture[1]);
		textures.put("white", the_texture[2]);
		textures.put("green", the_texture[3]);
		textures.put("yellow", the_texture[4]);
		
	}	
}
