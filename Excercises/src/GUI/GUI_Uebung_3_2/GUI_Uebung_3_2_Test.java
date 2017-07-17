package GUI.GUI_Uebung_3_2;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.GUI_Uebung_3_2.GUI_Uebung_3_2;

import javax.swing.JOptionPane;

public class GUI_Uebung_3_2_Test {

	static JFrame frame = new JFrame( "Uebung 3.1" );
	static Dimension d = Toolkit.getDefaultToolkit( ).getScreenSize( );
	static int shape = 0;
	static String s;
	JPanel panel;
	
	public static void main( String[ ] args ) {
		
		s = JOptionPane.showInputDialog( "(1) Kreis - (2) Viereck - (3) Trapez - (4) Achteck");
		shape = Integer.parseInt( s );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 100, 100 );
		
		frame.setLocation( d.width - d.getSize( ).width / 2 , 
				d.height - d.getSize( ).height / 2);
		frame.setVisible( true );
		GUI_Uebung_3_2 test = new GUI_Uebung_3_2( );
		test.newWindow( frame, d, shape );
	}
}
