package GUI.GUI_Uebung_1_2;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JGUI_2 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Dimension d = Toolkit.getDefaultToolkit( ).getScreenSize( );
	
	public void newWindow( ) {
		
		JTextField ausgabe= new JTextField( "uebung macht den Meister", 10 );
		JFrame window = new JFrame( "Uebung2" );
		window.add( ausgabe );
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		window.setLocation( d.width - d.getSize( ).width / 2 , 
							d.height - d.getSize( ).height / 2);
		window.setSize( 400, 100 );
		window.setVisible( true );
	}
}
