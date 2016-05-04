package psyche.breakbackmonkey.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Fonts 
{
	public static BitmapFont timeless_12, timeless_16, timeless_32;
	
	private static FreeTypeFontGenerator gen;
	private static FreeTypeFontParameter parameter;
	
	public static void load()
	{
		init();	
		
		gen = getGen("fonts/Timeless.ttf");
		
		timeless_12 = createFont(gen, 12);		
		timeless_16 = createFont(gen, 16);
		timeless_32 = createFont(gen, 32);	
		
		gen.dispose();
	}
	
	public static void dispose()
	{		
		timeless_12.dispose();
		timeless_16.dispose();
		timeless_32.dispose();
	}
	
	private static void init()
	{
		parameter = new FreeTypeFontParameter();		
	}
	
	private static BitmapFont createFont(FreeTypeFontGenerator gen, int size)
	{
		parameter.size = size;
		BitmapFont font = gen.generateFont(parameter);
		font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		return font;
	}
	
	private static FreeTypeFontGenerator getGen(String path)
	{
		return new FreeTypeFontGenerator(Gdx.files.internal(path));
	}
}
