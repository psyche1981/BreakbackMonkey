package psyche.breakbackmonkey.managers;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.gamestates.PlayState;

public class PlayStateManager 
{
	private Stack<PlayState> current_state;
	
	public PlayStateManager()
	{
		current_state = new Stack<PlayState>();
	}
	
	public void render(SpriteBatch sb)
	{
		
	}
	
	public void update(float dt)
	{
		
	}
}
