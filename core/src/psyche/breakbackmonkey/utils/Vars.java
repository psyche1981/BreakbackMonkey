package psyche.breakbackmonkey.utils;

public class Vars 
{
	// Config variables	
	public static final String TITLE = "Break Back Monkey";
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;	
	public static final float STEP = 1/60f;
	
	//Player Variables
	public static final int PLAYER_SIZE = 8;
	
	
	//HUD Variables
	public static final int HUD_HEIGHT = 75;
	
	
	//State enumerations
	public static enum State
	{	
		//main states
		MENU,
		PLAY,
		PAUSE,
		TEST_STATE,
		
		//play states
		FACTORY,
		UHT_OFFICE,
		BREAK_BACK_ROOM,
		LAB,
		PROCESS_OFFICE,
		MINI_GAMES
		
	}
	
	
	
	
}
