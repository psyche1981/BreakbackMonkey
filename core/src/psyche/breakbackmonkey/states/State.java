package psyche.breakbackmonkey.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.managers.StateManager;
import psyche.breakbackmonkey.utils.Camera;

public abstract class State 
{
	protected StateManager sm;
	protected OrthographicCamera camera;
	
	public State(StateManager sm)
	{
		this.sm = sm;
		this.camera = Camera.viewport;
	}
	
	public abstract void render(SpriteBatch sb);
	public abstract void update(float dt);
	public abstract void handleInput();	
	public abstract void dispose();
	public abstract void init();
	
	public OrthographicCamera getCamera() { return camera; }
	
}
