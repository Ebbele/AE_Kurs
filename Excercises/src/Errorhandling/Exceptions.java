package Errorhandling;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Exceptions {

	private JFrame frame;
	private Container contentPane;
	
	private JLabel lblDividend;
	private JLabel lblDivisor;
	
	private JTextField txtDividend;
	private JTextField txtDivisor;
	
	boolean isNumericProof;
	
	Exceptions( ) {
		
		frame = new JFrame( );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle( "Exceptions" );
		contentPane = frame.getContentPane( );
		contentPane.setLayout( new GridLayout( 2, 2 ) );
		
		lblDividend = new JLabel( "Dividend" );
		contentPane.add( lblDividend );
		
		txtDividend = new JTextField( );
		
		contentPane.add( txtDividend );
		
		lblDivisor = new JLabel( "Divisor" );
		contentPane.add( lblDivisor );
		
		txtDivisor = new JTextField( );
		txtDivisor.addKeyListener( new KeyAdapter( ) {
			
			@Override
			public void keyPressed( KeyEvent e ) {	

				if( e.getKeyCode( ) == KeyEvent.VK_ENTER ) {
					
					double ergebnis = integerDivision( txtDividend.getText( ), txtDivisor.getText( ) );
					if (ergebnis != 0.0 ) {
						
						System.out.println( ergebnis );
					}
				}
			}
		});
		contentPane.add( txtDivisor );
		
		frame.setSize( 200, 80 );
		frame.setVisible( true );
	}
	
	public double integerDivision( String dividend, String divisor ) {
		try {
			
			if ( dividend.equals( "" ) || divisor.equals( "" ) ) {
		
				throw new IllegalArgumentException( );
			}
		
			else if ( !( isNumericProof = isNumeric( dividend ) ) || !( isNumericProof = isNumeric( dividend ) ) ) {
	
				throw new NumberFormatException( );
			}		
		
			else if ( divisor.equals( "0" ) ) {
	
				throw new ArithmeticException( );
			}
			else {
	
				return Double.parseDouble( dividend ) / Double.parseDouble( divisor );
			}
		} catch ( ArithmeticException e ) {
		
			System.out.println( "ArithmeticException - Keine Division durch 0 erlaubt." );
		} catch ( NumberFormatException e ) {
		
			System.out.println( "NumberFormatException - Nur ganzzahlige Werte erlaubt." );
		} catch ( IllegalArgumentException e ) {
		
			System.out.println( "IllegalArgumentException - Kein Leerstring erlaubt." );
		}
		return 0;
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
		
		new Exceptions();		
	}
}
