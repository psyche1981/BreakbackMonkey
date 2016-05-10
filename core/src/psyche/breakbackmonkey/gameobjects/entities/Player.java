package psyche.breakbackmonkey.gameobjects.entities;

import psyche.breakbackmonkey.Inventory;
import psyche.breakbackmonkey.Stats;
import psyche.breakbackmonkey.gameobjects.inanimate.HUD;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.states.State;
import psyche.breakbackmonkey.states.playstates.PlayState;
import psyche.breakbackmonkey.utils.Camera;
import psyche.breakbackmonkey.utils.Res;
import psyche.breakbackmonkey.utils.Vars;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player
{
	
	public static final int UP = GameKeys.W;
	public static final int DOWN = GameKeys.S;
	public static final int LEFT = GameKeys.A;
	public static final int RIGHT = GameKeys.D;
	
	private static State state;
	private static float x, y, speed;
	private static boolean[] input;
	
	public static Rectangle rect;	
	public static Stats stats;
	public static Inventory inventory;
	
	private static HUD hud;
	
	
	public Player(State state)
	{
		Player.state = state;
		rect = new Rectangle();
		init();		
	}
	

	
	public static void update(float dt) 
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
	
	public static void render(SpriteBatch sb) 
	{
		sb.setProjectionMatrix(Camera.viewport.combined);
		sb.begin();
		sb.draw(Res.textures.get("white"),x, y, rect.getWidth(), rect.getHeight());
		sb.end();
		
		hud.render(sb);
	}
	
	private static void setPosition()
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

	
	public static void dispose() 
	{
		hud.dispose();
		System.out.println("player disposed");
	}

	public static void init()
	{
		input = new boolean[GameKeys.NUM_KEYS];
		speed = 100;	
		stats = new Stats();
		inventory = new Inventory();
		hud = new HUD(state);
	}
	
	public static void init(PlayState state, float x, float y) 
	{	
		Player.state = state;
		Player.x = x;
		Player.y = y;		
	}
	
	public void up(boolean b) {	input[GameKeys.W] = b;	}
	public void down(boolean b) { input[GameKeys.S] = b; }
	public void left(boolean b) { input[GameKeys.A] = b; }
	public void right(boolean b) { input[GameKeys.D] = b; }
	
	
	public Stats getStats() { return stats; }
	
	public Inventory getInventory() { return inventory; }
}
