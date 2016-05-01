package psyche.breakbackmonkey;

public class SaveData 
{
	private Stats stats;
	private Inventory inventory;
	
	
	public SaveData()
	{}
	
	public Stats getStats() {return stats; }
	public void setStats(Stats stats) { this.stats = stats;}
	
	public Inventory getInventory() { return inventory; }
	public void setInventory(Inventory inventory) { this.inventory = inventory; }
}
