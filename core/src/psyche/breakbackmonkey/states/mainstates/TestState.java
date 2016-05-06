package psyche.breakbackmonkey.states.mainstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.managers.MainStateManager;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Res;
import psyche.breakbackmonkey.utils.Vars;

public class TestState extends MainState
{
	Rectangle board_rect;

	public TestState(MainStateManager msm) 
	{
		super(msm);
		board_rect = new Rectangle(100, 100, 400, 300);
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		Fonts.timeless_16.draw(sb, "Testing Arena", 10, Vars.HEIGHT - 10);
		sb.draw(Res.textures.get("blackboard"), board_rect.x, board_rect.y);
		
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
		if(GameKeys.isPressed(GameKeys.ESCAPE))
			sm.setState(Vars.State.MENU);
	}

	@Override
	public void dispose() 
	{
		
	}

	@Override
	public void init() 
	{
		
	}

	

}
