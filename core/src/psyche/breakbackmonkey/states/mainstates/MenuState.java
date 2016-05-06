package psyche.breakbackmonkey.states.mainstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.managers.GameStateManager;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Vars;

public class MenuState extends MainState
{
	public MenuState(GameStateManager gsm)
	{
		super(gsm);
	}


	@Override
	public void render(SpriteBatch sb) 
	{
		// TODO Change menu to have options (play, quit, controls)
		String s = "Welcome To Break Back Monkey!!!";
		float text_width = Fonts.timeless_32.getBounds(s).width;
		
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		Fonts.timeless_32.setColor(1, 1, 1, 1);
		Fonts.timeless_32.draw(sb, s, Vars.WIDTH / 2 - text_width / 2, 350);
		Fonts.timeless_16.draw(sb, "Press Enter to Play", 250, 200);
				
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
			sm.setState(Vars.State.PLAY);
			
	}

	@Override
	public void dispose() {}

	@Override
	public void init() 
	{
		// TODO Auto-generated method stub		
	}		
	
}
