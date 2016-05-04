package psyche.breakbackmonkey;

import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.input.GameInputProcessor;
import psyche.breakbackmonkey.input.GameKeys;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Game extends ApplicationAdapter 
{
	public static final String TITLE = "Break Back Monkey";
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final int SCALE = 2;
	
	public static final float STEP = 1/60f;
	private float accumulated_time = 0;
		
	public static Player player;
	private OrthographicCamera camera;
	private GameStateManager gsm;
	
	@Override
	public void create () 
	{
		Res.load();		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);
		Gdx.input.setInputProcessor(new GameInputProcessor());
		
		gsm = new GameStateManager(this);
		player = new Player(gsm.getCurrentState());
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
	
	@Override
	public void dispose() 
	{
		super.dispose();
		Res.sb.dispose();
		Res.sr.dispose();
	}
	
	public OrthographicCamera getCamera() { return camera; }
	
}
