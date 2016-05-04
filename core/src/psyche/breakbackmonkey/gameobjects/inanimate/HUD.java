package psyche.breakbackmonkey.gameobjects.inanimate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gamestates.GameState;
import psyche.breakbackmonkey.utils.Vars;

public class HUD extends GameObject{
	
	public HUD(GameState state)
	{
		super(state, 0, 0);
		rect.x = this.x;
		rect.y = this.y;
		rect.width = Vars.WIDTH;
		rect.height = 75;		
	}
		
	@Override
	public void update(float dt) 
	{
				
	}

	@Override
	public void render() 
	{
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		
		sr.setProjectionMatrix(camera.combined);
		sr.begin(ShapeType.Filled);
		sr.setColor(new Color(1,1,1,0.8f));
		sr.rect(x, y, rect.getWidth(), rect.getHeight());
		sr.end();
		
		
		Gdx.gl.glDisable(GL20.GL_BLEND);
		
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
