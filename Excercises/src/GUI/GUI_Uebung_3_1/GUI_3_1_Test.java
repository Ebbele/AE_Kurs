package GUI.GUI_Uebung_3_1;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class GUI_3_1_Test extends Thread {
	
	static JFrame frame = new JFrame( "Uebung 3.1" );
	static Dimension d = Toolkit.getDefaultToolkit( ).getScreenSize( );
	static int shape = 0;
	JPanel panel;
	
	GUI_3_1_Test( ) {
		
		setDaemon( true );
	}

	@Override
	public void run( ) {
	
		GUI_3_1 test = new GUI_3_1( );
		try {
			while ( true ) {
				
				while ( shape < 5 ) {
				
					panel = test.newWindow( frame, d, shape );
					panel.repaint();
					Thread.sleep( 3000 );
					shape++;
				}
				JOptionPane.showMessageDialog( null, "Die Praesentation ist beendet" );
				System.exit( 0 );
			}
		} catch ( InterruptedException e ) {
			
			e.getMessage();
		}	      
	}
	
	public static void main ( String[ ] args ) {
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 100, 100 );
		
		frame.setLocation( d.width - d.getSize( ).width / 2 , 
				d.height - d.getSize( ).height / 2);
		frame.setVisible( true );
		
		new GUI_3_1_Test( ).start( );
	}
}
