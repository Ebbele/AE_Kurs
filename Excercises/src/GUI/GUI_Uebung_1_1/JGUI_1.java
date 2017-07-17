package GUI.GUI_Uebung_1_1;

import javax.swing.JFrame;

public class JGUI_1 {
	
	public void newWindow( ) {
		
		JFrame window = new JFrame( "Uebung 1" );
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		window.setSize( 400, 100 );
		window.setVisible( true );
	}
}
