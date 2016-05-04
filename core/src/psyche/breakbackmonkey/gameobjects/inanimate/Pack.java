package psyche.breakbackmonkey.gameobjects.inanimate;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import psyche.breakbackmonkey.GameFlags;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gamestates.GameState;

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
		sr.setProjectionMatrix(camera.combined);
		sr.begin(ShapeType.Filled);
		sr.setColor(colour);
		sr.rect(rect.getX(), rect.getY(), SIZE, SIZE);
		sr.end();
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
