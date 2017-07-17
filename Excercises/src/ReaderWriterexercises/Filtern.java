package ReaderWriterexercises;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Filtern {

	Filtern( String ...args ) {
		
		if ( args.length < 3 ) {
			
			System.out.println( "Es sind 3 Parameter erforderlich ->\n"
					+ "1. Parameter: Name der einzulesenden Datei\n"
					+ "2. Parameter: Wort nach dem gefiltert werden soll\n"
					+ "3. Parameter: Name der Datei in dem die Ergebnisse reingeschrieben werden sollen");
		} else {
			
			System.out.println( "Trefferanzahl: " + filtern ( args[ 0 ], args[ 1 ], args[ 2 ] ) );
		}
	}
	
	public int filtern ( String eingabeDatei, String filterWort, String ausgabeDatei ) {
		
		int counter = schreibeInDatei( filtereDateiInhalt( leseAusDatei( eingabeDatei ), filterWort ), ausgabeDatei );
		
		return counter;
	}
	
	public int schreibeInDatei( List< String > gefilterteErgebnisse, String ausgabeDatei) {
		
		File file = new File( ausgabeDatei );
		int counter = 1;
		
		if ( !file.exists( ) ) {
			try {
				
				file.createNewFile(  );
			} catch ( IOException ioe ) {
				
				System.err.println( "Datei konnte nicht erstellt werden: " + ioe.toString( ) );
			}
		}
		Iterator< String > iter = gefilterteErgebnisse.iterator( );
		try ( BufferedWriter br = new BufferedWriter( new FileWriter( ausgabeDatei ) ) ) {
			
			while ( iter.hasNext( ) ) {
				br.write( counter + ". Treffer: " + iter.next( ).toString( ) + "\n" );
				counter++;
			}
		} catch ( IOException ioe ) {
			
			System.err.println( "Fehler beim Lesen oder Schlieﬂen der Datei: " + ioe.toString( ) );
		}
		return gefilterteErgebnisse.size( );
	}
	
	public List< String > filtereDateiInhalt ( StringBuilder dateiInhalt, String filterWort ) {
		
		char charbuffer;
		List< String > splitDateiInhalt = new ArrayList< String >( );
		int pointer = 0;
		String stringBuffer;
		
		for ( int i = 0; i < dateiInhalt.length( ); i++ ) {
			
			charbuffer = dateiInhalt.charAt( i );
			if ( charbuffer == '.' || charbuffer == '!' ) {
				
				if ( pruefeSatz ( stringBuffer = dateiInhalt.substring( pointer , i + 1 ), filterWort ) ) {
					
					splitDateiInhalt.add( stringBuffer );
				}
				pointer = i;
			}
		}
		return splitDateiInhalt;
	}
	
	public boolean pruefeSatz ( String satz, String filterWort ) {
		
		if ( satz.toLowerCase( ).contains( filterWort.trim( ).toLowerCase( ) ) ) {
			
			return true;
		} else {
			
			return false;
		}
	}
	
	public StringBuilder leseAusDatei ( String eingabeDatei ) {
		
		int buffer;
		StringBuilder sb = new StringBuilder( );
		
		try ( FileReader fr = new FileReader ( eingabeDatei ) ) {
			
			while ( ( buffer = fr.read( ) ) != -1  ) {
				
				sb.append( ( char ) buffer );
			}
		} catch ( FileNotFoundException fnfe ) {
			
			System.err.println( "Datei wurde nicht gefunden(1. Parameter): " + fnfe.toString( ) );
		} catch ( IOException ioe ) {
			
			System.err.println( " Fehler beim Schlieﬂen der Datei: " + ioe.toString( ) );
		}
		return sb;
	}
	
	public static void main( String[ ] args ) {
		
		new Filtern( args );
	}
}