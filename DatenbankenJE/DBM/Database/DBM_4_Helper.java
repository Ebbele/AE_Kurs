package Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBM_4_Helper {
	
	Scanner scanner = new Scanner( System.in );
	DBM_4 dbm = new DBM_4( );
	
	ResultSet rs;
	File dir;
	File file;
	
	String eingabe;
	String[ ] input = new String[ 5 ];
	int parse;
	
	
	public DBM_4_Helper ( ) {
		
		dbm.loadDriver( );
		dbm.connectDB( );
		menue( );
	}
	
	public void menue( ) {
		
		System.out.println( " " );
		System.out.println( "*****************************");
		System.out.println( "Bitte auswaehlen:" );
		System.out.println( "Tabelle(Customer) anzeigen(1)" );
		System.out.println( "Datensatz löschen(2)" );
		System.out.println( "Datensatz hinzufuegen(3)" );
		System.out.println( "Datensatz suchen(4)" );
		System.out.println( "Datensatz aendern(5)" );
		System.out.println( "Datenbank in Datei speichern(6)" );
		System.out.println( "Daten aus einer Datei in die DB speichern(7)" );
		System.out.println( "Programm beenden(8)" );
		System.out.println( "*****************************");
		System.out.print( "Eingabe:" );
		
		eingabe = scanner.next( );
		parse = Integer.parseInt( eingabe );
		menueAusw( parse );
			
	}
	
	public void menueAusw( int auswahl ) {
		
		switch ( auswahl ) {
			
		case 1:

			dbm.dbQuery( );
			dbm.showQuery( );
			menue( );
			break;
				
		case 2:
			
			System.out.print( System.lineSeparator( ) + "Bitte die ID des zu löschenden Datensatzes eingeben: " );
			eingabe = scanner.next( );
			dbm.deleteElement( eingabe );
			menue( );
			break;
			
		case 3:
			
			eingabeNew( );
			menue( );
			break;
			
		case 4:
			
			eingabeSearch( );
			menue( );
			break;
			
		case 5:
			
			System.out.print( System.lineSeparator( ) + "Bitte die ID des zu aendernden Datensatzes eingeben: " );
			eingabe = scanner.next( );
						
			System.out.print( System.lineSeparator( ) + "Bitte neuen Vornamen eingeben: ");
			input[ 0 ] = scanner.next( );
			
			System.out.print( System.lineSeparator( ) + "Bitte neuen Nachnamen eingeben: ");
			input[ 1 ] = scanner.next( );
			
			System.out.print( System.lineSeparator( ) + "Bitte neuen Strasse eingeben: ");
			input[ 2 ] = scanner.next( );
			
			System.out.print( System.lineSeparator( ) + "Bitte neue Stadt eingeben: ");
			input[ 3 ] = scanner.next( );
			
			dbm.changeDS( eingabe, input );
			menue( );
			
		case 6:
			
			file = eingabeFileData( );
			rs = dbm.dbQuery( );
			writeInFile( file, rs );
			menue( );
			break;
			
		case 7:
			
			readOutFile( );
			menue( );
			break;
			
		case 8:
			
			scanner.close( );
			System.out.println( "Programm beendet." );
			System.exit( 0 );
			
		default:
			
			System.out.println( "Falsche Eingabe!" );
			menue( );
		}
	}
	
	public void writeInFile( File file, ResultSet rs ) {
		try ( FileWriter fw = new FileWriter( file ) ) {
			try {
				while ( rs.next( ) ) {
					for ( int i = 1; i < 6; i++ ) {
						fw.write( rs.getString( i ) + "\r\n" ) ;
					}
				}
			} catch ( SQLException e ) {
				
				e.printStackTrace( );
			}
		} catch ( IOException e ) {
			
			e.printStackTrace( );
		}
		System.out.println( "Datenbank wurde in " + file.getName( ) + " gespeichert." );
	}
	
	public void readOutFile( ) {
		System.out.println( "Bitte das Verzeichnis und den Namen der Datei angeben: " );
		eingabe = scanner.next( );
		int i = 0;
		try ( BufferedReader br = new BufferedReader( new FileReader( eingabe ) ) ) {			
			
				while ( ( eingabe = br.readLine( ) ) != null  ){
					
					input[ i ] = eingabe;
					i++;
					if ( i == 5 ) {
						dbm.insertElement( input );
						i = 0;
					}
				}			
		} catch ( IOException e ) {
			
			e.printStackTrace( );
		}
		System.out.println(eingabe);
	}
	
	public File eingabeFileData( ) {
		System.out.print( "Geben Sie einen Pfad zum Speichern der Datei an: " );
		input[0] = scanner.next();
		System.out.print( System.lineSeparator() + "Geben sie einen Dateinamen an:" );
		input[1] = scanner.next();
		file = createFileDirectory( input );
		return file;
	}
	
	public File createFileDirectory( String[ ] input ) {
		
		dir = new File( "c:\\" + input[ 0 ] );
		file = new File( "c:\\" + input[ 0 ] + "\\" + input[ 1 ] );
			if ( dir.mkdirs( ) ) {
					
				try {
						
						file.createNewFile( );
					} catch ( IOException e ) {
						
						e.printStackTrace();
					}
				}
		else {
			System.out.println( "Verzeichnis/Datei konnte nicht erstellt werden bzw sind schon angelegt." );
		}
		System.out.println("c:\\" + input[ 0 ] + "\\" + input[ 1 ] + " wurde angelegt.");
		return file;
	}
	
	public void eingabeSearch( ) {
		
		System.out.print( "Bitte Suchbegriff eingeben: " );
		eingabe = scanner.next( );
		rs = searchElement( eingabe );
		
		try {
			
			while ( this.rs.next( ) ) {
				
				System.out.print( "Treffer: " );
				System.out.printf( "%s - %s - %s - %s - %s", this.rs.getString( 1 ),
									this.rs.getString( 2 ), this.rs.getString( 3 ), this.rs.getString( 4 ), this.rs.getString( 5 ) );
			}
		} catch ( SQLException e) {
				
				e.printStackTrace( );
		}
	}
	
	
	public ResultSet searchElement( String suche ) {
		
		rs = dbm.dbQuery( suche );
		return rs;
	}
	
	
	public void eingabeNew( ) {
		
		System.out.print( "Bitte ID eingeben: ");
		input[ 0 ] = scanner.next( );
		
		System.out.print( System.lineSeparator( ) + "Bitte Vornamen eingeben: ");
		input[ 1 ] = scanner.next( );
		
		System.out.print( System.lineSeparator( ) + "Bitte Nachnamen eingeben: ");
		input[ 2 ] = scanner.next( );
		
		System.out.print( System.lineSeparator( ) + "Bitte Strasse eingeben: ");
		input[ 3 ] = scanner.next( );
		
		System.out.print( System.lineSeparator( ) + "Bitte Stadt eingeben: ");
		input[ 4 ] = scanner.next( );
		
		dbm.insertElement( input );
	}
}
