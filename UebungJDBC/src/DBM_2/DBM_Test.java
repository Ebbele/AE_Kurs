package DBM_2;

import java.sql.SQLException;

public class DBM_Test {
	public static void main(String[] args) {

		DBM_2 dbm=new DBM_2();
		dbm.loadDriver();
		dbm.connectDB();
		dbm.dbQuery();
	//	
	//	dbm.insertElement();
		
		dbm.deleteElement();
		dbm.dbQuery();
		dbm.showQuery();
		
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
