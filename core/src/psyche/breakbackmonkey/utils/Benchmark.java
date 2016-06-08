package psyche.breakbackmonkey.utils;

public class Benchmark 
{
	private long start_time;
	private long end_time;
	
	public Benchmark()
	{
		start_time = 0;
		end_time = 0;
	}
	
	public void start()
	{
		start_time = System.nanoTime();
	}
	
	public void stop()
	{
		end_time = System.nanoTime();
	}
	
	public float elapsedTime(String units)
	{
		float time = end_time - start_time;
		if(units == "seconds")
			time /= 1000000000;
		else if(units == "milliseconds")
			time /= 1000000;
		else if(units == "nanoseconds")
			return time;
		else
			time /= 1000000;
	
		return time;
	}
	
	public float elapsedTime()
	{
		return elapsedTime("milliseconds");
	}
	
}
