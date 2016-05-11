package psyche.breakbackmonkey.states.mainstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.managers.MainStateManager;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Res;
import psyche.breakbackmonkey.utils.Vars;

public class TestState extends MainState
{
	private Rectangle board_rect;
	private String[] letters = 
	{
		"a", "b", "c","d",
		"e","f","g","h","i","j","k","l","m","n",
		"o","p","q","r","s","t","u","v","w","x","y","z"
	};
	
	private int letter_counter = 0;
	private String word;
	private String[] guesses;
	private String[] correct_guesses;
	private int guess_counter = 0;

	public TestState(MainStateManager msm) 
	{
		super(msm);
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		Fonts.timeless_16.draw(sb, "Testing Arena", 10, Vars.HEIGHT - 10);
		
		//testing area
		sb.draw(Res.textures.get("blackboard"), board_rect.x, board_rect.y); 
		
		
		//the word
		
		for(int i = 0; i < word.length(); i++)
		{
			Fonts.timeless_16.draw(sb, "_", board_rect.x + 20 + i * 20, board_rect.y +100);
		}
		
		//guess
		for(int i = 0; i < guesses.length; i++)
		{
			Fonts.timeless_16.draw(sb, guesses[i], board_rect.x +300, board_rect.y + 250 - i * 25);
						
		}
		
		//alphabet
		for(int i = 0; i < letters.length; i++)
		{
			if(letter_counter == i)
			{
				Fonts.timeless_12.setColor(1, 0, 0, 1);				
			}
				
			Fonts.timeless_12.draw(sb,  letters[i], 20 + i * 20, 50);
			Fonts.timeless_12.setColor(1, 1, 1, 1);
		}
		
		
		
		
		sb.end();		
	}

	@Override
	public void update(float dt) 
	{
		handleInput();
		//testing area
		bindLetterCounter();
		limitGuessCounter();
	}

	@Override
	public void handleInput() 
	{
		if(GameKeys.isPressed(GameKeys.ESCAPE))
			sm.setState(Vars.State.MENU);
				
		//testing area
		if(GameKeys.isPressed(GameKeys.LEFT))
			letter_counter--;
		if(GameKeys.isPressed(GameKeys.RIGHT))
			letter_counter++;
		if(GameKeys.isPressed(GameKeys.SPACE))
		{
			guesses[guess_counter] = letters[letter_counter];
			guess_counter++;
		}
			
	}

	@Override
	public void dispose() 
	{
		
	}

	@Override
	public void init() 
	{
		board_rect = new Rectangle(100, 100, 400, 300);		
		word = "ball bag";
		guesses = new String[26];
		for(int i = 0; i < 26; i++)
		{
			guesses[i] = "";
		}
		//temp until implement the get unique letters function
		final int WORD_LENGTH = word.length();
		correct_guesses = new String[WORD_LENGTH];
		for(int i = 0; i < WORD_LENGTH; i++)
		{
			correct_guesses[i] = "";
		}
	}

	private void bindLetterCounter()
	{
		if(letter_counter < 0)
			letter_counter = letters.length - 1;
		if(letter_counter == letters.length)
			letter_counter = 0;
	}
	
	private void limitGuessCounter()
	{
		if(guess_counter == 26)
			guess_counter = 0;
	}

}
