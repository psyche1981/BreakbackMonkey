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
		sb.draw(Res.textures.get("blackboard"), board_rect.x, board_rect.y);
		
		//testing area
		
		int word_length = word.length();
		for(int i = 0; i < word_length; i++)
		{
			Fonts.timeless_16.draw(sb, "_", board_rect.x + 20 + i * 20, board_rect.y +100);
		}
		
		
		
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
	}

	private void bindLetterCounter()
	{
		if(letter_counter < 0)
			letter_counter = letters.length - 1;
		if(letter_counter == letters.length)
			letter_counter = 0;
	}

}
