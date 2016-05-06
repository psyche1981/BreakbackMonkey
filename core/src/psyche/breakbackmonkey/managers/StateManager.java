package psyche.breakbackmonkey.managers;

import java.util.Stack;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.states.State;
import psyche.breakbackmonkey.utils.Vars;

public abstract class StateManager 
{
	protected Stack<State> current_state;
	
	public StateManager()
	{
		current_state = new Stack<State>();
	}
	
	public void setState(Vars.State state)
	{
		pop();
		push(state);
	}
	
	public void update(float dt)
	{
		current_state.peek().update(dt);
	}
	
	public void render(SpriteBatch sb)
	{
		current_state.peek().render(sb);
	}
	
	public void enterState(Vars.State state)
	{
		push(state);
	}
	
	public void exitState()
	{
		pop();
	}	
	
	public State getCurrentState() {return current_state.peek();}
	
	protected void push(Vars.State state)
	{
		current_state.push(getState(state));
	}
	
	protected void pop()
	{
		State s = current_state.pop();
		s.dispose();
	}
	
	protected abstract State getState(Vars.State state);
}
