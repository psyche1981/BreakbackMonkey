package psyche.breakbackmonkey.gamestates;

import psyche.breakbackmonkey.GameStateManager;
import psyche.breakbackmonkey.input.GameKeys;

public class Menu extends GameState
{
	public Menu(GameStateManager gsm)
	{
		super(gsm);
	}


	@Override
	public void render() 
	{
		// TODO Change menu to have options (play, quit, controls)
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		font.draw(sb, "Welcome To Break Back Monkey!!!", 200, 350);
		font.draw(sb, "Press Enter to Play", 250, 200);
		sb.end();
	}

	@Override
	public void update(float dt) 
	{
		handleInput();
	}

	@Override
	public void handleInput() 
	{
		// TODO Auto-generated method stub
		if(GameKeys.isPressed(GameKeys.ENTER))
			gsm.setState(GameStateManager.PLAY);
			
	}

	@Override
	public void dispose() {}

	@Override
	public void init() 
	{
		// TODO Auto-generated method stub		
	}		
	
}
