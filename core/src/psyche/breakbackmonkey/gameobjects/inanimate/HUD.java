package psyche.breakbackmonkey.gameobjects.inanimate;

import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.entities.Player;
import psyche.breakbackmonkey.gamestates.GameState;
import psyche.breakbackmonkey.utils.Fonts;
import psyche.breakbackmonkey.utils.Res;
import psyche.breakbackmonkey.utils.Vars;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HUD extends GameObject
{
	private int num_packs;
	private int xp;
	private String info_string = "Collect those packs";
	
	public HUD(GameState state)
	{
		super(state, 0, 0);
		rect.x = this.x;
		rect.y = this.y;
		rect.width = Vars.WIDTH;
		rect.height = Vars.HUD_HEIGHT;		
	}
		
	@Override
	public void update(float dt) 
	{
		num_packs = Player.stats.getPacks();
		xp = Player.stats.getXP();
		if(Player.inventory.getMaxPacks() < num_packs)
		{
			info_string = "Too many packs";
		}
		
	}

	@Override
	public void render(SpriteBatch sb) 
	{		
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw(Res.textures.get("hud"), x, y, rect.getWidth(), rect.getHeight());
		
		Fonts.timeless_12.draw(sb,  "Packs: " + num_packs, 5, Vars.HUD_HEIGHT - 7);
		Fonts.timeless_12.draw(sb,  "XP: " + xp, 5, Vars.HUD_HEIGHT - 17);
		Fonts.timeless_12.draw(sb,  "Info: " + info_string, 60, Vars.HUD_HEIGHT - 7);
		sb.end();
		
	}

	@Override
	public void dispose() 
	{
				
	}

	@Override
	public void init() 
	{
				
	}
}
