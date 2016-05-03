package psyche.breakbackmonkey.gameobjects.inanimate;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.Stats;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gamestates.GameState;

public class HUD extends GameObject{
	
	public HUD(GameState state)
	{
		super(state, 1, 0);
		rect.x = this.x;
		rect.y = this.y;
		rect.width = Game.WIDTH - 1;
		rect.height = 75;		
	}
		
	@Override
	public void update(float dt) 
	{
				
	}

	@Override
	public void render() 
	{
		sr.setProjectionMatrix(camera.combined);
		sr.begin(ShapeType.Line);
		sr.setColor(new Color(1,1,1,1));
		sr.rect(x, y, rect.getWidth(), rect.getHeight());
		sr.end();
		
	}

	@Override
	public void dispose() 
	{
				
	}

	@Override
	public void init() 
	{
				
	}
}
