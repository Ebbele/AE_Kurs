package DBM_2;

import java.sql.SQLException;
import java.util.*;

public class DBM_Test {
	public static void main(String[] args) {

		DBM_3 dbm=new DBM_3();
		dbm.loadDriver();
		dbm.connectDB();
		dbm.dbQuery();
		
		dbm.menue();
		
	//	dbm.insertElement(dbm.dateEingeben());
		
		//dbm.deleteElement(48);
		Scanner sc=new Scanner(System.in);
		System.out.println("Welche ID Möchten sie Updaten/suchen/löschen");
		
		//int i=Integer.parseInt(sc.nextLine());
		//String s=sc.nextLine();
		//dbm.updateDatabase(i,dbm.dateEingeben());
		//dbm.searchElement(s);
		
		//dbm.dbQuery();
		//dbm.showQuery();
		
		try {
			dbm.getRs().close();
			dbm.getStmt().close();
			dbm.getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
