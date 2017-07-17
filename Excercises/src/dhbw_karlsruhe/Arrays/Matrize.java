package dhbw_karlsruhe.Arrays;

public class Matrize {

	public static void main( String[ ] args ) {
		
		int[ ][ ] matrizeA = new int[ 4 ][ 4 ];
		int[ ][ ] matrizeB = new int[ 4 ][ 4 ];
		int[ ][ ] matrizeErgebnis = new int[ 4 ][ 4 ];
		
		for ( int i = 0; i < matrizeA.length; i++ ) {
			
			for ( int j = 0; j < matrizeA.length; j++ ) {
				
				matrizeA[ i ][ j ] = ( int ) ( Math.random( ) * 12 );
				matrizeB[ i ][ j ] = ( int ) ( Math.random( ) * 12 );
				matrizeErgebnis[ i ][ j ] = matrizeA[ i ][ j ] - matrizeB[ i ][ j ];
			}
		}
		for ( int k = 0; k < 3; k++ ) {
			
			for ( int i = 0; i < matrizeA.length; i++ ) {
			
				for ( int j = 0; j < matrizeA.length; j++ ) {
				
					if ( k == 0 ) {
						
						System.out.print( matrizeA[ i ][ j ] + "\t" );
					}
					
					if ( k == 1 ) {
						
						System.out.print( matrizeB[ i ][ j ] + "\t" );
					}
					
					if ( k == 2 ) {
						
						System.out.print( matrizeErgebnis[ i ][ j ] + "\t" );
					}
				}
				System.out.println();
			}
			System.out.println();
		}		
	}
}
