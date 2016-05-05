package psyche.breakbackmonkey.gamestates;

//FIXME need to preserve the playstate when entering the pause state

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.GameStateManager;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.utils.Camera;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Vars;

public class PauseState extends GameState
{
	public PauseState(GameStateManager gsm)
	{
		super(gsm);
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.setProjectionMatrix(Camera.viewport.combined);
		sb.begin();
		Fonts.timeless_32.draw(sb, "Paused", Vars.WIDTH / 2 - 50, Vars.HEIGHT - 100);
		sb.end();
	}

	@Override
	public void update(float dt) 
	{
		handleInput();
	}

	@Override
	public void handleInput() 
	{
		if(GameKeys.isPressed(GameKeys.ENTER))
		{
			gsm.exitPauseState();
		}
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
