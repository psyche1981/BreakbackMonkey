package psyche.breakbackmonkey;

import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.input.GameInputProcessor;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.utils.Camera;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Res;
import psyche.breakbackmonkey.utils.Vars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Game extends ApplicationAdapter 
{
	public static Player player;
	
	private GameStateManager gsm;
	
	private float accumulated_time = 0;	
	
	@Override
	public void create () 
	{
		Res.load();	
		Fonts.load();
		Camera.load();
		
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
		gsm.render(Res.sb);
	}
	
	@Override
	public void dispose() 
	{
		super.dispose();
		Res.dispose();
		Fonts.dispose();
	}
	
	
}
