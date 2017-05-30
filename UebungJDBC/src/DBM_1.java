import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBM_1 {
	
	Connection con = null;
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	Statement stmt;
	ResultSet rs;
	
	void loadDriver(){
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
	
	void connectDB()
	{
	    try
	    {
	      this.con = DriverManager.getConnection( "jdbc:hsqldb:file:C:/Users/lrumpel/Documents/Anwendungsentwicklung/hsqldb-2.3.3/DB;shutdown=true", "sa", "" );
	    }
	    catch ( SQLException e )
	    {
	      e.printStackTrace();
	    }
	}
	
	void dbQuery(){
		  try 
		  {
			this.stmt = this.con.createStatement();
			rs = stmt.executeQuery( "SELECT * FROM Customer" );
		  } 
		  catch (SQLException e) 
		  {			  		
			e.printStackTrace();
		}
	}
	void showQuery(){
		 try {
			while ( rs.next() )
			        System.out.printf( "%s, %s %s%n", rs.getString(1),
			        		rs.getString(2),rs.getString(3) );
		 }catch (SQLException e) 
		 {
			e.printStackTrace();
		}
	}
}


