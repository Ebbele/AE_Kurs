package dhbw_karlsruhe.Arrays;

import java.util.Scanner;

public class Vektor {

	public static void main(String[] args) {

		int ergebnis = 0;
		Scanner scanner = new Scanner( System.in );
		
		System.out.print("Anzahl der Komponenten: ");
		int x = Integer.parseInt( scanner.nextLine( ) ); // Anzahl der Komponenten einlesen
		
		int[ ] vektorX = new int[ x ];
		int[ ] vektorY = new int[ x ];
		
		for ( int i = 0; i < x; i ++ ) { // Werte einlesen und berechnen
			
			System.lineSeparator( );
			System.out.print( ( i + 1 ) + ". Wert für x eingeben: " );
			vektorX[ i ] = Integer.parseInt( scanner.nextLine( ) );
			System.lineSeparator( );
			System.out.print( ( i + 1 ) + ". Wert für y eingeben: " );
			vektorY[ i ] = Integer.parseInt( scanner.nextLine( ) );
			ergebnis = vektorX[ i ] * vektorY[ i ];
		}
		System.lineSeparator( );
		System.out.println("Skalarprodukt: " + ergebnis );
		scanner.close( );
	}
}