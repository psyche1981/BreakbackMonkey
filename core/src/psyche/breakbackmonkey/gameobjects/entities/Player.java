package psyche.breakbackmonkey.gameobjects.entities;

import psyche.breakbackmonkey.Inventory;
import psyche.breakbackmonkey.SaveData;
import psyche.breakbackmonkey.Stats;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gamestates.GameState;
import psyche.breakbackmonkey.gamestates.Menu;
import psyche.breakbackmonkey.input.GameKeys;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Player extends GameObject
{
	
	public static final int UP = GameKeys.W;
	public static final int DOWN = GameKeys.S;
	public static final int LEFT = GameKeys.A;
	public static final int RIGHT = GameKeys.D;
	
	
	private float speed;
	public static final int SIZE = 8;
	private boolean[] input;
	
	private SaveData save_data;
	private Stats stats;
	private Inventory inventory;
	
	
	public Player()
	{
		super(null, 0, 0 );
	}
	

	@Override
	public void update(float dt) 
	{
		
		
		if(input[UP])
		{
			y += speed * dt;
		}
		if(input[LEFT])
		{
			x -= speed * dt;
		}
		if(input[RIGHT])
		{
			x += speed * dt;
		}
		if(input[DOWN])
		{
			y -= speed * dt;
		}
		setPosition();
	}
	
	

	@Override
	public void render() 
	{
		// TODO add a sprite 
		sr.setProjectionMatrix(camera.combined);
		sr.begin(ShapeType.Filled);
		sr.setColor(colour);
		sr.rect(x, y, rect.getWidth(), rect.getHeight());
		sr.end();
	}
	
	private void setPosition()
	{
		rect.x = x;
		rect.y = y;
		rect.width = SIZE;
		rect.height = SIZE;
	}

	
	@Override
	public void dispose() 
	{
		
	}

	
	public void init(GameState state, Stats stats, Inventory inventory, float x, float y) 
	{	
		this.state = state;
		this.stats = stats;
		this.inventory = inventory;
		save_data = new SaveData();
		input = new boolean[GameKeys.NUM_KEYS];
		speed = 100;
		colour = new Color(1, 1, 1, 1);		
	}
	
	public void up(boolean b) {	input[GameKeys.W] = b;	}
	public void down(boolean b) { input[GameKeys.S] = b; }
	public void left(boolean b) { input[GameKeys.A] = b; }
	public void right(boolean b) { input[GameKeys.D] = b; }
	
	
	public Stats getStats() { return stats; }
	public SaveData getSaveData() 
	{ 
		save_data.setStats(stats);
		save_data.setInventory(inventory);
		return save_data; 
	
	}
	public Inventory getInventory() { return inventory; }
}
