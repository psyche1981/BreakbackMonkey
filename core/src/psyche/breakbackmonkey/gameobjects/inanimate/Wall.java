package psyche.breakbackmonkey.gameobjects.inanimate;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

import psyche.breakbackmonkey.GameFlags;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gamestates.GameState;

public class Wall extends GameObject
{
	public Wall(GameState state, float x, float y, float width, float height)
	{
		super(state, x, y);
		rect = new Rectangle(x, y, width, height);
	}

	@Override
	public void render() 
	{
		sr.setProjectionMatrix(camera.combined);
		sr.begin(ShapeType.Filled);
		sr.setColor(colour);
		sr.rect(rect.getX(), rect.getY(),rect.getWidth(),rect.getHeight());
		sr.end();
		
	}

	@Override
	public void dispose() 
	{
		sr.dispose();
	}

	@Override
	public void init() 
	{
		colour = new Color(0.3f, 0.3f, 0.3f, 1);
		flags[GameFlags.SOLID_FLAG] = true;
		flags[GameFlags.INANIMATE_FLAG] = true;
		
	}
	@Override
	public void update(float dt) {}
}
