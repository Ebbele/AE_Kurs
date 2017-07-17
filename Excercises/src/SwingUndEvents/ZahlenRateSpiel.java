package SwingUndEvents;

import java.util.Random;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings( "serial" )
public class ZahlenRateSpiel extends JFrame implements ActionListener {
	
	// deklariere GUI - Elemente
	private JFrame frame;
	
	private Container contentPane;
	
	private JLabel nameLabel;
	private JTextField nameInput;
	
	private JLabel numberLabel;
	private JTextField numberInput;
	
	private JTextField eventOutput;
		
	private JButton btnNewGame;
	private JButton btnConfirm;
	private JButton btnBestOf;
	private JButton btnDispose;
	
	// für die Zufallszahl und die Anzahl der Rateversuche
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
		int zufallszahl = rd.nextInt( 1000 );
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
			String name = "";
			int score = Integer.MAX_VALUE;
			
			while ( ( inputString = br.readLine( ) ) != null ) {
	            
				for ( int i = 0; i < inputString.length( ); i++ ) {
	            	
	            	if( inputString.charAt( i ) == wanted ) {
	            		
	            		if ( Integer.parseInt( inputString.substring( i + 2, inputString.length( ) ) ) < score ) {
	            			
	            			score = Integer.parseInt( inputString.substring( i + 2, inputString.length( ) ) );
	            			name = inputString.substring( 0, i - 1 );
	            		}	            		
	            	}
	            }
	        }
			eventOutput.setText("Rekordhalter: " + name + " mit " + score + " Versuchen");
		} catch ( FileNotFoundException e ) {
			
			System.err.println( e.toString( ) );
		} catch ( IOException e ) {
			
			System.err.println( e.toString( ) );
		}
	}
	
	@Override
	public void actionPerformed( ActionEvent evt ) {
		
		incrementCounter( );
		if ( evt.getActionCommand( ).equals( "Neues Spiel" ) ) {
			
			setRandomNumber( );
			resetCounter( );
		}
		if ( evt.getActionCommand( ).equals( "OK" ) ) {
			
			if ( Integer.parseInt( numberInput.getText( ) ) > getRandomNumber( ) ) {
				
				eventOutput.setText( "Versuch Nr. " + getCounter( ) + ": " + numberInput.getText( ) + " zu hoch" );
			}
			else if( Integer.parseInt( numberInput.getText( ) ) < getRandomNumber( ) ) {
				
				eventOutput.setText( "Versuch Nr. " + getCounter( ) + ": " + numberInput.getText( ) + " zu klein" );
			}
			else if ( Integer.parseInt( numberInput.getText( ) ) == getRandomNumber( ) ) {
				
				eventOutput.setText( "Gewonnen! Versuch Nr. " + getCounter( ) + ": " + numberInput.getText( ) + " ist richtig!" );
				writeInFile( );
			}
		}
		if ( evt.getActionCommand( ).equals( "Bester" ) ) {
			
			readOutOfFile( );
		}
		if ( evt.getActionCommand( ).equals( "Beenden" ) ) {
			
			System.exit( 0 );
		}
	}
	
	// zum setzen der "Einschränkungen" für die GUI - Elemente (für die "Schreibfaulen")
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
	
	ZahlenRateSpiel( ) {
		
		// baue den JFrame auf
		frame = new JFrame( );
		setTitle( "Ratespiel" );
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
		// erzeuge das (GridBag-)Layout für den Container (im Frame)
		contentPane = frame.getContentPane( );
		GridBagLayout gbl = new GridBagLayout( );
		contentPane.setLayout( gbl );
		
		// erzeuge Objektreferenzen für die einzelnen GUI - Elemente
		
		nameLabel = new JLabel( "Spielername:" );
		nameInput = new JTextField( );
		
		numberLabel = new JLabel( "Zahl zwischen 1 und 1000 eingeben:" );
		numberInput = new JTextField( );
		
		btnNewGame = new JButton( "Neues Spiel" );
		btnNewGame.addActionListener( this );
		
		btnConfirm = new JButton( "OK" );
		btnConfirm.addActionListener( this );
		
		btnBestOf = new JButton( "Bester" );
		btnBestOf.addActionListener( this );
		
		btnDispose = new JButton( "Beenden" );
		btnDispose.addActionListener( this );
		
		eventOutput = new JTextField( );
		
		// baue die GUI auf über die statische addComponent - Methode auf
		// 													x  y  w  h  wx wy
		addComponent( contentPane, gbl, nameLabel, 			0, 0, 1, 1, 1, 0);
		addComponent( contentPane, gbl, nameInput, 			1, 0, 3, 1, 1, 0);
		addComponent( contentPane, gbl, numberLabel,		0, 1, 1, 1, 1, 0);
		addComponent( contentPane, gbl, numberInput,		1, 1, 3, 1, 1, 0);
		addComponent( contentPane, gbl, btnNewGame,			0, 2, 1, 1, 1, 0);
		addComponent( contentPane, gbl, btnConfirm,			1, 2, 1, 1, 1, 0);
		addComponent( contentPane, gbl, btnBestOf, 			2, 2, 1, 1, 1, 0);
		addComponent( contentPane, gbl, btnDispose,			3, 2, 1, 1, 1, 0);
		addComponent( contentPane, gbl, eventOutput,		0, 3, 4, 1, 1, 0);
		
		add( contentPane );
		setSize( 500, 125 );
		setVisible( true );
		
		// erzeuge 1. Zufallszahl
		setRandomNumber( );
	}
	
	public static void main( String[ ] args ) {

		new ZahlenRateSpiel( );
	}
}
