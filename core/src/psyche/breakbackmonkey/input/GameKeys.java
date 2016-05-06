package psyche.breakbackmonkey.input;

public class GameKeys 
{
	public static final int NUM_KEYS = 10;
	public static final int W = 0;
	public static final int A = 1;
	public static final int S = 2;
	public static final int D = 3;
	public static final int SPACE = 4;
	public static final int ENTER = 5;
	public static final int Y = 6;
	public static final int N = 7;
	public static final int P = 8;
	public static final int ESCAPE = 9;
	
	public static boolean[] current_keys;
	public static boolean[] previous_keys;
	
	static
	{
		current_keys = new boolean[NUM_KEYS];
		previous_keys = new boolean[NUM_KEYS];
	}
	
	public static void update()
	{
		for(int i = 0; i < NUM_KEYS; i++)
		{
			previous_keys[i] = current_keys[i];
		}
	}
	
	public static void setKey(int k, boolean is_down)
	{
		current_keys[k] = is_down;
	}
	
	public static boolean isDown(int k)
	{
		return current_keys[k];
	}
	
	public static boolean isPressed(int k)
	{
		return current_keys[k] && !previous_keys[k];
	}
	
}
