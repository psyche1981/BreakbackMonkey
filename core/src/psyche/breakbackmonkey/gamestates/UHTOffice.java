package psyche.breakbackmonkey.gamestates;

import java.util.Random;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.GameStateManager;
import psyche.breakbackmonkey.Physics;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.gameobjects.entities.UHTTeamLeader;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;
import psyche.breakbackmonkey.input.GameKeys;

public class UHTOffice extends GameState
{
	public static final int GW_NUM = 3;
	public static final int GW_Q = 0;
	public static final int GW_Y = 1;
	public static final int GW_N = 2;
	
	private UHTTeamLeader tl;
	private boolean[] gw_dialogue;
	private Door exit_door;
	
	public UHTOffice(GameStateManager gsm)
	{
		super(gsm);
	}

	@Override
	public void render() 
	{
		sb.setProjectionMatrix(camera.combined);
		
		sb.begin();
		font.draw(sb, "UHT Office", 0, 480);
		sb.end();
		
		if(gw_dialogue[GW_Q] && !gw_dialogue[GW_Y])
		{
			sb.begin();
			font.draw(sb, "Do you like my trainers? (Y/N) ", 100, 50);
			sb.end();
		}
		
		if(gw_dialogue[GW_Y])
		{
			sb.begin();
			font.draw(sb, "I found them in a field ", 100, 50);
			sb.end();
		}
		
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
			if(Physics.collided(Game.player, go) == tl )
			{
				if(tl.getWho() == UHTTeamLeader.GW)
					gw_dialogue[GW_Q] = true;
				
				if(tl.getWho() == UHTTeamLeader.DA)
					Game.player.getInventory().setLabKey(true);
			}
			
			if(Physics.collided(Game.player, go) == exit_door)
				gsm.setState(GameStateManager.UHT_DEPT);
		}
		
		
	}

	@Override
	public void handleInput() 
	{
		playerDirections();
		
		if(gw_dialogue[GW_Q] && GameKeys.isPressed(GameKeys.Y))
		{
			gw_dialogue[GW_Q] = false;
			gw_dialogue[GW_Y] = true;
			Game.player.getStats().setEnergy(-10);
		}
		
		if(gw_dialogue[GW_Q] && GameKeys.isPressed(GameKeys.N))
			gsm.setState(GameStateManager.PLAY);
			
	}

	@Override
	public void dispose() 
	{
		// save the players data
		gsm.setSaveData(Game.player.getSaveData());
		
		for(GameObject go : objects)
		{
			go.dispose();
		}
		
		
	}

	@Override
	public void init() 
	{
		Random rand = new Random();
		float rand_spawn = rand.nextFloat();
		gw_dialogue = new boolean[GW_NUM];
		Game.player.init(this, Game.WIDTH / 2 - Player.SIZE / 2, Game.HEIGHT / 2 - Player.SIZE / 2);
		objects.add(Game.player);
		
		if(rand_spawn > 0.5f)
		{
			tl = new UHTTeamLeader(this, UHTTeamLeader.GW , 200, 400);
			objects.add(tl);
		}
		else
		{
			tl = new UHTTeamLeader(this, UHTTeamLeader.DA, 300, 200);
			objects.add(tl);
		}
		
		exit_door = new Door(this, Game.WIDTH / 2 - Door.DOOR_LONG_SIDE / 2, 0, true, false);
		objects.add(exit_door);
		
	}
	
	
}
