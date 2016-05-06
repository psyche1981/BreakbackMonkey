package psyche.breakbackmonkey.states.playstates;

import java.util.ArrayList;
import java.util.Random;

import psyche.breakbackmonkey.Game;
import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.inanimate.Pack;
import psyche.breakbackmonkey.input.GameKeys;
import psyche.breakbackmonkey.managers.PlayStateManager;
import psyche.breakbackmonkey.states.State;
import psyche.breakbackmonkey.utils.Vars;

public abstract class PlayState extends State
{
	protected ArrayList<GameObject> objects;
	protected ArrayList<Pack> packs;
	protected ArrayList<Pack> packs_to_remove;
	
	public PlayState(PlayStateManager psm)
	{		
		super(psm);
		objects = new ArrayList<GameObject>();
		packs = new ArrayList<Pack>();
		packs_to_remove = new ArrayList<Pack>();
	}
	
	protected void initRandomPacks()
	{
		Random rand = new Random();
		int no_packs = rand.nextInt(5) + 1;
		for(int i = 1; i < no_packs + 1; i++)
		{
			packs.add(new Pack(this, rand.nextInt(Vars.WIDTH - Pack.SIZE)  , rand.nextInt(Vars.HEIGHT - Vars.HUD_HEIGHT - Pack.SIZE) + Vars.HUD_HEIGHT));
		}
		
	}
	
	protected void playerDirections()
	{
		Game.player.up(GameKeys.isDown(GameKeys.W));
		Game.player.left(GameKeys.isDown(GameKeys.A));
		Game.player.down(GameKeys.isDown(GameKeys.S));
		Game.player.right(GameKeys.isDown(GameKeys.D));
	}

}
