package psyche.breakbackmonkey.states.playstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.managers.PlayStateManager;
import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Vars;

public class Laboratory extends PlayState
{
	public Laboratory(PlayStateManager psm)
	{
		super(psm);
	}

	@Override
	public void render(SpriteBatch sb) 
	{		
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		Fonts.timeless_16.draw(sb,  "Lab", 0, 480);
		sb.end();
		
		Player.render(sb);
		
	}

	@Override
	public void update(float dt) 
	{
		handleInput();
		
		Player.update(dt);
	}

	@Override
	public void handleInput() 
	{
		playerDirections();
		
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
