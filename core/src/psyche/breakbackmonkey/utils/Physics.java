package psyche.breakbackmonkey.utils;

import psyche.breakbackmonkey.gameobjects.GameObject;
import psyche.breakbackmonkey.gameobjects.entities.Player;

public class Physics 
{
	public static GameObject collided(GameObject go)
	{
		if(go != null)
		{
			if(go.getRect().overlaps((Player.rect)))
				return go;
		}		
		return null;		
	}
}
