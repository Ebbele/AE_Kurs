package DBM_2;

import java.sql.SQLException;

public class DBM_Test {
	public static void main(String[] args) {

		DBM_3 dbm=new DBM_3();
		dbm.loadDriver();
		dbm.connectDB();
		dbm.dbQuery();
		
		dbm.insertElement();
		
		//dbm.deleteElement(48);
		//dbm.updateDatabase();
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
