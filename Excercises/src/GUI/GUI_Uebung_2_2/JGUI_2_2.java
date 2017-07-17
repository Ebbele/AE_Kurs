package GUI.GUI_Uebung_2_2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.GUI_Uebung_2_2.JGUI_2_2;

public class JGUI_2_2 extends JPanel {

	static final long serialVersionUID = 1L;
	Dimension d = Toolkit.getDefaultToolkit( ).getScreenSize( );
	
	boolean confirm = false;	
	String nachricht = "Durch Klick auf OK wird aus dem Kreis ein Quadrat.";
    String titel = "Bestaetigung";
    int reply = 1;
    
	public void newWindow( ) {
		
		JFrame window = new JFrame( "Uebung 2.2" );
		JPanel panel = new JPanel( ) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent( Graphics g ) {
				
				if ( confirm ) {
					
					super.paintComponent( g );
					g.fillRect( 35, 5, 50, 50 );

				} else if( !confirm ) {
					
					super.paintComponent( g );
					g.fillOval( 35, 5, 50, 50 );
				}		
			}
		};
		
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		window.setSize( 100, 100 );
		window.setLocation( d.width - d.getSize( ).width / 2 , 
							d.height - d.getSize( ).height / 2);
	    
		if ( reply == 0 )
	    	confirm = true;

		window.add( new JGUI_2_2( ) );
		window.add( panel );
		window.setVisible( true );		
	}	
}
