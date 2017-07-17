package Database;

public class DBM_Test_2 {
	
	public static void main ( String[ ] args ) {
		
		
		DBM_2 test = new DBM_2( );
		
		test.loadDriver( );
		test.connectDB( );
		test.dbQuery( );
		test.showQuery( );
		
		System.out.println( "-----------------------" );
		
		test.insertElement( );
		test.dbQuery( );
		test.showQuery( );		
		test.updateDatabase( );

		System.out.println( "-----------------------" );
		
		test.deleteElement( );		
		test.dbQuery( );
		test.showQuery( );
	}
}
