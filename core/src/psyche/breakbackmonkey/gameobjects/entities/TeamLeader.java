package psyche.breakbackmonkey.gameobjects.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.states.playstates.PlayState;
import psyche.breakbackmonkey.utils.Res;

public class TeamLeader extends GameObject
{
	public static final int GW = 0;
	public static final int DA = 1;
	public static final int SIZE = 8;
	private int who = -1;
	private int speed;
	
	
	public TeamLeader(PlayState state, int who, float x, float y)
	{
		super(state, x, y);
		this.who = who;
		//if want "speedy" to move initialise his here
//		if(who == DA)
//			speed = 25;
		
	}
	
	public TeamLeader() {}
	
	private void setPosition()
	{
		if(who == GW)
		{
			rect.x = x;
			rect.y = y;
			rect.width = SIZE;
			rect.height = SIZE;
		}
		else if(who == DA)
		{
			rect.x = x;
			rect.y = y;
			rect.width = SIZE * 2;
			rect.height = SIZE * 2;
		}
		
	}

	@Override
	public void update(float dt) 
	{
		// TODO add to temp code, maybe get him to follow you if he sees you
		
		
		if(who == GW)
		{
			x += speed * dt;
			if(x >= 250 || x <= 150)
				speed *= -1;
		}
		
		setPosition();
		
		
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw(Res.textures.get("yellow"), x, y, rect.getWidth(), rect.getHeight());
		sb.end();
	}

	@Override
	public void dispose() 
	{
		
	}

	@Override
	public void init() 	
	{
		colour = new Color(1, 1, 0, 1);
		speed = 50;
		
	}
	
	public int getWho() { return who; }
}
