package dhbw_karlsruhe.Arrays;

public class Eratostenes {

	public static void main(String[] args) {

		int[ ] sieb = new int[ 100 ];
		int[ ] primzahlen = new int[ 100 ];
		int min = Integer.MAX_VALUE;
        int pos = 0;
        boolean elementsleft = true;
		
		for ( int i = 0; i < sieb.length; i++ ) {
			
			sieb [ i ] = i + 2;
		}
        while ( elementsleft ) {
		
        	elementsleft = false;
        	for( int i = 0; i < sieb.length; i++ ) {
        	
        		if( sieb[ i ] < min ) {
        		
        			elementsleft = true;
        			min = sieb[ i ];
        			sieb[ i ] = Integer.MAX_VALUE;
        		}          
        	}
        	for( int i = 0; i < sieb.length; i++ ) {
        		
        		if ( sieb[ i ] % min == 0) {
        			
        			sieb[ i ] = Integer.MAX_VALUE;
        		}
        	}
        	primzahlen[ pos ] = min;
        	pos++;
        	min = Integer.MAX_VALUE;
        }
        
        for ( int i = 0; i < pos - 1; i ++ ) {
        	
        	System.out.println( primzahlen[ i ] );
        }
	}
}