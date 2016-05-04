package psyche.breakbackmonkey;

import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.input.GameInputProcessor;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.utils.Res;
import psyche.breakbackmonkey.utils.Vars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Game extends ApplicationAdapter 
{
	
	private float accumulated_time = 0;
		
	public static Player player;
	private OrthographicCamera camera;
	private GameStateManager gsm;
	
	@Override
	public void create () 
	{
		Res.load();		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Vars.WIDTH, Vars.HEIGHT);
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
		
		while(accumulated_time >= Vars.STEP)
		{
			accumulated_time -= Vars.STEP;
			gsm.update(Vars.STEP);			
			GameKeys.update();
		}
		gsm.render();
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
