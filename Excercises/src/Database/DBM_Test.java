package Database;

public class DBM_Test {
	
	public static void main ( String[ ] args ) {
		
		
		DBM_1 test = new DBM_1( );
		
		test.loadDriver( );
		test.connectDB( );
		test.dbQuery( );
		test.showQuery( );
	}
}
