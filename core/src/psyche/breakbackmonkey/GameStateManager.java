package psyche.breakbackmonkey;

import java.util.Stack;

import psyche.breakbackmonkey.gamestates.BBackRoom;
import psyche.breakbackmonkey.gamestates.GameState;
import psyche.breakbackmonkey.gamestates.Laboratory;
import psyche.breakbackmonkey.gamestates.Menu;
import psyche.breakbackmonkey.gamestates.MiniGames;
import psyche.breakbackmonkey.gamestates.Play;
import psyche.breakbackmonkey.gamestates.ProcessOffice;
import psyche.breakbackmonkey.gamestates.UHTDept;
import psyche.breakbackmonkey.gamestates.UHTOffice;

public class GameStateManager 
{
	public static final int PLAY = 0;
	public static final int MENU = 1;
	public static final int UHT_OFFICE = 2;
	public static final int PROCESS_OFFICE = 3;
	public static final int UHT_DEPT = 4;
	public static final int BREAK_BACK = 5;
	public static final int LAB = 6;
	public static final int MINI_GAMES = 7;
	
	
	private SaveData save_data;
	
	private Game game;
	private Stack<GameState> current_state;
	
	public GameStateManager(Game game)
	{
		this.game = game;
		save_data = new SaveData();
		current_state = new Stack<GameState>();
		push(MENU);
	}
	
	public void setState(int state)
	{
		pop();
		push(state);
	}
	
	public void render()
	{
		current_state.peek().render();
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
		if(state == PLAY) return new Play(this);
		if(state == MENU) return new Menu(this);
		if(state == UHT_OFFICE) return new UHTOffice(this);
		if(state == PROCESS_OFFICE) return new ProcessOffice(this);
		if(state == UHT_DEPT) return new UHTDept(this);
		if(state == BREAK_BACK) return new BBackRoom(this);
		if(state == LAB) return new Laboratory(this);
		if(state == MINI_GAMES) return new MiniGames(this);
		
		return null;
	}
	
	public Game getGame() { return game; }
	public void setSaveData(SaveData sd) { save_data = sd; }
	public SaveData getSaveData() { return save_data; }
	public GameState getCurrentState() {return current_state.peek();}
}
