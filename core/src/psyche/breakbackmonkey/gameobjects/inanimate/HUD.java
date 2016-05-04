package psyche.breakbackmonkey.gameobjects.inanimate;

import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gamestates.GameState;
import psyche.breakbackmonkey.utils.Res;
import psyche.breakbackmonkey.utils.Vars;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
	public void render(SpriteBatch sb) 
	{		
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw(Res.textures.get("hud"), x, y, rect.getWidth(), rect.getHeight());
		sb.end();
		
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
