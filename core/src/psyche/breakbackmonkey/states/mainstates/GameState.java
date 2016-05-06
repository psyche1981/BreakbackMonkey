package psyche.breakbackmonkey.states.mainstates;

import psyche.breakbackmonkey.managers.MainStateManager;
import psyche.breakbackmonkey.managers.PlayStateManager;
import psyche.breakbackmonkey.states.playstates.Factory;
import psyche.breakbackmonkey.utils.Vars;
import psyche.breakbackmonkey.input.GameKeys;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameState extends MainState
{		
	private PlayStateManager psm;
	
	public GameState(MainStateManager msm)
	{
		super(msm);
		psm = new PlayStateManager();
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		psm.render(sb);
	}

	@Override
	public void update(float dt) 
	{
		psm.update(dt);		
	}

	@Override
	public void handleInput()
	{
		playerDirections();
		
		if(GameKeys.isPressed(GameKeys.P))
		{
			sm.enterState(Vars.State.PAUSE);
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
