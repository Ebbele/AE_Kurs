import java.sql.Connection;
import java.sql.SQLException;

public class DBM_Test_4 {

	public static void main(String[] args) {
		DBM_Menu menu = new DBM_Menu();
		
		int toDo = -1;
		
		Connection connection = DBM_1.connectDB("uebung_1/database", "SA", null);
		while(( toDo = menu.getCommand() ) != 6 ){
			menu.runCmd(toDo, connection);
		}
		
		try {
			connection.close();
		} catch (SQLException except) {
			// TODO Auto-generated catch block
			except.printStackTrace();
		}finally{
			System.out.println("Programm beendet ...");
		}
	}

}
