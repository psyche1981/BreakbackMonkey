package psyche.breakbackmonkey.gamestates;
//FIXME add a text view screen rect to bottom and boundary collisions
import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.GameStateManager;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.inanimate.Pack;
import psyche.breakbackmonkey.input.GameKeys;

public abstract class GameState 
{
	protected GameStateManager gsm;
	protected Game game;
	protected SpriteBatch sb;
	protected OrthographicCamera camera;
	protected BitmapFont font;
	protected ArrayList<GameObject> objects;
	protected ArrayList<Pack> packs;
	protected ArrayList<Pack> packs_to_remove;
	
	public GameState(GameStateManager gsm)
	{
		this.gsm = gsm;
		game = gsm.getGame();
		camera = game.getCamera();
		sb = Game.sb;
		font = new BitmapFont();
		objects = new ArrayList<GameObject>();
		packs = new ArrayList<Pack>();
		packs_to_remove = new ArrayList<Pack>();
		init();
	}
	
	public abstract void render();
	public abstract void update(float dt);
	public abstract void handleInput();	
	public abstract void dispose();
	public abstract void init();
	
	public OrthographicCamera getCamera() { return camera; }
	
	protected void initRandomPacks()
	{
		Random rand = new Random();
		int no_packs = rand.nextInt(5) + 1;
		for(int i = 1; i < no_packs + 1; i++)
		{
			packs.add(new Pack(this, rand.nextInt(Game.WIDTH - Pack.SIZE)  , rand.nextInt(Game.HEIGHT - Pack.SIZE)));
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
