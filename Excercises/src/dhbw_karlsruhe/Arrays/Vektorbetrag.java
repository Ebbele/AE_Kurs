package dhbw_karlsruhe.Arrays;

import java.util.Scanner;

public class Vektorbetrag {

	public static void main(String[] args) {
		
		double ergebnis = 0;
		Scanner scanner = new Scanner( System.in );
		
		System.out.print("Anzahl der Komponenten: ");
		int x = Integer.parseInt( scanner.nextLine( ) ); // Anzahl der Komponenten einlesen
		
		int[ ] vektor = new int[ x ];
		
		for ( int i = 0; i < x; i ++ ) { // Werte einlesen und berechnen
			
			System.lineSeparator( );
			System.out.print( ( i + 1 ) + ". Wert für x eingeben: " );
			vektor[ i ] = Integer.parseInt( scanner.nextLine( ) );
			ergebnis += ( vektor[ i ] * vektor[ i ] );
		}
		ergebnis = Math.sqrt( ergebnis );
		System.out.printf("Vektorbetrag: %.2f", ergebnis );
		scanner.close( );
	}
}
