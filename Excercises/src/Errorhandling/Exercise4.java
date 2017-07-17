package Errorhandling;

public class Exercise4 {
	
	public Exercise4( )
	{
		System.out.println( "10111011 ist " + BinaryStringToNumber.parseBinary( "10111011" ) );
		String s = "10511011";
		System.out.println( s + " ist " + BinaryStringToNumber.parseBinary( s ) );
	}
		
	public static void main( String[ ] args )
	{
		try {
			Exercise4 ConvertingBinary = new Exercise4( );
		} catch ( NoBinaryNumberException e ) {
			System.out.println( "Fehlerhafter String(darf nur 0 oder 1 enthalten)!" );
		}
	}

}
