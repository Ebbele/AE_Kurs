package Errorhandling;

public class Exercise5 {
	
	public Exercise5( )
	{
		System.out.println( "10111011 ist " + BinaryStringToNumber.parseBinary( "10111011" ) );
		String s = "10511011";
		System.out.println( s + " ist " + BinaryStringToNumber.parseBinary( s ) );
	}
		
	public static void main( String[ ] args )
	{
		try {
			Exercise5 ConvertingBinary = new Exercise5( );
		} catch ( NoBinaryNumberException e ) {
			System.out.println( "Fehlerhafter String(darf nur 0 oder 1 enthalten)!" );
		}
		finally {
			System.out.println("Ich bin ein finally-Block. ;)");
		}
	}

}
