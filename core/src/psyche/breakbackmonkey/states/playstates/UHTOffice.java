package psyche.breakbackmonkey.states.playstates;

import java.util.Random;

import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.gameobjects.entities.TeamLeader;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.managers.PlayStateManager;
import psyche.breakbackmonkey.states.mainstates.GameState;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Physics;
import psyche.breakbackmonkey.utils.Vars;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UHTOffice extends PlayState
{
	public static final int GW_NUM = 3;
	public static final int GW_Q = 0;
	public static final int GW_Y = 1;
	public static final int GW_N = 2;
	
	private TeamLeader tl;
	private boolean[] gw_dialogue;
	private Door exit_door;
	
	public UHTOffice(PlayStateManager psm)
	{
		super(psm);
		init();
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.setProjectionMatrix(camera.combined);
		
		sb.begin();
		Fonts.timeless_16.draw(sb, "UHT Office", 0, 480);
		sb.end();
		
		if(gw_dialogue[GW_Q] && !gw_dialogue[GW_Y])
		{
			sb.begin();
			Fonts.timeless_16.draw(sb, "Do you like my trainers? (Y/N) ", 100, 50);
			sb.end();
		}
		
		if(gw_dialogue[GW_Y])
		{
			sb.begin();
			Fonts.timeless_16.draw(sb, "I found them in a field ", 100, 50);
			sb.end();
		}
		
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
			if(Physics.collided(go) == tl )
			{
				if(tl.getWho() == TeamLeader.GW)
					gw_dialogue[GW_Q] = true;
				
				if(tl.getWho() == TeamLeader.DA)
					GameState.player.getInventory().setLabKey(true);
			}
			
			if(Physics.collided(go) == exit_door)
				sm.setState(Vars.State.FACTORY);
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
			GameState.player.getStats().setEnergy(-10);
		}
		
		if(gw_dialogue[GW_Q] && GameKeys.isPressed(GameKeys.N))
			sm.setState(Vars.State.FACTORY);
			
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
		Random rand = new Random();
		float rand_spawn = rand.nextFloat();
		gw_dialogue = new boolean[GW_NUM];
		Player.init(this, Vars.WIDTH / 2 - Vars.PLAYER_SIZE / 2, Vars.HEIGHT / 2 - Vars.PLAYER_SIZE / 2);
				
		if(rand_spawn > 0.5f)
		{
			tl = new TeamLeader(this, TeamLeader.GW , 200, 400);
			objects.add(tl);
		}
		else
		{
			tl = new TeamLeader(this, TeamLeader.DA, 300, 200);
			objects.add(tl);
		}
		
		exit_door = new Door(this, Vars.WIDTH / 2 - Door.DOOR_LONG_SIDE / 2, Vars.HUD_HEIGHT, true, false);
		objects.add(exit_door);
		
	}
	
	
}
