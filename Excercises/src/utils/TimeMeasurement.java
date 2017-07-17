package utils;

import java.time.Duration;
import java.time.Instant;

public class TimeMeasurement {
	
	public static void stringmethode( ) {
		
		String s = "x";
		for ( int i = 0; i < 10000; i++ ) {
			s += "x";
		}
	}
	
	public static void stringbuffermethode( ) {
		
		StringBuffer sb = new StringBuffer( "x" );
		for ( int i = 0; i < 10000; i++ ) {
			sb.append( "x" );
		}
	}

	public static void main(String[ ] args) {
		
		Instant startString = Instant.now( );
		stringmethode( );
		Instant endeString = Instant.now( );
		Duration stringmethode = Duration.between( startString, endeString );
		long stringErgebnis = stringmethode.toMillis( );
		
		Instant startStringBuffer = Instant.now( );
		stringbuffermethode( );
		Instant endeStringBuffer = Instant.now( );
		Duration stringbuffermethode = Duration.between( startStringBuffer, endeStringBuffer );
		long stringBufferErgebnis = stringbuffermethode.toMillis( );
		
		System.out.println( "String: \t" + stringErgebnis + " ms" );
		System.out.println( "StringBuffer: \t" + stringBufferErgebnis + " ms" );
	}
}
