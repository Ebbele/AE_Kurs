package SwingUndEvents;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Quersumme {

	static JLabel eingabe = new JLabel( "Eingabe:" );
	static JTextField eingabeZahl = new JTextField( );
	static JLabel quersumme = new JLabel( "Quersumme:" );
	static JTextField ausgabeQuersumme = new JTextField( );
	
	public static void main( String [ ] args ) {
		
		JFrame frame = new JFrame( );
		Dimension d = new Dimension( 150, 30 );
		
		frame.setSize( 300, 80 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
		Container c = frame.getContentPane( );
		c.setLayout( new GridLayout( 2, 2 ) );		
		
		eingabe.setPreferredSize( d );
		eingabeZahl.setPreferredSize( d );
		quersumme.setPreferredSize( d );
		ausgabeQuersumme.setPreferredSize( d );
		
		eingabeZahl.addKeyListener( new KeyAdapter( )  {
			
	        public void keyPressed( KeyEvent e ) {
	        	
	            if( e.getKeyCode( ) == KeyEvent.VK_ENTER ) {
	            	
	                String s = eingabeZahl.getText( );
	                int summe = 0;
	                
	                for ( int i = 0; i < s.length( ); i++ ) {
	                	
	                	summe += Integer.parseInt( s.substring( i, i + 1 ) );
	                	
	                }
	                ausgabeQuersumme.setText( String.valueOf ( summe ) );
	            }
	        }
	    });
		
		c.add( eingabe );
		c.add( eingabeZahl );
		c.add( quersumme );
		c.add( ausgabeQuersumme );
		
		frame.setVisible( true );
	}
}
