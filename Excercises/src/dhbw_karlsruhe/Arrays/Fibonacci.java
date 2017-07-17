package dhbw_karlsruhe.Arrays;

public class Fibonacci {

	public static void main( String[ ] args ) {
		
		int[ ] fibonacci = new int[ 50 ];
		fibonacci[ 0 ] = 1;
		fibonacci[ 1 ] = 1;
		
		System.out.print( fibonacci[ 0 ] + " - " + fibonacci[ 1 ] );		
		for ( int i = 2; i < fibonacci.length; i++ ) { // iterative lösung
			
			fibonacci[ i ] = fibonacci[ i - 1 ] + fibonacci[ i - 2 ];
			System.out.print(" - " + fibonacci[ i ] );
		}
		
		System.out.println("1 - 1 - ");
		fibonacci( 1, 1);

	}
	
	public static int fibonacci( int a, int b ) { // rekursive lösung
		
		int puffer = a + b;
		System.out.print( puffer + " - ");
		return puffer <= 1836311903 ? fibonacci( puffer, a ) : 0;
	}
}
