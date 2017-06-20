import java.awt.*;
import javax.swing.*;

//Variante mit Array
public class Ampel extends JFrame implements Runnable 
{
	private Ampelphase[] phasen;
	private Ampelphase aktuellePhase;
	private Thread thread;
	
	public Ampel() 
	{
		this.setTitle("Ampel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200, 300);
		this.setVisible(true);
		init();
		
		if (thread == null)
		{
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public void init() 
	{
		phasen = new Ampelphase[4];
		phasen[3] = new Ampelphase("Rotgelb", true, true, false, 1);
		phasen[2] = new Ampelphase("Rot", true, false, false, 10, phasen[3]);
		phasen[1] = new Ampelphase("Gelb", false, true, false, 2, phasen[2]);
		phasen[0] = new Ampelphase("Grün", false, false, true, 10, phasen[1]);
		phasen[3].setNext(phasen[0]);
		aktuellePhase = phasen[0];
	}
	
	@Override
	public void run() 
	{
		while (true) 
		{
			try 
			{
				this.repaint();
				Thread.sleep(aktuellePhase.getDuration() * 500);
				aktuellePhase = aktuellePhase.getNext();
			} 
			catch (InterruptedException ex)
			{
			}
		}
	}
	
	@Override
	public void paint(Graphics g) 
	{
		// Verschiebung der linken oberen Ecke der Ampel gegenüber dem
		// Punkt (10,0)
		int dx = 50, dy = 50;
		g.clearRect(0, 0, 200, 300);
		g.setColor(Color.BLACK);
		g.fillRect(dx + 10, dy + 10, 80, 195);
		g.setColor(Color.WHITE);
		g.fillOval(dx + 23, dy + 23, 54, 54);
		g.fillOval(dx + 23, dy + 83, 54, 54);
		g.fillOval(dx + 23, dy + 143, 54, 54);
		g.setColor(Color.RED);
		
		if (aktuellePhase.isRed()) 
		{
			g.fillOval(dx + 25, dy + 25, 50, 50);
		}
		
		g.setColor(Color.YELLOW);
		
		if (aktuellePhase.isYellow()) 
		{
			g.fillOval(dx + 25, dy + 85, 50, 50);
		}
		
		g.setColor(Color.GREEN);
		
		if (aktuellePhase.isGreen()) 
		{
			g.fillOval(dx + 25, dy + 145, 50, 50);
		}
	}
	
	public static void main(String[] args) 
	{
		new Ampel();
	}
}

//Variante mit Enum
/*
public class Ampel extends JFrame implements Runnable 
{
	private int state = 0;
	private Thread thread;
	
	public Ampel() 
	{
		this.setTitle("Ampel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200, 300);
		this.setVisible(true);
		
		if (thread == null)
		{
			thread = new Thread(this);
			thread.start();
		}
	}
	
	@Override
	public void run() 
	{
		while (true) 
		{
			try
			{
				state = (++state) % Ampelphase.values().length;
				this.repaint();
				Thread.sleep(Ampelphase.values()[state].getDuration() * 500);
			}
			catch (InterruptedException ex) 
			{
			}
		}
	}
	
	@Override
	public void paint(Graphics g) 
	{
		Ampelphase a = Ampelphase.values()[state];
		// Verschiebung der linken oberen Ecke der Ampel gegenüber dem Punkt (10,0)
		int dx = 50, dy = 50;
		g.clearRect(0, 0, 200, 300);
		g.setColor(Color.BLACK);
		g.fillRect(dx + 10, dy + 10, 80, 195);
		g.setColor(Color.WHITE);
		g.fillOval(dx + 23, dy + 23, 54, 54);
		g.fillOval(dx + 23, dy + 83, 54, 54);
		g.fillOval(dx + 23, dy + 143, 54, 54);
		g.setColor(Color.RED);
		
		if (a.isRed())
			g.fillOval(dx + 25, dy + 25, 50, 50);
		
		g.setColor(Color.YELLOW);
		
		if (a.isYellow())
			g.fillOval(dx + 25, dy + 85, 50, 50);
		
		g.setColor(Color.GREEN);
		
		if (a.isGreen())
			g.fillOval(dx + 25, dy + 145, 50, 50);
	}
		
	public static void main(String[] args) 
	{
		new Ampel();
	}
}
	*/