import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.sql.SQLException;

public class Ratespiel extends JFrame 
{
	private JPanel contentPane;
	private JTextField txtSpieler;
	private JLabel lblZahlZwischen;
	private JTextField txtZahl;
	private JButton btnNeuesSpiel;
	private JButton btnOk;
	private JButton btnBester;
	private JButton btnExit;
	private JTextField txtAus;
	private Path file;
	private String name;
	private double rand;
	int i;	

	public static void main(String[] args) 
	{
		Ratespiel frame = new Ratespiel();
		frame.setVisible(true);				
	}

	public Ratespiel()
	{
		i = 1;
		erzDatei();
		setTitle("Ratespiel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSpielername = new JLabel("Spielername:");
		lblSpielername.setBounds(10, 11, 109, 14);
		contentPane.add(lblSpielername);
		
		txtSpieler = new JTextField();
		txtSpieler.addKeyListener(new KeyAdapter() 
		{
			public void keyTyped(KeyEvent e) 
			{
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					name = txtSpieler.getText();
		        }				
			}
		});
		txtSpieler.setBounds(93, 8, 291, 20);
		contentPane.add(txtSpieler);
		txtSpieler.setColumns(10);
		
		lblZahlZwischen = new JLabel("Zahl zwischen 1 und 1000 eingeben:");
		lblZahlZwischen.setBounds(10, 36, 231, 14);
		contentPane.add(lblZahlZwischen);
		
		txtZahl = new JTextField();
		txtZahl.setBounds(219, 33, 165, 20);
		contentPane.add(txtZahl);
		txtZahl.setColumns(10);
		
		btnNeuesSpiel = new JButton("Neues Spiel");
		btnNeuesSpiel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				rand = (int)((Math.random() * 1000) + 1) ;
				System.out.println(rand);
			}
		});
		btnNeuesSpiel.setBounds(10, 61, 109, 23);
		contentPane.add(btnNeuesSpiel);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() 
		{
				
			public void actionPerformed(ActionEvent arg0) 
			{						
				Integer zahl = Integer.parseInt(txtZahl.getText());
				
				if(zahl == rand)
				{
					txtAus.setText("Versuch Nr. " + i + ", " + zahl + " ist korrekt.");
					txtZahl.setText("");
					datenInDatei();
					i = 1;
				}
				else
				{
					if(zahl < rand)
					{
						txtAus.setText("Versuch Nr. " + i + ", " + zahl + " ist zu niedrig.");
						txtZahl.setText("");
					}
					else
					{
						txtAus.setText("Versuch Nr. " + i + ", " + zahl + " ist zu hoch.");
						txtZahl.setText("");
					}
				}
				i++;
			}
		});
		btnOk.setBounds(129, 61, 55, 23);
		contentPane.add(btnOk);
		
		btnBester = new JButton("Bester");
		btnBester.setBounds(196, 61, 89, 23);
		contentPane.add(btnBester);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnExit.setBounds(295, 61, 89, 23);
		contentPane.add(btnExit);
		
		txtAus = new JTextField();
		txtAus.setBounds(10, 95, 374, 20);
		contentPane.add(txtAus);
		txtAus.setColumns(10);
	}
	
	private void erzDatei()
	{
		file = Paths.get("C:\\java8\\uebungen\\Ratespiel.txt");		

		if (Files.notExists(file))
		{
			try
			{
				Files.createDirectories(file.getParent());
				Files.createFile(file);					
			} 
			catch (IOException ex) 
			{
 			   System.err.println(ex);
			}
		}		
	}
	
	private void datenInDatei()
	{
		String s = null;		
		byte[] bArray = new byte[1];		
				
		ByteBuffer persBuff = ByteBuffer.allocate(100);		
		
		try(FileChannel fc = (FileChannel.open(file, WRITE)))
		{
			//Hier Code zur Positionierung eingeben
			
			s = txtSpieler.getText() + ", " + i + "\r\n";
				bArray = s.getBytes();
				persBuff = ByteBuffer.wrap(bArray);
				fc.write(persBuff);								
			
		}
		catch(IOException ex)
		{
			System.out.println("I/O Exception: " + ex);
		}
	}
}
