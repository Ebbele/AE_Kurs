package SwingUndEvents;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Palindrom implements ActionListener {
	
	static JLabel info = new JLabel( "Eingabestring:" );
	static JTextField text = new JTextField( );
	static JButton button = new JButton( "Palindrom?" );
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		
		String s = text.getText( );
		int laenge = s.length( );
		boolean pali = true;
		
		for ( int i = 0; i < s.length( ) / 2; i++ ) {
			if ( s.charAt( i ) != s.charAt( laenge - 1 - i ) ) {			
				pali = false;
			}			
		}
		if ( pali ) {
			JOptionPane.showMessageDialog( null, s + " ist ein Palindrom" );
		}
		else {
			JOptionPane.showMessageDialog( null, s + " ist kein Palindrom" );
		}
			
	}

	public static void main( String [ ] args ) {
		
		JFrame frame = new JFrame( );
		Dimension d = new Dimension( 150, 30);
		ActionListener listener = new Palindrom( );
		
		frame.setSize( 300, 80 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
		Container c = frame.getContentPane( );
		c.setLayout( new GridLayout( 2, 2 ) );
		
		
		info.setPreferredSize( d );
		text.setPreferredSize( d );
		button.setPreferredSize( d );
		button.addActionListener( listener );		
		
		c.add( info );
		c.add( text );
		c.add( button );
		
		frame.setVisible( true );
	}
}

// Musterloesung mit NULL - Layout und setBounds-Platzierung