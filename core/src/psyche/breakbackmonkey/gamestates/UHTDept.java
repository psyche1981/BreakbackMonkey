package psyche.breakbackmonkey.gamestates;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.GameStateManager;
import psyche.breakbackmonkey.Physics;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;


public class UHTDept extends GameState
{
	private Door uht_office_door, exit_door;
	
	public UHTDept(GameStateManager gsm)
	{
		super(gsm);
	}

	@Override
	public void render() 
	{
		sb.setProjectionMatrix(camera.combined);
		
		sb.begin();
		font.draw(sb, "UHT Department", 0, 480);
		sb.end();
		
		
		for(GameObject go : objects)
		{
			go.render();
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
			if(Physics.collided(Game.player,  go) == uht_office_door)
				gsm.setState(GameStateManager.UHT_OFFICE);
		}
		
		
	}

	@Override
	public void handleInput() 
	{
		playerDirections();
		
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
		Game.player.init(this, Game.WIDTH / 2 - Player.SIZE / 2, Door.DOOR_SHORT_SIDE +  (2 * Player.SIZE));
		objects.add(Game.player);
		exit_door = new Door(this, Game.WIDTH / 2 - Player.SIZE / 2, 0, true, false);
		objects.add(exit_door);
		uht_office_door = new Door(this, 0, Game.HEIGHT / 2 - Door.DOOR_LONG_SIDE / 2, false, false );
		objects.add(uht_office_door);
		
		
		
	}
}
