package psyche.breakbackmonkey.utils;

import java.util.HashMap;






import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Res 
{
	public static SpriteBatch sb;
	public static ShapeRenderer sr;
	public static HashMap<String, Texture> textures;
	public static HashMap<String, Sound> sounds;
	
	private static Texture[] the_texture;
	private static Sound[] the_sound;
	
		
	public static void load()
	{
		sb = new SpriteBatch();
		sr = new ShapeRenderer();
		
		loadTextures();
		loadSounds();
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
		
		//sounds
		for(int i = 0; i < the_sound.length; i++)
		{
			the_sound[i].dispose();
		}
		sounds.clear();
	}
	
	private static void loadSounds()
	{
		String[] filenames = {"fart_2.mp3"};
		
		String[] keys = {"fart"};
		
		final int NUM_SOUNDS = filenames.length;
		the_sound = new Sound[NUM_SOUNDS];
		sounds = new HashMap<String, Sound>();
		
		for(int i = 0; i < NUM_SOUNDS; i++)
		{
			populateSoundArray(i, filenames[i]);
			addSoundToHash(keys[i], the_sound[i]);
		}
	}
	
	private static void loadTextures()
	{			
		String[] filenames = 
			{"red.png", "blue.png", "white.png", 
				"green.png", "yellow.png", "hud_rect.png"};
		
		String[] keys = {"red", "blue", "white", "green", "yellow", "hud"};
		
		final int NUM_TEXTURES = filenames.length;
		the_texture = new Texture[NUM_TEXTURES];
		textures = new HashMap<String, Texture>();
		
		for(int i = 0; i < NUM_TEXTURES; i++)
		{
			populateTexArray(i, filenames[i]);
			addTexToHash(keys[i], the_texture[i]);
		}		
	}
	
	private static void addSoundToHash(String key, Sound sound)
	{
		sounds.put(key, sound);
	}
	
	private static void addTexToHash(String key, Texture texture)
	{
		textures.put(key, texture);
	}
	
	private static void populateSoundArray(int index, String path)
	{
		String full_path = "sounds/" + path;
		the_sound[index] = Gdx.audio.newSound(Gdx.files.internal(full_path));
	}
	
	private static void populateTexArray(int index, String path)
	{
		String full_path = "textures/" + path;
		the_texture[index] = new Texture(Gdx.files.internal(full_path));
		
	}
}
