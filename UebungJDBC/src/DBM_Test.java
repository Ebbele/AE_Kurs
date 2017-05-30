import java.sql.SQLException;

public class DBM_Test {

	public static void main(String[] args) {

		DBM_1 dbm=new DBM_1();
		dbm.loadDriver();
		dbm.connectDB();
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
