package psyche.breakbackmonkey.utils;

public class Sound 
{
	public static void play(String key)
	{
		Res.sounds.get(key).play();
	}
	
	public static void stop(String key)
	{
		Res.sounds.get(key).stop();
	}
	
	public static void pause(String key)
	{
		Res.sounds.get(key).pause();
	}
	
	
}
