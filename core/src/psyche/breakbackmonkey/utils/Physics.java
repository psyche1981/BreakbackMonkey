package psyche.breakbackmonkey.utils;

import psyche.breakbackmonkey.gameobjects.GameObject;

public class Physics 
{
	public static GameObject collided(GameObject go1, GameObject go2)
	{
		if(go2 != null)
		{
			if(go1.getRect().overlaps((go2.getRect())))
				return go2;
		}		
		return null;		
	}
}
