package psyche.breakbackmonkey.gamestates.playstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.GameStateManager;
import psyche.breakbackmonkey.gamestates.GameState;

public class MiniGames extends GameState
{
	public MiniGames(GameStateManager gsm)
	{
		super(gsm);
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		
	}

	@Override
	public void update(float dt) 
	{
		handleInput();
	}

	@Override
	public void handleInput() 
	{
		//TODO uncomment when player added
		//playerDirections();
		
	}

	@Override
	public void dispose() 
	{
		//TODO uncomment when player added
		//gsm.setSaveData(player.getSaveData());
	}

	@Override
	public void init() 
	{
		
		
	}
}
