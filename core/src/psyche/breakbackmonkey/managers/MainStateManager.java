package psyche.breakbackmonkey.managers;

import psyche.breakbackmonkey.states.State;
import psyche.breakbackmonkey.states.mainstates.MenuState;
import psyche.breakbackmonkey.states.mainstates.PauseState;
import psyche.breakbackmonkey.states.mainstates.GameState;
import psyche.breakbackmonkey.states.mainstates.TestState;
import psyche.breakbackmonkey.utils.Vars;

public class MainStateManager extends StateManager
{		
	public MainStateManager()
	{
		super();
		push(Vars.State.MENU);
	}
		
	public State getCurrentState() {return current_state.peek();}

	@Override
	public State getState(Vars.State state) 
	{
		switch(state)
		{
		case PLAY:
			return new GameState(this);
		case MENU:
			return new MenuState(this);
		case PAUSE:
			return new PauseState(this);
		case TEST_STATE:
			return new TestState(this);
		default:
			return new MenuState(this);
		}
	}
}
