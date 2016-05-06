package psyche.breakbackmonkey.states.mainstates;

import psyche.breakbackmonkey.managers.MainStateManager;
import psyche.breakbackmonkey.states.playstates.Factory;
import psyche.breakbackmonkey.utils.Vars;
import psyche.breakbackmonkey.input.GameKeys;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameState extends MainState
{	
	private Factory ffloor;
	
	public GameState(MainStateManager msm)
	{
		super(msm);
		ffloor = new Factory(msm, this);
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		ffloor.render(sb);
	}

	@Override
	public void update(float dt) 
	{
		ffloor.update(dt);		
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
