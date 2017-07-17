package Errorhandling.quad;

public class quadratischeGleichung {
	
	quadratischeGleichung( ) {
		
		double[ ] koeffizienten = { 2.0, 5.0, 4.0 };
		quadG1( koeffizienten );
	}
	private void p1( ) {
		
		double[ ] koeffizienten = { 2.0, 5.0, 4.0 };
		try {
			quadG1( koeffizienten );
		} catch ( NoRealSolutionException nrse ) {
			// p2( koeffizienten ); <- falls kein Ergebnis möglich, aufruf von p2
		}
	}
	
	private void p2( double[ ] koeffizienten ) { 
		
		// do some serious shit....
	}
	
	public static void quadG1( double[ ] koeffizienten ) throws NoRealSolutionException, IllegalArgumentException {
		
		double diskrimiante, x1, x2;
		if ( koeffizienten.length < 3 || koeffizienten[ 2 ] == 0.0 ) {
			
			throw new IllegalArgumentException( );
		}
		diskrimiante = ( koeffizienten[ 1 ] * koeffizienten[ 1 ] ) - 
						( 4 * koeffizienten[ 0 ] * koeffizienten[ 2 ]);
		
		if ( diskrimiante > 0 ){                                                        

			x1 = ( -koeffizienten[ 1 ] + Math.sqrt( diskrimiante ) ) / ( 2 * koeffizienten[ 0 ] );
			x2 = ( -koeffizienten[ 1 ] - Math.sqrt( diskrimiante ) ) / ( 2 * koeffizienten[ 0 ] );

			System.out.println( "Zwei Lösungen-> x1 = " + x1 +" und x2 = " +x2 );

			} else {

				if ( diskrimiante == 0 ) {                                                      

					x1 = ( -koeffizienten[ 1 ] + Math.sqrt( diskrimiante ) ) / ( 2 * koeffizienten[ 0 ] );
					System.out.println( "Eine lösung-> x1 = " + x1 );
				} else {
					
					throw new NoRealSolutionException( );                              
				}
		}       
	}

	public static void main(String[] args) {

		try {
			new quadratischeGleichung( );
		} catch ( NoRealSolutionException nrse ) {
			
			System.err.println( nrse.toString( ) );
		}catch ( IllegalArgumentException iae ) {
			
			System.err.println( "a2 = 0 ist nicht erlaubt." );
		}
	}
}