package GUI.GUI_Uebung_3_1;

import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

public class GUI_3_1 { 
	
	Polygon p = new Polygon( );

	public JPanel newWindow( JFrame frame, Dimension d, int shape ) {
		
		JPanel panel = new JPanel( ) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent( Graphics g ) {
				
				if ( shape == 1 ) {
					
					super.paintComponent( g );
					g.fillOval( 35, 5, 50, 50 );
				} else if( shape == 2 ) {
					
					super.paintComponent( g );
					g.fillRect( 35, 5, 50, 50 );
				} else if( shape == 3 ) {
					
					p.reset( );
					
					super.paintComponent( g );
				      
				      p.addPoint( 30, 10 );
				      p.addPoint( 80, 10 );
				      
				      p.addPoint( 80, 10 );
				      p.addPoint( 70, 50 );
				      
				      p.addPoint( 70, 50 );
				      p.addPoint( 50, 50 );
				      
				      p.addPoint( 50, 50 );
				      p.addPoint( 30, 10 );
				      
				      g.fillPolygon( p );
				      
				} else if( shape == 4 ) { // noch fehlerhaft, kein wirkliches Achteck
	
					p.reset( );
					
					for ( int i = 0; i < 6; i++ ) {
						
						p.addPoint( ( int ) ( 50 + 50 * Math.cos( i * 2 * Math.PI / 8 ) ) , 
									( int ) ( 50 + 50 * Math.sin( i * 2 * Math.PI / 8 ) ) );
					}
					
					super.paintComponent( g );
					g.fillPolygon( p );										
				}
			}
		};
		
		panel.setSize( d );
		frame.add( panel );
		return panel;
	}
}
