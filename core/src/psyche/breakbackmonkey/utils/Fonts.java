package psyche.breakbackmonkey.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Fonts 
{
	public static BitmapFont timeless_16, timeless_30;
	
	private static FreeTypeFontGenerator timeless_gen;
	private static FreeTypeFontParameter parameter;
	
	public static void load()
	{
		init();
		parameter.size = (int)Math.ceil(16);		
		timeless_16 = timeless_gen.generateFont(parameter);
		parameter.size = 30;
		timeless_30 = timeless_gen.generateFont(parameter);
	}
	
	private static void init()
	{
		parameter = new FreeTypeFontParameter();
		timeless_gen = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Timeless.ttf"));
	}
}
