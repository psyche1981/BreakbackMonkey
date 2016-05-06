package psyche.breakbackmonkey.managers;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.states.State;
import psyche.breakbackmonkey.states.mainstates.MainState;
import psyche.breakbackmonkey.states.mainstates.MenuState;
import psyche.breakbackmonkey.states.mainstates.PauseState;
import psyche.breakbackmonkey.states.mainstates.PlayState;
import psyche.breakbackmonkey.states.playstates.BBackRoom;
import psyche.breakbackmonkey.states.playstates.Laboratory;
import psyche.breakbackmonkey.states.playstates.MiniGames;
import psyche.breakbackmonkey.states.playstates.ProcessOffice;
import psyche.breakbackmonkey.states.playstates.UHTDept;
import psyche.breakbackmonkey.states.playstates.UHTOffice;
import psyche.breakbackmonkey.managers.PlayStateManager;
import psyche.breakbackmonkey.utils.Vars;

public class GameStateManager extends StateManager
{	
	
	public GameStateManager()
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
			return new PlayState(this);
		case MENU:
			return new MenuState(this);
		case PAUSE:
			return new PauseState(this);
		}
		return null;
	}
}
