package dhbw_karlsruhe.Arrays;

import java.util.Scanner;

public class Bubblesort {

	public static void main( String[ ] args ) {
		
		Scanner scanner = new Scanner( System.in );
		double[ ] feld = new double[ 5 ];
		boolean unsortiert = true;
		double buffer = 0;
		
		for ( int i = 0; i < feld.length; i ++ ) { // Werte einlesen
			
			System.out.print( ( i + 1 ) + ". Wert für x eingeben: " );
			System.lineSeparator( );
			feld[ i ] = Double.parseDouble( scanner.nextLine( ) );
		}
		
		while ( unsortiert ) {
			
			unsortiert = false;
			for ( int i = 0; i < feld.length - 1; i ++ ) {
			
				if ( feld[ i ] > feld[ i + 1] ) {
					System.out.println("-");
					buffer = feld[ i ];
					feld[ i ] = feld[ i + 1 ];
					feld[ i + 1 ] = buffer;
					unsortiert = true;
				}
			}
		}
		for ( int i = 0; i < feld.length; i ++ ) {
			
			System.out.print( feld[ i ] + " " );
		}
		scanner.close( );
	}
}