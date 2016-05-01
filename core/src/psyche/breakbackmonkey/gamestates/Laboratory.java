package psyche.breakbackmonkey.gamestates;

import psyche.breakbackmonkey.GameStateManager;
import psyche.breakbackmonkey.input.GameKeys;

public class Laboratory extends GameState
{
	public Laboratory(GameStateManager gsm)
	{
		super(gsm);
	}

	@Override
	public void render() 
	{
		// TODO Auto-generated method stub
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		font.draw(sb,  "Lab", 0, 480);
		sb.end();
		
	}

	@Override
	public void update(float dt) 
	{
		// TODO Auto-generated method stub
		handleInput();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		if(GameKeys.isPressed(GameKeys.ENTER))
			gsm.setState(GameStateManager.PLAY);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
		
}
