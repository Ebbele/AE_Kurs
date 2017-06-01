import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBM_4 extends DBM_1 {
	public static int insertElement(Connection conn, String values[]) {

		ResultSet rowCount;
		rowCount = DBM_1.dbQuery(conn, "SELECT MAX(id) FROM customer");
		int newID = 0;
		try {
			rowCount.first();
			newID = rowCount.getInt(1) + 1;
		} catch (SQLException except2) {
			// TODO Auto-generated catch block
			except2.printStackTrace();
		}
		try {
			rowCount.close();
		} catch (SQLException except2) {
			// TODO Auto-generated catch block
			except2.printStackTrace();
		}
		String sql = "INSERT INTO customer VALUES(" + newID + "," + "'" + values[0] + "','" + values[1] + "','"
				+ values[2] + "','" + values[3] + "');";
		int res = -1;
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?)");// createStatement();
			stmt.setInt(1, newID);
			stmt.setString(2, values[0]);
			stmt.setString(3, values[1]);
			stmt.setString(4, values[2]);
			stmt.setString(5, values[3]);
			res = stmt.executeUpdate();//sql);
		} catch (SQLException except) {
			System.out.println(except.getMessage());
			try {
				conn.close();
			} catch (SQLException except1) {
				// TODO Auto-generated catch block
				except1.printStackTrace();
			}
		}
		return res;
	}

	public static int deleteElement(Connection conn, int eleId) {
		String sql = "DELETE FROM customer WHERE id = " + eleId + ";";
		int res = -1;
		try {
			Statement stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
		} catch (SQLException execpt) {
			System.err.println(execpt.getMessage());
		}
		return res;
	}

	public static int updateDatabase(Connection conn, int id, String values[]) {
		String sql = "UPDATE customer SET firstname = '" + values[0] + "', lastname = '" + values[1] + "', street = '"
				+ values[2] + "', city = '" + values[3] + "' WHERE id = " + id + ";";
		int res = -1;
		try {
			Statement stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
		} catch (SQLException execpt) {
			System.err.println(execpt.getMessage());
		}
		return res;
	}
}
