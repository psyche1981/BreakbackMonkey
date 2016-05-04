package psyche.breakbackmonkey.gamestates;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.GameStateManager;
import psyche.breakbackmonkey.Physics;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Vars;

public class ProcessOffice extends GameState
{
	private Door exit_door; 
	
	
	public ProcessOffice(GameStateManager gsm)
	{
		super(gsm);
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
				gsm.setState(GameStateManager.PLAY);
			
		}
	}

	@Override
	public void handleInput() 
	{	
		playerDirections();
		if(GameKeys.isPressed(GameKeys.ESCAPE))
			gsm.setState(GameStateManager.PLAY);
		
		
	}

	@Override
	public void dispose() 
	{	
		gsm.setSaveData(Game.player.getSaveData());
		
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
		exit_door = new Door(this, Vars.WIDTH / 2 - Door.DOOR_LONG_SIDE / 2, Vars.HUD_HEIGHT, true);
		objects.add(exit_door);		
		
	}
}
