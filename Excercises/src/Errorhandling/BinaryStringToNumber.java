package Errorhandling;

public class BinaryStringToNumber {
	
	public static int parseBinary ( String s ) throws NoBinaryNumberException
	{
		int result = 0;

	    for ( int i = 0; i < s.length( ); i++ )
	    {
	    	char c = s.charAt( i );
	    	if ( ( c != '1' ) && ( c != '0' ) )
	    	{
	    		throw new NoBinaryNumberException( s, i );
	    	}
	    	else
	    	{
	    		result *= 2;
	    	}
	        if ( c == '1' )
	        {
	        	result++;
	        }
	    }
	    return result;
	}
	
}
