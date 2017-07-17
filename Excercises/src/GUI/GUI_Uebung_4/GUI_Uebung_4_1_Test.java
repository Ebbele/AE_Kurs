package GUI.GUI_Uebung_4;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.GUI_Uebung_4.GUI_Uebung_4_1;


public class GUI_Uebung_4_1_Test extends Thread {
	
	static JFrame frame = new JFrame( "Uebung 4" );
	static Dimension d = Toolkit.getDefaultToolkit( ).getScreenSize( );
	JPanel panel;
	static int x = 0;
	
	GUI_Uebung_4_1_Test( ) {
		
		setDaemon( true );
	}

	@Override
	public void run( ) {
	
		GUI_Uebung_4_1 test = new GUI_Uebung_4_1( );
		try {
			while ( true ) {
				
				for ( int i = 0; i < 500; i++ ) {
					
					panel = test.newWindow( frame, d, x );
					panel.repaint( );
					Thread.sleep( 100 );					
					x++;				
				}
				System.exit( 0 );
			}
		} catch ( InterruptedException e ) {
			
			e.getMessage();
		}	      
	}
	
	public static void main ( String[ ] args ) {
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 500, 100 );
		
		frame.setLocation( d.width - d.getSize( ).width / 2 , 
				d.height - d.getSize( ).height / 2);
		frame.setVisible( true );
		
		new GUI_Uebung_4_1_Test( ).start( );
	}
}