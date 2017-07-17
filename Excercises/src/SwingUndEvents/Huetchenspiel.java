package SwingUndEvents;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Huetchenspiel extends JFrame implements ActionListener {
		
	private JFrame frame;
	
	private Container contentPane;
	
	private JLabel playerName;
	private JTextField nameInput;
	
	private JButton coneOne;
	private JButton coneTwo;
	private JButton coneThree;
	
	private JButton statistics;
	private JButton dispose;
	
	private JTextField event;
	
	private static int randomNumber;
	private static int counter;
	private static Random rd;
	
	public static int getRandomNumber() {
		
		return randomNumber;
	}

	public static void setRandomNumber( ) {
		
		randomNumber = erzeugeZufallszahl( );
	}
	
	public static int getCounter() {
		
		return counter;
	}

	public static void resetCounter( ) {
		
		counter = 0;
	}
	
	public static void incrementCounter ( ) {
		
		counter++;
	}
	
	private static int erzeugeZufallszahl( ) {
		
		rd = new Random( );
		int zufallszahl = rd.nextInt( 3 ) + 1;
		System.out.println( zufallszahl );
		return zufallszahl;		
	}
	
	public void writeInFile( ) {
		
		try ( PrintWriter pw = new PrintWriter( new BufferedWriter( new FileWriter( "winner.txt", true ) ) ) ) {
			
			pw.println( nameInput.getText( ) + " - " + String.valueOf( getCounter( ) ) );
		} catch ( IOException e ) {
			
			System.err.println( e.toString( ) );
		}
	}
	public void readOutOfFile( ) {
		
		try (BufferedReader br = new BufferedReader( new FileReader( "winner.txt" ) ) ) {
			
			String inputString;
			char wanted = '-';
			int counter = 0;
			double score = 0.0;
			
			while ( ( inputString = br.readLine( ) ) != null ) {
	            
				counter++;
				for ( int i = 0; i < inputString.length( ); i++ ) {
	            	
	            	if( inputString.charAt( i ) == wanted ) {
	            		
	            		score += Double.parseDouble( inputString.substring( i + 2, inputString.length( ) ) );	            			            		
	            	}
	            }
	        }
			score /= counter;
			event.setText("Durchschnittliche Anzahl: "  + score );
		} catch ( FileNotFoundException e ) {
			
			System.err.println( e.toString( ) );
		} catch ( IOException e ) {
			
			System.err.println( e.toString( ) );
		}
	}
	
	@Override
	public void actionPerformed( ActionEvent evt ) {
		
		if ( evt.getActionCommand( ).equals( "Huetchen 1" ) ) {
			
			incrementCounter( );
			int match = 1;
			if ( match == getRandomNumber( ) ) {
				
				event.setText( "Versuch " + getCounter( ) + " Gewonnen: Die Kugel war unter Hut 1");
				writeInFile( );
				resetCounter( );
				setRandomNumber( );
			}
			else {
				
				event.setText( "Versuch " + getCounter( ) + " Falsch: Die Kugel war unter Hut " + getRandomNumber( ) );
				setRandomNumber( );
			}
		}
		
		if ( evt.getActionCommand( ).equals( "Huetchen 2" ) ) {
			
			incrementCounter( );
			int match = 2;
			if ( match == getRandomNumber( ) ) {
				
				event.setText( "Versuch " + getCounter( ) + " Gewonnen: Die Kugel war unter Hut 2");
				writeInFile( );
				resetCounter( );
				setRandomNumber( );
			}
			else {
				
				event.setText( "Versuch " + getCounter( ) + " Falsch: Die Kugel war unter Hut " + getRandomNumber( ) );
				setRandomNumber( );
			}
		}
		
		if ( evt.getActionCommand( ).equals( "Huetchen 3" ) ) {
	
			incrementCounter( );
			int match = 3;
			if ( match == getRandomNumber( ) ) {
				
				event.setText( "Versuch " + getCounter( ) + " Gewonnen: Die Kugel war unter Hut 3");
				writeInFile( );
				resetCounter( );
				setRandomNumber( );
			}
			else {
				
				event.setText( "Versuch " + getCounter( ) + " Falsch: Die Kugel war unter Hut " + getRandomNumber( ) );
				setRandomNumber( );
			}
		}
		
		if ( evt.getActionCommand( ).equals( "Statistik" ) ) {
	
			readOutOfFile( );
		}
		if ( evt.getActionCommand( ).equals( "Exit" ) ) {
	
			System.exit( 0 );
		}
	}
		
	static void addComponent ( 	Container cont, 
								GridBagLayout gbl, 
								Component c, 
								int x, int y, 
								int width, int height, 
								double weightx, double weighty )
	{
		GridBagConstraints gbc = new GridBagConstraints( );
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints( c, gbc );
		cont.add( c );
	}
	
	Huetchenspiel( ) {
		
		frame = new JFrame( );
		setTitle( "Ratespiel" );
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
		// erzeuge das (GridBag-)Layout für den Container (im Frame)
		contentPane = frame.getContentPane( );
		GridBagLayout gbl = new GridBagLayout( );
		contentPane.setLayout( gbl );
		
		// erzeuge Objektreferenzen für die einzelnen GUI - Elemente
		
		playerName = new JLabel( "Spielername: " );
		nameInput = new JTextField( );
		
		coneOne = new JButton( "Huetchen 1" );
		coneOne.addActionListener( this );
		
		coneTwo = new JButton( "Huetchen 2" );
		coneTwo.addActionListener( this );
		
		coneThree = new JButton( "Huetchen 3" );
		coneThree.addActionListener( this );
		
		statistics = new JButton( "Statistik" );
		statistics.addActionListener( this );
		
		dispose = new JButton( "Exit" );
		dispose.addActionListener( this );
		
		event = new JTextField( );
		
		// baue die GUI auf über die statische addComponent - Methode auf
		// 													x  y  w  h  wx wy
		addComponent( contentPane, gbl, playerName, 		0, 0, 1, 1, 1, 0);
		addComponent( contentPane, gbl, nameInput, 			1, 0, 2, 1, 1, 0);
		addComponent( contentPane, gbl, coneOne,			0, 1, 1, 1, 1, 0);
		addComponent( contentPane, gbl, coneTwo,			1, 1, 1, 1, 1, 0);
		addComponent( contentPane, gbl, coneThree,			2, 1, 1, 1, 1, 0);
		addComponent( contentPane, gbl, event,				0, 2, 3, 1, 1, 0);
		addComponent( contentPane, gbl, statistics,			1, 3, 1, 1, 1, 0);
		addComponent( contentPane, gbl, dispose, 			2, 3, 1, 1, 1, 0);

		
		add( contentPane );
		setSize( 400, 130 );
		setVisible( true );
		
		setRandomNumber( );
		resetCounter( );
	}

	public static void main( String[ ] args ) {
		
		new Huetchenspiel( );
	}
}