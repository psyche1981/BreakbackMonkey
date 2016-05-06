package psyche.breakbackmonkey.states.playstates;
//TODO add a balance tank

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.managers.GameStateManager;
import psyche.breakbackmonkey.utils.Physics;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;
import psyche.breakbackmonkey.gameobjects.inanimate.Pack;
import psyche.breakbackmonkey.states.mainstates.MainState;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.utils.Vars;

public class BBackRoom extends MainState
{
	private Door exit_door;
	
	public BBackRoom(GameStateManager gsm)
	{
		super(gsm);
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
			
			if(Physics.collided(Game.player, go) == exit_door)
			{
				gsm.setState(GameStateManager.PLAY);
			}
		}
		
		for(Pack p : packs)
		{
			if(Physics.collided(Game.player, p) != null)
			{
				Game.player.getStats().setPacks(1);
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
			Game.player.getStats().setBalTankVol(Game.player.getStats().getPacks());
			Game.player.getStats().setXP(Game.player.getStats().getPacks());
			Game.player.getStats().setPacks(0);
			
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
		Game.player.init(this, Door.DOOR_SHORT_SIDE + (2 * Vars.PLAYER_SIZE),  (3 * Vars.HEIGHT / 4) - Vars.PLAYER_SIZE / 2);
		objects.add(Game.player);
		exit_door = new Door(this, 0, 3 * Vars.HEIGHT / 4, false, false);
		objects.add(exit_door);
		
		initRandomPacks();
	}

}
