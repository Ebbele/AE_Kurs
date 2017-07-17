package ReaderWriterexercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Measurements {

	public static void main( String[ ] args ) {
		
		int puffer;
		int zaehler = 1;
		int zeile = 0;
		final String LINE_SEPARATOR = System.getProperty("line.separator");
		

		// auch möglich, aber halt nur nicht gepuffert
/*		try  (FileReader fr = new FileReader( "valuesIn.dat" ) ) {
			try ( FileWriter fw = new FileWriter( "valuesOut.dat" ) ) {
			
				while ( ( puffer = fr.read( ) ) != -1 ) {
					System.out.printf( "%4d ", puffer );
					fw.write( puffer + " ");;
					zeile++;
					if( zeile == 10 ) {
						fw.write( " Messreihe " + zaehler + LINE_SEPARATOR  );
						System.out.println( "Messreihe " + zaehler );
						zeile = 0;
						zaehler++;
					}
				}				
			}			
		} catch ( IOException e ) {
			
		} 
*/		
		try  (BufferedReader br = new BufferedReader( new FileReader( "valuesIn.dat" ) ) ) {
			try ( BufferedWriter bw = new BufferedWriter( new FileWriter( "valuesOut.dat" ) ) ) {
			
				while ( ( puffer = br.read( ) ) != -1 ) {
					System.out.printf( "%4d ",puffer );
					bw.write( puffer + " ");;
					zeile++;
					if( zeile == 10 ) {
						bw.write( " Messreihe " + zaehler + LINE_SEPARATOR  );
						System.out.println( "Messreihe " + zaehler );
						zeile = 0;
						zaehler++;
					}
				}				
			}			
		} catch ( IOException e ) {
			
		}
	}	
}
