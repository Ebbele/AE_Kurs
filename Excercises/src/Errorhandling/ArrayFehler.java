package Errorhandling;

// Aufgabe 24
public class ArrayFehler {

	public static void main ( String[ ] args ) {
		
		int array[ ] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int i = 0;		
		try {
			while  ( i <= 10 ) {
			i = array[ i ];
			}
		} catch ( IndexOutOfBoundsException e ) {
			System.out.println( "Ungueltiger Index." );
		}
		
	}
	
}
