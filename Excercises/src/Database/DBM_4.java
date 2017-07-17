package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBM_4 {
	
	ResultSet rs;
	Statement stmt;
	Connection con;
	
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
	    
			this.con = DriverManager.getConnection( "jdbc:hsqldb:file:c:\\users\\bkerkes\\desktop\\tutegodb\\tutegodb;shutdown=true", "sa", "" );
	    }
	    catch ( SQLException e ) {
	    	
	      e.printStackTrace( );
	    }
	}

	
	public ResultSet dbQuery( ) {
		
		try {
			
			this.stmt = this.con.createStatement( );
			this.rs = this.stmt.executeQuery( "SELECT * FROM Customer" );
		} catch ( SQLException e ) {
			
			e.printStackTrace( );
		}
		return rs;
	}
	
	public String dbQueryMaxId( ) {
		
		String puffer = "";
		try {
			
			this.stmt = this.con.createStatement( );
			this.rs = this.stmt.executeQuery( "	SELECT MAX( ID )  FROM Customer " );
			rs.next( );
			puffer = rs.getString( 1 );
		} catch ( SQLException e ) {
			
			e.printStackTrace( );
		}
		return puffer;
	}

	

	
	public ResultSet dbQuery ( String suche ) {
		
		try {
			
			PreparedStatement pstmt = this.con.prepareStatement(
					"SELECT * FROM Customer WHERE ID LIKE ? OR FIRSTNAME LIKE ? OR LASTNAME LIKE ? OR STREET LIKE ? OR CITY LIKE ?" );
			
			for (int i = 1; i < 6; i++ ) {			
				
				pstmt.setString( i, suche );
			}

			this.rs = pstmt.executeQuery( );
			
		} catch ( SQLException e ) {
			
			e.printStackTrace( );
		}
		return rs;
	}
	
	public void showQuery( ) {
	      
		try {
			while ( this.rs.next( ) ) {
				
				System.out.printf( "%s, %s %s%n", this.rs.getString(1),
				this.rs.getString(2), this.rs.getString(3) );
			}
		} catch ( SQLException e) {
				
			e.printStackTrace( );
		}
	} 
	
	public void insertElement( String[ ] input ) {
		
		try {
			
			PreparedStatement pstmt = this.con.prepareStatement( "INSERT INTO Customer VALUES ( ?, ?, ?, ?, ? )" );
			for (int i = 1; i < 6; i++ ) {			
				
				pstmt.setString( i, input[ i - 1 ] );
			}
			pstmt.executeUpdate( );

		} catch ( SQLException e ) {
			
			e.printStackTrace( );
		}
	}
	
	public void changeDS( String id, String[] input ) {
		
		int confirm = 0;
		
		try {
			
			PreparedStatement pstmt = this.con.prepareStatement( "UPDATE Customer SET FIRSTNAME = ?, LASTNAME = ?, STREET = ?, CITY = ? WHERE ID = ?" );
			
			for (int i = 1; i < 5; i++ ) {			
				
				pstmt.setString( i, input[ i - 1 ] );
			}
			pstmt.setString( 5, id );
			confirm = pstmt.executeUpdate( );
			if ( confirm == 1 ) {
				
				System.out.println( "Datensatz wurde gelaendert." );
			}
		} catch ( SQLException e ) {
			
			e.printStackTrace( );
		}
	}
	public void deleteElement( String id ) {
		
		try {
			int confirm = 0;
			PreparedStatement pstmt = this.con.prepareStatement(
					"DELETE FROM Customer WHERE ID = ?" );
			pstmt.setString( 1, id );
			confirm = pstmt.executeUpdate( );
			if ( confirm == 1 ) {
				
				System.out.println( "Datensatz wurde geloescht." );
			}
		} catch ( SQLException e ) {
			
			e.printStackTrace( );
		}
	}
}
