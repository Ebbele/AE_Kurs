package Errorhandling;


public class NoBinaryNumberException extends RuntimeException {
	
	NoBinaryNumberException( ) {
		super( );
	}
	
	NoBinaryNumberException( String binaryAsString ) {
		super( binaryAsString );
	}

	NoBinaryNumberException( String binaryAsString, int pos ) {
		System.out.println( "Kein Binary(0 oder 1) im String: " + binaryAsString + " an Position: " + ( pos + 1 ) );
	}
	
}
