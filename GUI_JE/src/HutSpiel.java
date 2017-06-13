import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

class HutSpiel extends JFrame
{
	int hut, tipp, versuche;
	int limit = 3;
	JButton h1, h2, h3, exit, stat;
	JPanel p1, p2, p3, p4;
	JTextField ein;
	JTextField aus;
	String ergfile = "huterg.txt";
	
	HutSpiel() 
	{
		versuche = 0;
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		h1 = new JButton("Huetchen 1");
		h2 = new JButton("Huetchen 2");
		h3 = new JButton("Huetchen 3");
		exit = new JButton("exit");
		stat = new JButton("Statistik");
		JLabel l = new JLabel("Spielername");		
		ein = new JTextField("Name", 20);
		aus = new JTextField(30);
		
		p1.add(l);
		p1.add(ein);
		p2.add(h1);
		p2.add(h2);
		p2.add(h3);
		p4.add(stat);
		p4.add(exit);
		p3.add(aus);
		setLayout(new GridLayout(4, 1));
		add(p1);
		add(p2);
		add(p4);
		add(p3);
		
		eventHandling();
		erzeugeHut();
		
		setTitle("Huetchenspiel");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void eventHandling() 
	{
		stat.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				statistik();
			}
		});
		
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		
		h1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				hutActionListener(1);
			}
		});
		
		h2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				hutActionListener(2);
			}
		});
		
		h3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				hutActionListener(3);
			}
		});
	}
	
	public void hutActionListener(int tip)
	{
		versuche++;
		
		if (tip == hut)
		{
			aus.setText("Versuch " + versuche
			+ " Gewonnen: Die Kugel war unter Hut " + hut);
			schreibeFile();
			erzeugeHut();
			versuche = 0;
		} 
		else 
		{
			aus.setText("Versuch " + versuche
			+ " Falsch: Die Kugel war unter Hut " + hut);
			erzeugeHut();
		}
	}
		
	private void statistik() 
	{
		try 
		{
			BufferedReader in = new BufferedReader(new FileReader(ergfile));
			String line;
			int anz = 0;
			float sum = 0;
			
			do 
			{
				try 
				{
					line = in.readLine();
					if (line != null)
					{
						StringTokenizer st = new StringTokenizer(line);
						st.nextToken();
						try 
						{
							sum += Integer.parseInt(st.nextToken());
							anz++;
						} 
						catch (Exception e) 
						{
						}
					}
				} 
				catch (IOException e)
				{
					line = null;
				}
			}while (line != null);
		
			in.close();
			aus.setText("Erfolg nach " + sum / anz + " Versuchen");
		} 
		catch (Exception eee)
		{
		}
	}
	
	private void schreibeFile() 
	{
		try
		{
			FileWriter f = new FileWriter(ergfile, true);
			String name = ein.getText();
			f.write(name + " " + versuche + " Versuche\n");
			f.close();
		}
		catch (Exception e) 
		{			
		}
	}
	
	private void erzeugeHut() 
	{
		hut = (int) (Math.random() * limit + 1);
	}
	
	public static void main(String args[])
	{
		new HutSpiel();
	}
}