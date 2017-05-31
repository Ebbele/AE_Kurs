package DBM_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

public class DBM_3 {
	Connection con = null;
	Statement stmt;
	ResultSet rs;
	Scanner sc=new Scanner(System.in);
	

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

	String [] insertElement(){
		
		String []insert=new String[5];
		
		try {
			System.out.println("ID: ");
			insert[0]=sc.nextLine();
			
			System.out.println("Vorname: ");
			insert[1]=sc.nextLine();
			
			System.out.println("Nachname: ");
			insert[2]=sc.nextLine();
			
			System.out.println("Straﬂe + NR: ");
			insert[3]=sc.nextLine();
			
			System.out.println("Stadt: ");
			insert[4]=sc.nextLine();
			
			//PreparedStatement ps=con.prepareStatement("Insert into Customer " + "VALUES(?,?,?,?)");
			String query=" Insert into Customer (id, firstname, lastname, street, city + " values(?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(query);
					
			ps.setString(1, insert[0]);
			ps.setString(2, insert[1]);
			ps.setString(3, insert[2]);
			ps.setString(4, insert[3]);
			ps.setString(5, insert[4]);
			
			ps.executeUpdate();
			ps.close();
			//stmt.executeUpdate("INSERT INTO Customer " + "VALUES ('52','Boogie','Man','Weg Weger','Wegberg')");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return insert;
	}
	
	void deleteElement(int id){
		try{
			stmt.executeUpdate("DELETE FROM Customer WHERE ID="+id);
		}
		catch(SQLException e) {
			
		}
	}
	void updateDatabase(){
		try{
			stmt.executeUpdate("UPDATE Customer set Firstname='Anita' WHERE ID=1");
		}
		catch(SQLException e) {
			
		}
	}

	void menue(){
		System.out.println("Alles Zeigen/Insert/Delete/Update");
		
	}
}
