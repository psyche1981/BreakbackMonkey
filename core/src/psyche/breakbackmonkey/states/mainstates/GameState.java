package psyche.breakbackmonkey.states.mainstates;

import psyche.breakbackmonkey.managers.MainStateManager;
import psyche.breakbackmonkey.managers.PlayStateManager;
import psyche.breakbackmonkey.utils.Vars;
import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.input.GameKeys;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameState extends MainState
{		
	private PlayStateManager psm;
	public static Player player;
	
	public GameState(MainStateManager msm)
	{
		super(msm);		
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
		handleInput();
	}

	@Override
	public void handleInput()
	{		
		if(GameKeys.isPressed(GameKeys.P))
		{
			sm.enterState(Vars.State.PAUSE);
		}
		if(GameKeys.isPressed(GameKeys.ESCAPE))
		{
			sm.setState(Vars.State.MENU);
		}
		if(GameKeys.isPressed(GameKeys.T))
		{
			sm.setState(Vars.State.TEST_STATE);
		}		
	}

	@Override
	public void dispose() 
	{	
		Player.dispose();
		psm.dispose();		
	}

	@Override
	public void init() 
	{
		player = new Player(this);
		psm = new PlayStateManager();		
	}
	
	
	
	
	
}
