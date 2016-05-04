package psyche.breakbackmonkey.gameobjects;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import psyche.breakbackmonkey.GameFlags;
import psyche.breakbackmonkey.utils.Res;
import psyche.breakbackmonkey.gamestates.GameState;

//import com.badlogic.gdx.graphics.g2d.SpriteBatch;//will pass sb in render but initially will use a shaperenderer in each objcet class

public abstract class GameObject 
{	
	protected float x;
	protected float y;
	protected GameState state;
	protected OrthographicCamera camera;
	protected ShapeRenderer sr;
	protected Color colour;
	protected Rectangle rect;
	protected boolean[] flags;
	
	public GameObject(GameState state, float x, float y)
	{
		this.x = x;
		this.y = y;
		this.state = state;
		camera = state.getCamera();
		sr = Res.sr;
		rect = new Rectangle();
		flags = new boolean[GameFlags.NUM_FLAGS];
		init();
	}
	
	public GameObject(){}
	
	public abstract void update(float dt);
	public abstract void render(SpriteBatch sb);
	public abstract void dispose();
	public void init(){}
	
	public Rectangle getRect() { return rect; }
	public boolean getSolid() { return flags[GameFlags.SOLID_FLAG]; }
	public boolean getLocked() { return flags[GameFlags.DOOR_LOCKED_FLAG]; }
	
	public void setLocked(boolean b) { flags[GameFlags.DOOR_LOCKED_FLAG] = b; }
	
	
}
