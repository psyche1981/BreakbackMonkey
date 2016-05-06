package psyche.breakbackmonkey.states.playstates;
//TODO add a balance tank

import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;
import psyche.breakbackmonkey.gameobjects.inanimate.Pack;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.managers.PlayStateManager;
import psyche.breakbackmonkey.states.mainstates.GameState;
import psyche.breakbackmonkey.utils.Physics;
import psyche.breakbackmonkey.utils.Vars;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BBackRoom extends PlayState
{
	private Door exit_door;
	
	public BBackRoom(PlayStateManager psm)
	{
		super(psm);
		init();
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		for(GameObject go : objects)
		{
			go.render(sb);
		}
		
		for(Pack p : packs)
		{
			p.render(sb);
		}
	}

	@Override
	public void update(float dt) 
	{
		handleInput();
		
		for(GameObject go : objects)
		{
			go.update(dt);
			
			if(Physics.collided(GameState.player, go) == exit_door)
			{
				sm.setState(Vars.State.PLAY);
			}
		}
		
		for(Pack p : packs)
		{
			if(Physics.collided(GameState.player, p) != null)
			{
				GameState.player.getStats().setPacks(1);
				packs_to_remove.add(p);
			}
		}
		
		for(Pack p : packs_to_remove)
		{
			packs.remove(p);
		}
		packs_to_remove.clear();
	}

	@Override
	public void handleInput() 
	{
		playerDirections();
	
			
		
		if(GameKeys.isPressed(GameKeys.SPACE))
		{
			GameState.player.getStats().setBalTankVol(GameState.player.getStats().getPacks());
			GameState.player.getStats().setXP(GameState.player.getStats().getPacks());
			GameState.player.getStats().setPacks(0);
			
		}
	}

	@Override
	public void dispose() 
	{
		for(GameObject go : objects)
		{
			go.dispose();
		}
		
		for(Pack p : packs)
		{
			p.dispose();
		}
		
	}

	@Override
	public void init() 
	{
		GameState.player.init(this, Door.DOOR_SHORT_SIDE + (2 * Vars.PLAYER_SIZE),  (3 * Vars.HEIGHT / 4) - Vars.PLAYER_SIZE / 2);
		objects.add(GameState.player);
		exit_door = new Door(this, 0, 3 * Vars.HEIGHT / 4, false, false);
		objects.add(exit_door);
		
		initRandomPacks();
	}

}
