package psyche.breakbackmonkey.managers;

import psyche.breakbackmonkey.states.State;
import psyche.breakbackmonkey.states.playstates.Factory;
import psyche.breakbackmonkey.utils.Vars;

public class PlayStateManager extends StateManager
{	
	public PlayStateManager()
	{
		super();
		push(Vars.State.FACTORY);
	}

	@Override
	protected State getState(Vars.State state) 
	{
		switch(state)
		{
		case FACTORY:
			return new Factory(this);
		default:
			return new Factory(this);
		}		
	}
	
	public void dispose()
	{
		pop();
	}
	
	
}
