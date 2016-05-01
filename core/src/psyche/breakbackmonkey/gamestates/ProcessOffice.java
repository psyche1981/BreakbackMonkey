package psyche.breakbackmonkey.gamestates;
// TODO add a player and see what else can be done in here (mini games hub)
import com.badlogic.gdx.math.Rectangle;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.GameStateManager;
import psyche.breakbackmonkey.Physics;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.gameobjects.inanimate.Door;
import psyche.breakbackmonkey.gameobjects.inanimate.Wall;
import psyche.breakbackmonkey.input.GameKeys;

public class ProcessOffice extends GameState
{
	private Door exit_door; 
	private Wall notice_board;
	
	
	public ProcessOffice(GameStateManager gsm)
	{
		super(gsm);
	}

	@Override
	public void render() 
	{
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		font.draw(sb, "Process Office", 0, 480);
		sb.end();
		
		for(GameObject go : objects)
		{
			go.render();
		}
		
		
	}

	@Override
	public void update(float dt) 
	{
		handleInput();
		
		for(GameObject go : objects)
		{
			go.update(dt);
			
			if(Physics.collided(player, go) == exit_door)
				gsm.setState(GameStateManager.PLAY);
			if(Physics.collided(player, go) == notice_board)
				gsm.setState(GameStateManager.PLAY);//change to new gamestate when created
			
		}
	}

	@Override
	public void handleInput() 
	{	
		playerDirections();
		if(GameKeys.isPressed(GameKeys.ESCAPE))
			gsm.setState(GameStateManager.PLAY);
		
		
	}

	@Override
	public void dispose() 
	{	
		gsm.setSaveData(player.getSaveData());
		
		for(GameObject go : objects)
		{
			go.dispose();
		}
	}

	@Override
	public void init() 
	{
		player = new Player(this, gsm.getStats(), gsm.getInventory(),  Game.WIDTH / 2 - Player.SIZE / 2, Door.DOOR_SHORT_SIDE +  (2 * Player.SIZE));
		objects.add(player);
		
		doors();
		walls();
	}
	
	private void doors()
	{
		exit_door = new Door(this, Game.WIDTH / 2 - Door.DOOR_LONG_SIDE / 2, 0, true);
		objects.add(exit_door);
		
		
	}
	
	private void walls()
	{
		notice_board = new Wall(this, 0, Game.HEIGHT - 10,Game.WIDTH , 10);
		objects.add(notice_board);
	}
}
