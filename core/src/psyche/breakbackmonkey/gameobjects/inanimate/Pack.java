package psyche.breakbackmonkey.gameobjects.inanimate;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import psyche.breakbackmonkey.GameFlags;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gamestates.GameState;
import psyche.breakbackmonkey.utils.Res;

public class Pack extends GameObject
{
	public static final int SIZE = 4;
	
	public Pack(GameState state, float x, float y)
	{
		super(state, x, y);
				
		rect.set(x,y,SIZE,SIZE);
	}
	
	public Pack() {}

	@Override
	public void update(float dt) {}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw(Res.textures.get("green"), rect.getX(), rect.getY(), SIZE, SIZE);
		sb.end();
	}

	@Override
	public void dispose() 
	{
		
	}

	@Override
	public void init() 
	{
		colour = new Color(0.2f, 0.2f, 0.2f, 1);
		flags[GameFlags.SOLID_FLAG] = false;
		flags[GameFlags.INANIMATE_FLAG] = true;
		
	}
}
