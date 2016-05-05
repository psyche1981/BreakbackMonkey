package psyche.breakbackmonkey.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.managers.StateManager;

public abstract class State 
{
	private StateManager sm;
	
	public State(StateManager sm)
	{
		this.sm = sm;
	}
	
	public abstract void render(SpriteBatch sb);
	public abstract void update(float dt);
	public abstract void handleInput();	
	public abstract void dispose();
	public abstract void init();
	
}
