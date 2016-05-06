package psyche.breakbackmonkey.managers;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.managers.GameStateManager;
import psyche.breakbackmonkey.states.mainstates.PlayState;
import psyche.breakbackmonkey.utils.Vars;

public class PlayStateManager 
{
	private GameStateManager gsm;
	private Stack<PlayState> current_state;
	
	public PlayStateManager(GameStateManager gsm)
	{
		this.gsm = gsm;
		current_state = new Stack<PlayState>();
	}
	
	public void render(SpriteBatch sb)
	{
		current_state.peek().render(sb);
	}
	
	public void update(float dt)
	{
		current_state.peek().update(dt);
	}	
	
	public void setState(Vars.State state)
	{
		pop();
		push(state);
	}
	
	private void pop()
	{
		PlayState s = current_state.pop();
		s.dispose();
	}
	
	private void push(Vars.State state)
	{
		current_state.push(getState(state));
	}
	
	private PlayState getState(Vars.State state)
	{
		switch(state)
		{
		case FACTORY_FLOOR:
			return null;//new FactoryFloor(gsm);
		default:
			return null;
		}
	}
}
