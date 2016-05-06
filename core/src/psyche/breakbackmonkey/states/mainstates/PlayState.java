package psyche.breakbackmonkey.states.mainstates;

import psyche.breakbackmonkey.managers.GameStateManager;
import psyche.breakbackmonkey.states.playstates.FactoryFloor;
import psyche.breakbackmonkey.utils.Vars;
import psyche.breakbackmonkey.input.GameKeys;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayState extends MainState
{	
	private FactoryFloor ffloor;
	
	public PlayState(GameStateManager gsm)
	{
		super(gsm);
		ffloor = new FactoryFloor(gsm, this);
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
