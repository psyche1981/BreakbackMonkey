package psyche.breakbackmonkey.gameobjects.inanimate;

import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.gamestates.GameState;
import psyche.breakbackmonkey.utils.Camera;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Res;
import psyche.breakbackmonkey.utils.Vars;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class HUD
{
	private Rectangle rect;
	private int num_packs;
	private int xp;
	private String info_string = "Collect those packs";
	
	public HUD(GameState state)
	{		
		init();	
	}
	
	public void update(float dt) 
	{
		num_packs = Player.stats.getPacks();
		xp = Player.stats.getXP();
		if(Player.inventory.getMaxPacks() < num_packs)
		{
			info_string = "Too many packs";
		}
		
		if(Player.inventory.getLabKey())
		{
			info_string = "You have the lab key";
		}
		
	}

	
	public void render(SpriteBatch sb) 
	{		
		sb.setProjectionMatrix(Camera.viewport.combined);
		sb.begin();
		sb.draw(Res.textures.get("hud"), 0, 0, rect.getWidth(), rect.getHeight());
		
		Fonts.timeless_12.draw(sb,  "Packs: " + num_packs, 5, Vars.HUD_HEIGHT - 7);
		Fonts.timeless_12.draw(sb,  "XP: " + xp, 5, Vars.HUD_HEIGHT - 17);
		Fonts.timeless_12.draw(sb,  "Info: " + info_string, 60, Vars.HUD_HEIGHT - 7);
		sb.end();
		
	}

	
	public void dispose() 
	{
				
	}

	
	public void init() 
	{
		rect = new Rectangle(0, 0, Vars.WIDTH, Vars.HUD_HEIGHT);
	}
}
