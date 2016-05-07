package psyche.breakbackmonkey.states.playstates;

import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;
import psyche.breakbackmonkey.gameobjects.inanimate.Pack;
import psyche.breakbackmonkey.managers.PlayStateManager;
import psyche.breakbackmonkey.states.mainstates.GameState;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Physics;
import psyche.breakbackmonkey.utils.Sound;
import psyche.breakbackmonkey.utils.Vars;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Factory extends PlayState
{
	private Door uht_door, process_door, break_back_door, lab_door;
	
	public Factory(PlayStateManager psm) 
	{
		super(psm);
		init();
	}
	
	public void render(SpriteBatch sb)
	{
		sb.setProjectionMatrix(camera.combined);
		sb.begin();		
		Fonts.timeless_16.draw(sb,  "Main Room", 20, 460);
		sb.end();
		
		Player.render(sb);
		
		for(GameObject go : objects)
		{
			go.render(sb);
		}
		
		for(Pack p : packs)
		{
			p.render(sb);
		}			
	}
	
	public void update(float dt) 
	{
		handleInput();
		
		//update player and other gameobjects
		
		Player.update(dt);;
			
		for(GameObject go : objects)
		{	
			go.update(dt);
			if(Physics.collided(go) == process_door)
				sm.setState(Vars.State.PROCESS_OFFICE);
			if(Physics.collided(go) == uht_door)
				sm.setState(Vars.State.UHT_OFFICE);
			if(Physics.collided(go) == break_back_door)
				sm.setState(Vars.State.BREAK_BACK_ROOM);
			if(Physics.collided(go) == lab_door && !go.getLocked())
				sm.setState(Vars.State.LAB);
			
			
		}
	
		//pack collision and updating
		for(Pack p : packs)
		{
			if(Physics.collided(p) != null)
			{
				Sound.play("fart");
				GameState.player.getStats().setPacks(1);
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
	
	public void handleInput()
	{
		playerDirections();
	}
	
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
	
	public void init() 
	{
		Player.init(this, Vars.WIDTH / 2 - Vars.PLAYER_SIZE / 2, Vars.HEIGHT / 2 - Vars.PLAYER_SIZE / 2);
		doors();	
				
		initRandomPacks();
	}
	
	private void doors()
	{
		uht_door = new Door(this, 0, 80, false, false);
		break_back_door = new Door(this, Vars.WIDTH - Door.DOOR_SHORT_SIDE,  3 * Vars.HEIGHT / 4, false, false);
		boolean lab_key = GameState.player.getInventory().getLabKey();
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
