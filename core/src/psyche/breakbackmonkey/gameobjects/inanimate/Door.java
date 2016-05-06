package psyche.breakbackmonkey.gameobjects.inanimate;



import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.GameFlags;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.states.playstates.PlayState;
import psyche.breakbackmonkey.utils.Res;

public class Door extends GameObject
{
	public static final int DOOR_SHORT_SIDE = 4;
	public static final int DOOR_LONG_SIDE = 32;
	
	public Door(PlayState state, float x, float y, boolean horizontal)
	{
		this(state, x, y, horizontal, false);
	}
	
	

	
	public Door(PlayState state, float x, float y, boolean horizontal, boolean locked)
	{
		super(state, x, y);
		setLocked(locked);
		if(horizontal)
			rect.set(x, y, DOOR_LONG_SIDE, DOOR_SHORT_SIDE);
		else
			rect.set(x, y, DOOR_SHORT_SIDE,DOOR_LONG_SIDE);
	}
	
	public Door() {}

	@Override
	public void update(float dt){}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw(Res.textures.get("red"), rect.getX(), rect.getY(),rect.getWidth(),rect.getHeight());
		sb.end();
	}

	

	@Override
	public void dispose() 
	{
		
	}

	@Override
	public void init() 
	{
		colour = new Color(1, 0, 0, 1);
		flags[GameFlags.SOLID_FLAG] = true;
		flags[GameFlags.INANIMATE_FLAG] = true;
		
	}
}
