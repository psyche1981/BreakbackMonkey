package psyche.breakbackmonkey.managers;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.states.mainstates.MainState;
import psyche.breakbackmonkey.states.mainstates.MenuState;
import psyche.breakbackmonkey.states.mainstates.PauseState;
import psyche.breakbackmonkey.states.mainstates.PlayState;
import psyche.breakbackmonkey.states.playstates.BBackRoom;
import psyche.breakbackmonkey.states.playstates.Laboratory;
import psyche.breakbackmonkey.states.playstates.MiniGames;
import psyche.breakbackmonkey.states.playstates.ProcessOffice;
import psyche.breakbackmonkey.states.playstates.UHTDept;
import psyche.breakbackmonkey.states.playstates.UHTOffice;
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
	
	
	private Vars.State state;
	private Stack<MainState> current_state;
	
	public GameStateManager()
	{
		current_state = new Stack<MainState>();
		state = Vars.State.MENU;
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
		MainState s = current_state.pop();
		s.dispose();
	}
	
	private MainState getState(int state)
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
		
	public MainState getCurrentState() {return current_state.peek();}
}
