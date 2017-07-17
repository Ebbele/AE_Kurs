package dhbw_karlsruhe.Arrays;

public class Mittelwert_Standardabweichung {

	public static void main( String[ ] args ) {
		
		double[ ] anzahl = new double[ 100 ];
		double standardabweichung = 0.0;
		double mittelwert = 0.0;
		
		for ( int i = 0; i < anzahl.length; i++ ) {
		
			anzahl[ i ] = Math.random( ) * 10;
			mittelwert += anzahl[ i ];
		}
		mittelwert *= ( 1 / ( double ) anzahl.length );

		for ( int j = 0; j < anzahl.length; j++ ) {
		
			standardabweichung += Math.pow( (anzahl[ j ] - mittelwert ), 2 );
		}
		standardabweichung = Math.sqrt( standardabweichung /= ( double ) anzahl.length - 1 );
		System.out.println( "Mittelwert: " + mittelwert );
		System.out.println( "Standardabweichung: " + standardabweichung );
	}
}
