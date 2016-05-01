package psyche.breakbackmonkey;
//TODO if numpack > max packs move v slowly and cant go through doors and message to drop  packs appears
public class Stats 
{
	private int energy;
	private int xp;
	private int num_packs;
	private int bal_tank_vol;
	
	
	public Stats()
	{
		energy = 50;
		xp = 0;
		bal_tank_vol = 0;
	}
	
	public void setEnergy(int i) { energy += i; }
	public int getEnergy() { return energy; }
	
	public int getXP() { return xp; }
	public void setXP(int i) { xp += i; }
	
	public void setPacks(int i) 
	{ 
		if(i == 0)
			num_packs = 0;
		else
		num_packs += i; 
	}
	public int getPacks() { return num_packs; }
	
	public void setBalTankVol(int i) { bal_tank_vol += i; }
	public int getBalTankVol() { return bal_tank_vol; }

}
