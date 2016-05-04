package psyche.breakbackmonkey.gamestates;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.GameStateManager;
import psyche.breakbackmonkey.Physics;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;
import psyche.breakbackmonkey.gameobjects.inanimate.Pack;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Vars;

public class Play extends GameState
{
	private Door uht_door, process_door, break_back_door, lab_door;
	
	public Play(GameStateManager gsm)
	{
		super(gsm);
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.setProjectionMatrix(camera.combined);
		sb.begin();		
		Fonts.timeless_16.draw(sb,  "Main Room", 20, 460);
		sb.end();
		
		for(GameObject go : objects)
		{
			go.render(sb);//will eventually pass sb with the call to render
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
		
		//update player and other gameobjects
			
		for(GameObject go : objects)
		{	
			go.update(dt);
			if(Physics.collided(Game.player, go) == process_door)
				gsm.setState(GameStateManager.PROCESS_OFFICE);
			if(Physics.collided(Game.player, go) == uht_door)
				gsm.setState(GameStateManager.UHT_DEPT);
			if(Physics.collided(Game.player, go) == break_back_door)
				gsm.setState(GameStateManager.BREAK_BACK);
			if(Physics.collided(Game.player, go) == lab_door && !go.getLocked())
				gsm.setState(GameStateManager.LAB);
			
			
		}
	
		//pack collision and updating
		for(Pack p : packs)
		{
			if(Physics.collided(Game.player, p) != null)
			{
				Game.player.getStats().setPacks(1);
				packs_to_remove.add(p);
			}
		}
		
		//remove packs
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
		Game.player.init(this, Vars.WIDTH / 2 - Vars.PLAYER_SIZE / 2, Vars.HEIGHT / 2 - Vars.PLAYER_SIZE / 2);
		objects.add(Game.player);
		doors();	
				
		initRandomPacks();
	}
	
	
	private void doors()
	{
		uht_door = new Door(this, 0, 80, false, false);
		break_back_door = new Door(this, Vars.WIDTH - Door.DOOR_SHORT_SIDE,  3 * Vars.HEIGHT / 4, false, false);
		boolean lab_key = Game.player.getInventory().getLabKey();
		System.out.println("got lab key: " + lab_key);
		
		lab_door = new Door(this, Vars.WIDTH - Door.DOOR_SHORT_SIDE,  1 * Vars.HEIGHT / 4, false, !lab_key);
		System.out.println("lab door locked:" + lab_door.getLocked());
		process_door = new Door(this, Vars.WIDTH / 2 - Door.DOOR_LONG_SIDE / 2, Vars.HEIGHT - Door.DOOR_SHORT_SIDE, true, false);
		
		objects.add(uht_door);
		objects.add(process_door);
		objects.add(break_back_door);
		objects.add(lab_door);
	}
	
	
}
