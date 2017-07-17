package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBM_1 {
	
	private ResultSet rs;
	private Statement stmt;
	private Connection con;
	
	public void loadDriver( ) {
	    
		try {
	      
	    	Class.forName( "org.hsqldb.jdbcDriver" );
	    }
	    catch ( ClassNotFoundException e ) {
	      
	    	System.err.println( "Keine Treiber-Klasse!" );
	    	return;
	    }
		
	}
	
	public void connectDB ( ) {
		
		try {
	    
			this.con = DriverManager.getConnection( "jdbc:hsqldb:file:c:\\users\\anwender\\desktop\\tutegodb\\tutegodb;shutdown=true", "sa", "" );
	    }
	    catch ( SQLException e ) {
	    	
	      e.printStackTrace( );
	    }
	}

	
	public void dbQuery( ) {
		
		try {
			
			this.stmt = this.con.createStatement( );
			this.rs = this.stmt.executeQuery( "SELECT * FROM Customer" );
		} catch ( SQLException e ) {
			
			e.printStackTrace( );
		}
	}
	
	public void showQuery( ) {
	      
		try {
			while ( this.rs.next() ) {
				
				System.out.printf( "%s, %s %s%n", this.rs.getString(1),
				this.rs.getString(2), this.rs.getString(3) );
			}
			} catch ( SQLException e) {
				
				e.printStackTrace();
			}
		} 
	}


