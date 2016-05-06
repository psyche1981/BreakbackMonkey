package psyche.breakbackmonkey.states.mainstates;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.managers.MainStateManager;
import psyche.breakbackmonkey.states.State;
import psyche.breakbackmonkey.utils.Camera;
import psyche.breakbackmonkey.utils.Vars;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.inanimate.Pack;
import psyche.breakbackmonkey.input.GameKeys;

public abstract class MainState extends State
{		
	protected ArrayList<GameObject> objects;
	protected ArrayList<Pack> packs;
	protected ArrayList<Pack> packs_to_remove;
	
	public MainState(MainStateManager msm)
	{
		super(msm);
		objects = new ArrayList<GameObject>();
		packs = new ArrayList<Pack>();
		packs_to_remove = new ArrayList<Pack>();
		init();
	}
	
	//temp getters
	public ArrayList<Pack> getPackList(){return packs;}
	public ArrayList<Pack> getPackRemoveList(){return packs_to_remove;}
	public ArrayList<GameObject> getObjectList(){return objects;}
	
	public abstract void render(SpriteBatch sb);
	public abstract void update(float dt);
	public abstract void handleInput();	
	public abstract void dispose();
	public abstract void init();
	
	
	protected void initRandomPacks()
	{
		Random rand = new Random();
		int no_packs = rand.nextInt(5) + 1;
		for(int i = 1; i < no_packs + 1; i++)
		{
			packs.add(new Pack(this, rand.nextInt(Vars.WIDTH - Pack.SIZE)  , rand.nextInt(Vars.HEIGHT - Vars.HUD_HEIGHT - Pack.SIZE) + Vars.HUD_HEIGHT));
		}
		
	}
	
	protected void playerDirections()
	{
		Game.player.up(GameKeys.isDown(GameKeys.W));
		Game.player.left(GameKeys.isDown(GameKeys.A));
		Game.player.down(GameKeys.isDown(GameKeys.S));
		Game.player.right(GameKeys.isDown(GameKeys.D));
	}
}
