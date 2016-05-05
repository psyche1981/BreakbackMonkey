package psyche.breakbackmonkey.gamestates;

import psyche.breakbackmonkey.GameStateManager;
import psyche.breakbackmonkey.gamestates.playstates.FactoryFloor;
import psyche.breakbackmonkey.input.GameKeys;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayState extends GameState
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
			gsm.enterState(GameStateManager.PAUSE);
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
