package psyche.breakbackmonkey.states.playstates;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.managers.PlayStateManager;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Physics;
import psyche.breakbackmonkey.utils.Vars;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProcessOffice extends PlayState
{
	private Door exit_door; 
	
	
	public ProcessOffice(PlayStateManager psm)
	{
		super(psm);
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		Fonts.timeless_16.draw(sb, "Process Office", 0, 480);
		sb.end();
		
		for(GameObject go : objects)
		{
			go.render(sb);
		}
		
		
	}

	@Override
	public void update(float dt) 
	{
		handleInput();
		
		for(GameObject go : objects)
		{
			go.update(dt);
			
			if(Physics.collided(Game.player, go) == exit_door)
				sm.setState(Vars.State.PLAY);
			
		}
	}

	@Override
	public void handleInput() 
	{	
		playerDirections();
		if(GameKeys.isPressed(GameKeys.ENTER))
			sm.setState(Vars.State.PLAY);
		
		
	}

	@Override
	public void dispose() 
	{	
		for(GameObject go : objects)
		{
			go.dispose();
		}
	}

	@Override
	public void init() 
	{
		Game.player.init(this, Vars.WIDTH / 2 - Vars.PLAYER_SIZE / 2, Door.DOOR_SHORT_SIDE +  (2 * Vars.PLAYER_SIZE));
		objects.add(Game.player);
		
		doors();
	}
	
	private void doors()
	{
		exit_door = new Door(this, 30, Vars.HUD_HEIGHT, true);
		objects.add(exit_door);		
		
	}
}
