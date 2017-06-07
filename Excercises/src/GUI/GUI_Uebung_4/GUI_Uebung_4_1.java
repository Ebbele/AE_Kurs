package GUI.GUI_Uebung_4;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI_Uebung_4_1 {

	public JPanel newWindow( JFrame frame, Dimension d, int x, boolean checked ) {
		
		JPanel panel = new JPanel( ) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent( Graphics g ) {
				
				if( checked ) {
					super.paintComponent( g );
					g.fillOval( x, 10, 50, 50 );
				}
				if( !checked ) {
					super.paintComponent( g );
				}
			}
		};
	
		panel.setSize( d );
		frame.add( panel );
		return panel;
	}
}
