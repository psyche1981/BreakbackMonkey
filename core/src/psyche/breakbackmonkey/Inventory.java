package psyche.breakbackmonkey;

public class Inventory 
{
	private int recepticle = -1;
	public static final int HANDS = 0;
	public static final int BUCKET = 1;
	public static final int TROLLEY = 2;
	public static final int BIN = 3;
	private int max_packs;
	
	
	private boolean lab_key;
	
	public Inventory()
	{
		setRecepticle(HANDS);
		lab_key = false;
	}
	
	public int getRecepticle() { return recepticle; }
	public void setRecepticle(int i) 
	{ 
		recepticle = i;
		if(i == HANDS)
			max_packs = 5;
		else if(i == BUCKET)
			max_packs = 15;
		else if(i == TROLLEY)
			max_packs = 30;
		else if(i == BIN)
			max_packs = 50; 
	}
	
	public int getMaxPacks() { return max_packs; }
	
	public boolean getLabKey() { return lab_key; }
	public void setLabKey(boolean b) { lab_key = b; }
	
}
