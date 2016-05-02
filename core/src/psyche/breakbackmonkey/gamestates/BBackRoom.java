package psyche.breakbackmonkey.gamestates;
//TODO add a balance tank

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.GameStateManager;
import psyche.breakbackmonkey.Physics;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;
import psyche.breakbackmonkey.gameobjects.inanimate.Pack;
import psyche.breakbackmonkey.input.GameKeys;

public class BBackRoom extends GameState
{
	private Door exit_door;
	
	public BBackRoom(GameStateManager gsm)
	{
		super(gsm);
	}

	@Override
	public void render() 
	{
		for(GameObject go : objects)
		{
			go.render();
		}
		
		for(Pack p : packs)
		{
			p.render();
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
		gsm.setSaveData(Game.player.getSaveData());
		
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
		Game.player.init(this, gsm.getStats(), gsm.getInventory(), Door.DOOR_SHORT_SIDE + (2 * Player.SIZE),  (3 * Game.HEIGHT / 4) - Player.SIZE / 2);
		objects.add(Game.player);
		exit_door = new Door(this, 0, 3 * Game.HEIGHT / 4, false, false);
		objects.add(exit_door);
		
		initRandomPacks();
	}

}
