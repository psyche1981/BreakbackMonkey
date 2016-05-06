package psyche.breakbackmonkey.states.playstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.managers.GameStateManager;
import psyche.breakbackmonkey.states.mainstates.MainState;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Vars;

public class Laboratory extends MainState
{
	public Laboratory(GameStateManager gsm)
	{
		super(gsm);
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		// TODO Auto-generated method stub
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		Fonts.timeless_16.draw(sb,  "Lab", 0, 480);
		sb.end();
		
	}

	@Override
	public void update(float dt) 
	{
		handleInput();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		if(GameKeys.isPressed(GameKeys.ENTER))
			sm.setState(Vars.State.PLAY);
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
