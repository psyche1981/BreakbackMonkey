package psyche.breakbackmonkey.managers;

import psyche.breakbackmonkey.states.State;
import psyche.breakbackmonkey.states.playstates.BBackRoom;
import psyche.breakbackmonkey.states.playstates.Factory;
import psyche.breakbackmonkey.states.playstates.UHTOffice;
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
		case UHT_OFFICE:
			return new UHTOffice(this);
		case BREAK_BACK_ROOM:
			return new BBackRoom(this);
		default:
			return new Factory(this);			
		}		
	}
	
	public void dispose()
	{
		pop();
	}
	
	
}
