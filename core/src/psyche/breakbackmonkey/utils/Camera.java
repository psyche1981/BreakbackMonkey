package psyche.breakbackmonkey.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera 
{
	public static OrthographicCamera viewport;
	
	public static void load()
	{
		viewport = new OrthographicCamera();
		viewport.setToOrtho(false, Vars.WIDTH, Vars.HEIGHT);
	}
}
