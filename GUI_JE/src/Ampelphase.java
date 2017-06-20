//Variante mit Array
public class Ampelphase 
{
	private String name;
	private boolean red;
	private boolean yellow;
	private boolean green;
	private int duration;
	private Ampelphase next;
	
	public Ampelphase(String name, boolean red, boolean yellow, boolean green, int duration, Ampelphase next) 
	{
		this.name = name;
		this.red = red;
		this.yellow = yellow;
		this.green = green;
		this.duration = duration;
		this.next = next;
	}
	//					rotgelb		true			true			false			1
	public Ampelphase(String name, boolean red, boolean yellow, boolean green, int duration) 
	{
		this.name = name;
		this.red = red;
		this.yellow = yellow;
		this.green = green;
		this.duration = duration;
		this.next = null;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public boolean isRed() 
	{
		return red;
	}
	
	public void setRed(boolean red) 
	{
		this.red = red;
	}
	
	public boolean isYellow() 
	{
		return yellow;
	}
	
	public void setYellow(boolean yellow) 
	{
		this.yellow = yellow;
	}
	
	public boolean isGreen() 
	{
		return green;
	}
	
	public void setGreen(boolean green) 
	{
		this.green = green;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
	public void setDuration(int duration)
	{
		this.duration = duration;
	}
	
	public Ampelphase getNext() 
	{
		return next;
	}
	
	public void setNext(Ampelphase next)
	{
		this.next = next;
	}
}

//Variante mit Enum
/*
public enum Ampelphase 
{
	GRUEN("Grün",false,false,true,10),
	GELB("Gelb",false,true,false,2),
	ROT("Rot",true,false,false,10),
	GELBROT("Gelbrot",true,true,false,1);
	
	private String name;
	private boolean red;
	private boolean yellow;
	private boolean green;
	private int duration;
	
	Ampelphase(String name, boolean red, boolean yellow, boolean green, int duration) 
	{
		this.name=name;
		this.red=red;
		this.yellow=yellow;
		this.green=green;
		this.duration=duration;
	}
	
	public String getName() 
	{
		return name; 
	}
	
	public void setName(String name) 
	{ 
		this.name = name; 
	}
	public boolean isRed() 
	{ 
		return red; 
	}
	
	public void setRed(boolean red)
	{ 
		this.red = red; 
	}
	
	public boolean isYellow()
	{
		return yellow; 
	}
	
	public void setYellow(boolean yellow)
	{ 
		this.yellow = yellow;
	}
	
	public boolean isGreen() 
	{
		return green;
	}
	
	public void setGreen(boolean green)
	{
		this.green = green;
	}
	
	public int getDuration()
	{ 
		return duration;
	}
	
	public void setDuration(int duration)
	{ 
		this.duration = duration; 
	}
}	
*/