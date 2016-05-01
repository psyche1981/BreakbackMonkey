package psyche.breakbackmonkey;

import psyche.breakbackmonkey.input.GameInputProcessor;
import psyche.breakbackmonkey.input.GameKeys;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter 
{
	public static final String TITLE = "Break Back Monkey";
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final int SCALE = 2;
	
	public static final float STEP = 1/60f;
	private float accumulated_time = 0;
	
	private SpriteBatch sb;
	private OrthographicCamera camera;
	private GameStateManager gsm;
	
	@Override
	public void create () 
	{
		sb = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);
		Gdx.input.setInputProcessor(new GameInputProcessor());
		
		gsm = new GameStateManager(this);
	}

	@Override
	public void render () 
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		accumulated_time += Gdx.graphics.getDeltaTime();
		
		while(accumulated_time >= STEP)
		{
			accumulated_time -= STEP;
			gsm.update(STEP);
			gsm.render();
			GameKeys.update();
		}		
	}
	
	public OrthographicCamera getCamera() { return camera; }
	public SpriteBatch getSB() { return sb; }
	
}
