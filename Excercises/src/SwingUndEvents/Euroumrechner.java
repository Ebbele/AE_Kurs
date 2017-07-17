package SwingUndEvents;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings( "serial" )
public class Euroumrechner extends JFrame implements ActionListener {
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField eingabe;
	private JButton euro;
	private JButton mark;
	private JButton beenden;
	private boolean isNumericProof;
	final double UMRECHNUNGSFAKTOR = 1.95583;
	
	public void actionPerformed( ActionEvent e ) {
		
		if ( e.getActionCommand( ).equals( "Euro -> DM" ) ) {
			
			double buffer = Double.parseDouble( eingabe.getText( ) );
			eingabe.setText( String.valueOf( buffer * UMRECHNUNGSFAKTOR ) );
		} 
		if ( e.getActionCommand( ).equals( "DM -> Euro" ) ) {
			
			double buffer = Double.parseDouble( eingabe.getText( ) );
			eingabe.setText( String.valueOf( buffer / UMRECHNUNGSFAKTOR ) );
		}
		if ( e.getActionCommand( ).equals( "Abbrechen" ) ) {
			
			System.exit( 0 );
		}
	}
	
	Euroumrechner( ) {
		
		frame = new JFrame( );
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		contentPane = new JPanel( );
		setContentPane( contentPane );
		GridBagLayout gbl = new GridBagLayout( );
		contentPane.setLayout( gbl );
		
		GridBagConstraints c = new GridBagConstraints( );
		
		eingabe = new JTextField( );
		eingabe.addKeyListener( new KeyAdapter( ) {
			
			public void keyTyped( KeyEvent e ) {	
				
				isNumericProof = isNumeric( String.valueOf( e.getKeyChar( ) ) );
		
				if ( !isNumericProof ) 
					eingabe.setText( "Nur numerische Werte erlaubt" );
			}
		});

		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 100;
		c.ipady = 10;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		contentPane.add( eingabe, c );
		
		euro = new JButton( "Euro -> DM" );
		euro.addActionListener( this );

		c.ipadx = 33;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		contentPane.add( euro, c );
		
		mark = new JButton( "DM -> Euro" );
		mark.addActionListener( this );

		c.gridx = 1;
		c.gridy = 1;
		contentPane.add( mark, c );
		
		beenden = new JButton( "Abbrechen" );
		beenden.addActionListener( this );

		c.gridx = 2;
		c.gridy = 1;
		contentPane.add( beenden, c );
				
		frame.add( contentPane );
		frame.pack();
		frame.setVisible( true );		
	}
	
	public static boolean isNumeric( String string ) {
		
		if ( string == null || string.length() == 0 ) {
			
			return false;
		}
		
		for ( int i = 0; i < string.length(); i++ ) {
			
			if ( ! Character.isDigit( string.charAt( i ) ) )
				
				return false;
		}
		return true;
	}
	
	public static void main( String[ ] args ) {
		
		new Euroumrechner( );
	}
}
