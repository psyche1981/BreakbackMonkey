package psyche.breakbackmonkey.gamestates;

import psyche.breakbackmonkey.GameStateManager;

public class MiniGames extends GameState
{
	public MiniGames(GameStateManager gsm)
	{
		super(gsm);
	}

	@Override
	public void render() 
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
