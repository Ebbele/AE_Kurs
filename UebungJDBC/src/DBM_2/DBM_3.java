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
	
	String[] dateEingeben(){
		
		String []insert=new String[5];
		
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
		
		return insert;
	}
	
	void insertElement(String[] insert){		
		try {
			String query="Insert into Customer (ID,firstname, lastname, street,city) VALUES(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1,insert[0]);
			ps.setString(2, insert[1]);
			ps.setString(3, insert[2]);
			ps.setString(4, insert[3]);
			ps.setString(5, insert[4]);
			
			int i=ps.executeUpdate();
			if(i==1)
				System.out.println(i+" Datensatz ge‰ndert");
			
			ps.close();
			sc.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void deleteElement(int id){
		try{
			id=Integer.parseInt(sc.nextLine());
			stmt.executeUpdate("DELETE FROM Customer WHERE ID="+id);
		}
		catch(SQLException e) {
			e.getStackTrace();
		}
		catch(NumberFormatException e){
			e.getStackTrace();
		}
		sc.close();
	}
	
	void updateDatabase(int id,String[]insert){
		try{			
				//int id=Integer.parseInt(sc.nextLine());
				String query=	("UPDATE Customer set id=?,Firstname=?, lastname=?, street=?, city=? WHERE ID=?");
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,insert[0]);
				ps.setString(2, insert[1]);
				ps.setString(3, insert[2]);
				ps.setString(4, insert[3]);
				ps.setString(5, insert[4]);
				ps.setString(6, insert[0]);
				ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(NumberFormatException e){
			e.getStackTrace();
		}
	}

	void searchElement(String id){
		String query="select * from Customer where Id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, id);
			setRs(ps.executeQuery());
			while(getRs().next()){
				
				System.out.println(getRs().getString(1)+" "+getRs().getString(2)+" "+getRs().getString(3)+" "+getRs().getString(4)+" "+getRs().getString(5));
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	void menue(){
		System.out.println("***********************");
		System.out.println("****1: Alles Zeigen****");
		System.out.println("****2: Search**********");
		System.out.println("****3: Insert**********");
		System.out.println("****4: Delete**********");
		System.out.println("****5: Update**********");
		System.out.println("***********************");
		
	}
}
