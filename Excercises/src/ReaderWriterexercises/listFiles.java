package ReaderWriterexercises;
import java.io.File;

public class listFiles {

	public static void erstelleVerzeichnisListeUndGebeAus( File directories ) {

		File[ ] files = directories.listFiles( );
		
		if ( files != null ) { 
			
			for ( int i = 0; i < files.length; i++ ) { 
				 
				if (files[ i ].isDirectory( ) ) { 
						
					String s = files[ i ].getAbsoluteFile( ).toString( );
					System.out.println("[" + s.substring( 3, s.length( ) ) + "]");
				} 
			} 
		}
	}
	
	public static void erstelleDateiListeUndGebeAus( File file ) {

		File[ ] files = file.listFiles( );
		
		if ( files != null ) { 
			
			for ( int i = 0; i < files.length; i++ ) { 
				 
				if (files[ i ].isFile( ) ) { 
						
					String s = files[ i ].getAbsoluteFile( ).toString( );
					System.out.println( s.substring( 3, s.length( ) ) );
				} 
			} 
		}
	}
	
	public static void findFile( String pfad, String dateiName ) {
		
		File file = new File( pfad );
		File[ ] files = file.listFiles( );
		
			if ( files != null ) {
				
				for ( int i = 0; i < files.length; i++ ) {
					
					String s = files[ i ].getAbsoluteFile( ).toString( );
					
					if ( s.substring( 3, s.length( ) ).equals( dateiName ) ) {
						
						System.out.println( "Treffer: " + files[ i ] );
					}
				}
			}
	}
	
	public static void main( String [ ] args) {
		
		File files = new File( "C:/" );
		
		erstelleVerzeichnisListeUndGebeAus( files );
		erstelleDateiListeUndGebeAus( files );
		
		String pfad = files.getAbsolutePath( ).toString( );
		String dateiName = ( "test.java" );
		findFile( pfad, dateiName );
	}	
}
