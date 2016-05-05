package psyche.breakbackmonkey;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.gamestates.playstates.BBackRoom;
import psyche.breakbackmonkey.gamestates.GameState;
import psyche.breakbackmonkey.gamestates.PauseState;
import psyche.breakbackmonkey.gamestates.playstates.Laboratory;
import psyche.breakbackmonkey.gamestates.MenuState;
import psyche.breakbackmonkey.gamestates.playstates.MiniGames;
import psyche.breakbackmonkey.gamestates.PlayState;
import psyche.breakbackmonkey.gamestates.playstates.ProcessOffice;
import psyche.breakbackmonkey.gamestates.playstates.UHTDept;
import psyche.breakbackmonkey.gamestates.playstates.UHTOffice;
import psyche.breakbackmonkey.managers.PlayStateManager;
import psyche.breakbackmonkey.utils.Vars;

public class GameStateManager 
{
	public static final int PLAY = 0;
	public static final int MENU = 1;
	public static final int PAUSE = 8;
	
	
	public static final int UHT_OFFICE = 2;
	public static final int PROCESS_OFFICE = 3;
	public static final int UHT_DEPT = 4;
	public static final int BREAK_BACK = 5;
	public static final int LAB = 6;
	public static final int MINI_GAMES = 7;
	
	private PlayStateManager psm;
	
	private Vars.GameStates state;
	private Game game;
	private Stack<GameState> current_state;
	
	public GameStateManager(Game game)
	{
		this.game = game;
		psm = new PlayStateManager();
		current_state = new Stack<GameState>();
		state = Vars.GameStates.MENU;
		push(MENU);
	}
	
	public void enterState(int state)
	{
		push(state);
	}
	
	public void exitState()
	{
		pop();
	}
	
	public void setState(int state)
	{
		pop();
		push(state);
	}
	
	public void render(SpriteBatch sb)
	{
		current_state.peek().render(sb);
	}
	
	public void update(float dt)
	{
		current_state.peek().update(dt);
	}
	
	private void push(int state)
	{
		current_state.push(getState(state));
	}
	
	private void pop()
	{
		GameState s = current_state.pop();
		s.dispose();
	}
	
	private GameState getState(int state)
	{
		if(state == PLAY) return new PlayState(this);
		if(state == MENU) return new MenuState(this);
		if(state == PAUSE) return new PauseState(this);
		if(state == UHT_OFFICE) return new UHTOffice(this);
		if(state == PROCESS_OFFICE) return new ProcessOffice(this);
		if(state == UHT_DEPT) return new UHTDept(this);
		if(state == BREAK_BACK) return new BBackRoom(this);
		if(state == LAB) return new Laboratory(this);
		if(state == MINI_GAMES) return new MiniGames(this);
		
		return null;
	}
	
	public Game getGame() { return game; }
	public GameState getCurrentState() {return current_state.peek();}
}
