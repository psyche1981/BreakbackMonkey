package psyche.breakbackmonkey.states.playstates;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.managers.GameStateManager;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;
import psyche.breakbackmonkey.gameobjects.inanimate.Pack;
import psyche.breakbackmonkey.states.mainstates.MainState;
import psyche.breakbackmonkey.states.mainstates.PlayState;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Physics;
import psyche.breakbackmonkey.utils.Sound;
import psyche.breakbackmonkey.utils.Vars;

public class FactoryFloor
{
	private Door uht_door, process_door, break_back_door, lab_door;
	private GameStateManager gsm;
	private Game game;
	private MainState state;
	private OrthographicCamera camera;
	private ArrayList<GameObject> objects;
	private ArrayList<Pack> packs;
	private ArrayList<Pack> packs_to_remove;
	
	public FactoryFloor(GameStateManager gsm, PlayState play)
	{
		state = play;
		this.gsm = gsm;
		camera = play.getCamera();
		objects = play.getObjectList();
		packs = play.getPackList();
		packs_to_remove = play.getPackRemoveList();
		init();
	}
	
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
	
	public void update(float dt) 
	{
		handleInput();
		
		//update player and other gameobjects
			
		for(GameObject go : objects)
		{	
			go.update(dt);
			if(Physics.collided(Game.player, go) == process_door)
				gsm.setState(Vars.State.PROCESS_OFFICE);
			if(Physics.collided(Game.player, go) == uht_door)
				gsm.setState(Vars.State.UHT_OFFICE);
			if(Physics.collided(Game.player, go) == break_back_door)
				gsm.setState(Vars.State.BREAK_BACK_ROOM);
			if(Physics.collided(Game.player, go) == lab_door && !go.getLocked())
				gsm.setState(Vars.State.LAB);
			
			
		}
	
		//pack collision and updating
		for(Pack p : packs)
		{
			if(Physics.collided(Game.player, p) != null)
			{
				Sound.play("fart");
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
	
	public void handleInput()
	{
		playerDirections();
		
		if(GameKeys.isPressed(GameKeys.P))
		{
			gsm.enterState(Vars.State.PAUSE);
		}
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
		Game.player.init(state, Vars.WIDTH / 2 - Vars.PLAYER_SIZE / 2, Vars.HEIGHT / 2 - Vars.PLAYER_SIZE / 2);
		objects.add(Game.player);
		doors();	
				
		initRandomPacks();
	}
	
	private void doors()
	{
		uht_door = new Door(state, 0, 80, false, false);
		break_back_door = new Door(state, Vars.WIDTH - Door.DOOR_SHORT_SIDE,  3 * Vars.HEIGHT / 4, false, false);
		boolean lab_key = Game.player.getInventory().getLabKey();
		System.out.println("got lab key: " + lab_key);
		
		lab_door = new Door(state, Vars.WIDTH - Door.DOOR_SHORT_SIDE,  1 * Vars.HEIGHT / 4, false, !lab_key);
		System.out.println("lab door locked:" + lab_door.getLocked());
		process_door = new Door(state, Vars.WIDTH / 2 - Door.DOOR_LONG_SIDE / 2, Vars.HEIGHT - Door.DOOR_SHORT_SIDE, true, false);
		
		objects.add(uht_door);
		objects.add(process_door);
		objects.add(break_back_door);
		objects.add(lab_door);
	}
	
	private void playerDirections()
	{
		Game.player.up(GameKeys.isDown(GameKeys.W));
		Game.player.left(GameKeys.isDown(GameKeys.A));
		Game.player.down(GameKeys.isDown(GameKeys.S));
		Game.player.right(GameKeys.isDown(GameKeys.D));
	}
	
	private void initRandomPacks()
	{
		Random rand = new Random();
		int no_packs = rand.nextInt(5) + 1;
		for(int i = 1; i < no_packs + 1; i++)
		{
			packs.add(new Pack(state, rand.nextInt(Vars.WIDTH - Pack.SIZE)  , rand.nextInt(Vars.HEIGHT - Vars.HUD_HEIGHT - Pack.SIZE) + Vars.HUD_HEIGHT));
		}
		
	}
}
