package psyche.breakbackmonkey.gamestates;


import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.GameStateManager;
import psyche.breakbackmonkey.Physics;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;
import psyche.breakbackmonkey.gameobjects.inanimate.Pack;
import psyche.breakbackmonkey.input.GameKeys;

public class Play extends GameState
{
	private Door uht_door, process_door, break_back_door, lab_door;
	private boolean show_test = false;
	
	public Play(GameStateManager gsm)
	{
		super(gsm);
	}

	@Override
	public void render() 
	{
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		font.draw(sb,  "Main Room", 20, 460);
		sb.end();
		
		for(GameObject go : objects)
		{
			go.render();//will eventually pass sb with the call to render
		}
		
		for(Pack p : packs)
		{
			p.render();
		}
		
		int packs = player.getStats().getPacks();
		int xp =  player.getStats().getXP();
		
		if(show_test)
		{
			sb.begin();
			font.draw(sb,  "Packs: " +packs, 100, 120);
			font.draw(sb,  "XP: " +xp, 200, 120);
			sb.end();
			if(packs > player.getInventory().getMaxPacks())
			{
				sb.begin();
				font.draw(sb,  "Too Many Packs", 200, 75);
				sb.end();
			}
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
			if(Physics.collided(player, go) == process_door)
				gsm.setState(GameStateManager.PROCESS_OFFICE);
			if(Physics.collided(player, go) == uht_door)
				gsm.setState(GameStateManager.UHT_DEPT);
			if(Physics.collided(player, go) == break_back_door)
				gsm.setState(GameStateManager.BREAK_BACK);
			if(Physics.collided(player, go) == lab_door && !go.getLocked())
				gsm.setState(GameStateManager.LAB);
			
			
		}
	
		//pack collision and updating
		for(Pack p : packs)
		{
			if(Physics.collided(player, p) != null)
			{
				player.getStats().setPacks(1);
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
		
		if(GameKeys.isPressed(GameKeys.N))
			show_test = true;
		
	}

	@Override
	public void dispose() 
	{
		gsm.setSaveData(player.getSaveData());
		
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
		player = new Player(this, gsm.getStats(), gsm.getInventory(), Game.WIDTH / 2 - Player.SIZE / 2, Game.HEIGHT / 2 - Player.SIZE / 2);
		objects.add(player);
		doors();	
				
		initRandomPacks();
	}
	
	
	private void doors()
	{
		uht_door = new Door(this, 0, 30, false, false);
		break_back_door = new Door(this, Game.WIDTH - Door.DOOR_SHORT_SIDE,  3 * Game.HEIGHT / 4, false, false);
		boolean lab_key = player.getInventory().getLabKey();
		System.out.println("got lab key: " + lab_key);
		
		lab_door = new Door(this, Game.WIDTH - Door.DOOR_SHORT_SIDE,  1 * Game.HEIGHT / 4, false, !lab_key);
		System.out.println("lab door locked:" + lab_door.getLocked());
		process_door = new Door(this, Game.WIDTH / 2 - Door.DOOR_LONG_SIDE / 2, Game.HEIGHT - Door.DOOR_SHORT_SIDE, true, false);
		
		objects.add(uht_door);
		objects.add(process_door);
		objects.add(break_back_door);
		objects.add(lab_door);
	}
	
	
}
