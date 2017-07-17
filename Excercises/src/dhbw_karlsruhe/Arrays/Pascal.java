package dhbw_karlsruhe.Arrays;

public class Pascal {

	public static void main( String[ ] args ) {
		
		int[ ][ ] pascal = new int[ 10 ][ ];		
		
		for ( int columnId = 0; columnId < pascal.length; columnId++ ) {
			
			pascal[ columnId ] = new int[ columnId + 1 ];
			pascal[ columnId ][ 0 ] = 1;
			pascal[ columnId ][ columnId ] = 1;
			
			for ( int rowId = 1; rowId < columnId; rowId++ ) {
			
				pascal[ columnId ][ rowId ] = pascal [ columnId - 1 ][ rowId - 1 ] + pascal[ columnId - 1 ][ rowId ];
			}			
		}
		
		for ( int i=0; i  < pascal.length; i++ ) { 
			
			System.out.print( "Zeile = " + i + "\t" ); 
			
			for ( int j = 0; j < i + 1; j++ ) 			
				System.out.print( pascal[ i ][ j ] + "\t" );
			
			System.out.print( "\n" );			
		}
	}
}