package ReaderWriterexercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LangeZeilen {

	public static void main( String[ ] args ) {
		
		if ( args.length < 2 ) {
			System.out.println( "Aufruf mit 2 Parametern wird erwartet \n"  
								+ "Der erste Wert soll eine ganzzahlige Zahl sein, sie dient zum Abgleich der eingelesen Zeilen(n>zeile) \n"
								+ "Der zweite Wert soll ein Dateiname(mit oder ohne Pfad) sein" );
		}
		
		String puffer;
		int counter = 0;
		int laenge;
		File file = new File( args[ 1 ] );		
		
		try( BufferedReader br = new BufferedReader( new FileReader( file ) ) ) {
			
			while ( ( puffer = br.readLine ( ) ) != null ) {
				
				laenge = puffer.length( );
				if ( laenge > Integer.parseInt( args[ 0 ] ) )
					counter++;
			}
		} catch ( FileNotFoundException e ) {
			
			System.err.println( e.toString( ) );
		} catch ( IOException e ) {
			
			System.err.println( e.toString( ) );
		}
		System.out.println( "Die Datei " + args[ 1 ] + " enthält " + counter + " Zeilen, die länger als " + args[ 0 ] + " Zeichen sind." );
	}
}
