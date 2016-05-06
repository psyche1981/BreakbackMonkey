package psyche.breakbackmonkey.input;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class GameInputProcessor extends InputAdapter
{
	
	public boolean keyDown(int k)
	{
		if(k == Keys.W)
			GameKeys.setKey(GameKeys.W, true);
		if(k == Keys.A)
			GameKeys.setKey(GameKeys.A, true);
		if(k == Keys.S)
			GameKeys.setKey(GameKeys.S, true);
		if(k == Keys.D)
			GameKeys.setKey(GameKeys.D, true);
		if(k == Keys.ENTER)
			GameKeys.setKey(GameKeys.ENTER, true);
		if(k == Keys.SPACE)
			GameKeys.setKey(GameKeys.SPACE, true);
		if(k == Keys.P)
			GameKeys.setKey(GameKeys.P, true);
		if(k == Keys.Y)
			GameKeys.setKey(GameKeys.Y, true);
		if(k == Keys.N)
			GameKeys.setKey(GameKeys.N, true);
		if(k == Keys.ESCAPE)
			GameKeys.setKey(GameKeys.ESCAPE, true);
		if(k == Keys.T)
			GameKeys.setKey(GameKeys.T, true);
		
		return true;
	}
	
	public boolean keyUp(int k)
	{
		if(k == Keys.W)
			GameKeys.setKey(GameKeys.W, false);
		if(k == Keys.A)
			GameKeys.setKey(GameKeys.A, false);
		if(k == Keys.S)
			GameKeys.setKey(GameKeys.S, false);
		if(k == Keys.D)
			GameKeys.setKey(GameKeys.D, false);
		if(k == Keys.ENTER)
			GameKeys.setKey(GameKeys.ENTER, false);
		if(k == Keys.SPACE)
			GameKeys.setKey(GameKeys.SPACE, false);
		if(k == Keys.P)
			GameKeys.setKey(GameKeys.P, false);
		if(k == Keys.Y)
			GameKeys.setKey(GameKeys.Y, false);
		if(k == Keys.N)
			GameKeys.setKey(GameKeys.N, false);
		if(k == Keys.ESCAPE)
			GameKeys.setKey(GameKeys.ESCAPE, false);
		if(k == Keys.T)
			GameKeys.setKey(GameKeys.T, false);
		
		return true;
	}
	
}
