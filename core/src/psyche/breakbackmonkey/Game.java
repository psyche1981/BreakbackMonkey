package psyche.breakbackmonkey;

import psyche.breakbackmonkey.input.GameInputProcessor;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.managers.MainStateManager;
import psyche.breakbackmonkey.utils.Benchmark;
import psyche.breakbackmonkey.utils.Camera;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Res;
import psyche.breakbackmonkey.utils.Vars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Game extends ApplicationAdapter 
{
	private MainStateManager msm;
	
	private float accumulated_time = 0;	
	private Benchmark timer;
	
	@Override
	public void create () 
	{
		Res.load();	
		Fonts.load();
		Camera.load();
		timer = new Benchmark();
		timer.start();
		
		Gdx.input.setInputProcessor(new GameInputProcessor());		
		msm = new MainStateManager();
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
			msm.update(Vars.STEP);			
			GameKeys.update();
		}
		msm.render(Res.sb);
	}
	
	@Override
	public void dispose() 
	{
		super.dispose();
		Res.dispose();
		Fonts.dispose();
		timer.stop();
		System.out.println("Elapsed Time: " + timer.elapsedTime("seconds") + " s");
		System.out.println("Elapsed Time: " + timer.elapsedTime("milliseconds") + " ms");
		System.out.println("Elapsed Time: " + timer.elapsedTime() + " ms");
		System.out.println("Elapsed Time: " + timer.elapsedTime("nanoseconds") + " ns");
	}
	
	
}
