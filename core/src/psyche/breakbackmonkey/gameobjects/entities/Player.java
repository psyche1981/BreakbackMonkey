package psyche.breakbackmonkey.gameobjects.entities;

import psyche.breakbackmonkey.Inventory;
import psyche.breakbackmonkey.Stats;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.inanimate.HUD;
import psyche.breakbackmonkey.gamestates.GameState;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.utils.Res;
import psyche.breakbackmonkey.utils.Vars;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends GameObject
{
	
	public static final int UP = GameKeys.W;
	public static final int DOWN = GameKeys.S;
	public static final int LEFT = GameKeys.A;
	public static final int RIGHT = GameKeys.D;
	
	
	private float speed;
	private boolean[] input;
	
	public static Stats stats;
	public static Inventory inventory;
	
	private HUD hud;
	
	
	public Player(GameState state)
	{
		super(state, 0, 0);		
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
		
		hud.update(dt);
	}
	
	

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw(Res.textures.get("white"),x, y, rect.getWidth(), rect.getHeight());
		sb.end();
		
		hud.render(sb);
	}
	
	private void setPosition()
	{
		if(y > Vars.HEIGHT - Vars.PLAYER_SIZE)
			y = Vars.HEIGHT - Vars.PLAYER_SIZE;			
		if(y < Vars.HUD_HEIGHT)
			y = Vars.HUD_HEIGHT;
		if(x < 0)
			x = 0;
		if(x > Vars.WIDTH - Vars.PLAYER_SIZE)
			x = Vars.WIDTH - Vars.PLAYER_SIZE;
		
		rect.x = x;
		rect.y = y;
		rect.width = Vars.PLAYER_SIZE;
		rect.height = Vars.PLAYER_SIZE;
	}

	
	@Override
	public void dispose() 
	{
		hud.dispose();
	}

	@Override
	public void init()
	{
		input = new boolean[GameKeys.NUM_KEYS];
		speed = 100;	
		stats = new Stats();
		inventory = new Inventory();
		hud = new HUD(state);
	}
	
	public void init(GameState state, float x, float y) 
	{	
		this.state = state;
		this.x = x;
		this.y = y;		
	}
	
	public void up(boolean b) {	input[GameKeys.W] = b;	}
	public void down(boolean b) { input[GameKeys.S] = b; }
	public void left(boolean b) { input[GameKeys.A] = b; }
	public void right(boolean b) { input[GameKeys.D] = b; }
	
	
	public Stats getStats() { return stats; }
	
	public Inventory getInventory() { return inventory; }
}
