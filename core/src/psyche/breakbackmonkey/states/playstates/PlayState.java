package psyche.breakbackmonkey.states.playstates;

import psyche.breakbackmonkey.managers.MainStateManager;
import psyche.breakbackmonkey.managers.PlayStateManager;
import psyche.breakbackmonkey.states.State;

public abstract class PlayState extends State
{
	private MainStateManager msm;
	
	public PlayState(MainStateManager msm, PlayStateManager psm)
	{		
		super(psm);
		this.msm = msm;
	}

}
