package psyche.breakbackmonkey.states.mainstates;

import psyche.breakbackmonkey.managers.MainStateManager;
import psyche.breakbackmonkey.states.State;

public abstract class MainState extends State
{		
	public MainState(MainStateManager msm)
	{
		super(msm);		
		init();
	}	
		
	
}
