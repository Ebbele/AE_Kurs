package ReaderWriterexercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

// ToDo: Eingaben auf ihre Gültigkeit überprüfen, falsche Eingaben führen derzeit zu einem Abbruch(NumberFormatException)

public class ReadWriteData {
	
	static Person erzeugePersonenObjekt(String[ ] daten) {
		
		Person person = new Person( daten[ 0 ], daten[ 1 ], Integer.parseInt( daten[ 2 ] ), Integer.parseInt( daten[ 3 ] ) );
		return person;
	}
	
	public static void main( String[ ] args ) {
		
		ArrayList< Person > person = new ArrayList< Person >( );
		String[ ] daten = new String[ 4 ];
		String option = "ja";
		final String LINE_SEPARATOR = System.getProperty( "line.separator" );
		
		try( BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) ) ) {
			
			do {
				
				System.out.print( "Name: " );
				daten[ 0 ] = br.readLine( );
				System.out.print( LINE_SEPARATOR + "Geschlecht(m/w): " );
				daten[ 1 ] = br.readLine( );
				System.out.print( LINE_SEPARATOR + "Groesse(in cm): " );
				daten[ 2 ] = String.valueOf( br.readLine( ) );
				System.out.print( LINE_SEPARATOR + "Gewicht: " );
				daten[ 3 ] = br.readLine( );
				System.out.print( LINE_SEPARATOR + "Noch eine Person hinzufügen? <ja> oder <nein>" );
				option = br.readLine( );
				System.out.println( option );
					
				person.add( erzeugePersonenObjekt( daten ) );					
				
			} while ( option.equals("ja") );			
			
		} catch ( IOException eingabe )  {
			
			eingabe.printStackTrace( );
		}
		
		try ( PrintWriter pw = new PrintWriter( "personal.dat" ) ) {
			
			for ( Person p : person )	 {
				pw.println( "Name: " + p.getName( ) );
				pw.println( "Geschlecht: " + p.getGeschlecht( ) );
				pw.println( "Groesse: " + p.getGroesse( ) );
				pw.println( "Gewicht: " + p.getGewicht( ) );
				pw.println( "----------" );
			}
			System.out.println(" Personendaten wurden in personal.dat gespeichert." );
			
		} catch ( IOException ausgabe ) {
			
			ausgabe.printStackTrace( );		
		}		
	}		
}
