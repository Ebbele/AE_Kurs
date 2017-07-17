package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBM_3_Helper {
	
	Scanner scanner = new Scanner( System.in );
	DBM_3 dbm = new DBM_3( );
	String eingabe;
	String[ ] input = new String[ 5 ];
	int parse;
	ResultSet rs;
	
	public DBM_3_Helper ( ) {
		
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
		System.out.println( "Programm beenden(5)" );
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
			
			scanner.close( );
			// dbm.unloadRessources( );
			System.out.println( "Programm beendet." );
			System.exit( 0 );
			
		default:
			
			System.out.println( "Falsche Eingabe!" );
			menue( );
		}
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
