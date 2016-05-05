package psyche.breakbackmonkey.gamestates.playstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.managers.GameStateManager;
import psyche.breakbackmonkey.utils.Physics;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;
import psyche.breakbackmonkey.gamestates.GameState;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Vars;


public class UHTDept extends GameState
{
	private Door uht_office_door, exit_door;
	
	public UHTDept(GameStateManager gsm)
	{
		super(gsm);
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.setProjectionMatrix(camera.combined);
		
		sb.begin();
		Fonts.timeless_16.draw(sb, "UHT Department", 0, 480);
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
		for(GameObject go : objects)
		{
			go.dispose();
		}
	}

	@Override
	public void init() 
	{
		Game.player.init(this, Vars.WIDTH - Vars.PLAYER_SIZE * 5, 100);
		objects.add(Game.player);
		exit_door = new Door(this, 20, Vars.HUD_HEIGHT, true, false);
		objects.add(exit_door);
		uht_office_door = new Door(this, 0, Vars.HEIGHT / 2 - Door.DOOR_LONG_SIDE / 2, false, false );
		objects.add(uht_office_door);
		
		
		
	}
}
