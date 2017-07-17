package GUI.GUI_Uebung_2_1;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JGUI_2_1 extends JPanel {

	static final long serialVersionUID = 1L;
	
	public void newWindow( ) {
		JFrame window = new JFrame( "Uebung 2.1" );
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		window.setSize( 100, 100 );
		window.add( new JGUI_2_1( ) );
		window.setVisible( true );
	}
	
	protected void paintComponent( Graphics g ) {
		
		super.paintComponent( g );
		g.drawOval( 35, 5, 50, 50 );
	}
}
