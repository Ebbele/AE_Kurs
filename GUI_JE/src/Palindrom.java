

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Palindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("Palindrom");
	    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    
	    
	    JButton b1 = new JButton( "Palindrom ?" );
	    frame.getContentPane().add( b1 );
		
	    
	    frame.setSize( 300, 100 ); frame.setVisible( true );
	}

}
