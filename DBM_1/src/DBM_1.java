import java.sql.*;


public class DBM_1 {

	Connection con;
	public void loadDriver() {
		 try
		    {
		      Class.forName( "org.hsqldb.jdbcDriver" );
		    }
		    catch ( ClassNotFoundException e )
		    {
		      System.err.println( "Keine Treiber-Klasse!" );
		      return;
		    }
	}
	
	public void connectDB() {
		con = null;
		try
	    {
			con = DriverManager.getConnection( "jdbc:hsqldb:file:C:\\Users\\jerbsloeh\\Google Drive\\TutegoDB\\TutegoDB;shutdown=true", "sa", "" );
	      Statement stmt = con.createStatement();

//	      stmt.executeUpdate( "INSERT INTO CUSTOMER VALUES(50,'Christian','Ullenboom','Immengarten 6','Hannover')" );

	      ResultSet rs = stmt.executeQuery( "SELECT * FROM Customer" );

	      while ( rs.next() )
	        System.out.printf( "%s, %s %s%n", rs.getString(1),
	                           rs.getString(2), rs.getString(3) );

	      rs.close();

	      stmt.close();
	    }
	    catch ( SQLException e )
	    {
	      e.printStackTrace();
	    }
	    finally
	    {
	      if ( con != null )
	        try { con.close(); } catch ( SQLException e ) { e.printStackTrace(); }
	    }
	}
	
	public void dbQuery() {
		
	}
	
	public Connection showQuery() {
		return this.con;
	}
}
