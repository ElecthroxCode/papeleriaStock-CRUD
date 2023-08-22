package stockPapeleria.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {

	private static final String URL = "jdbc:mysql://localhost:3306/dbpapeleria?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "";
	private static Connection con = null;
	public static Connection getConnection() throws SQLException {
		
		if(con == null || con.isClosed()) {
			con = DriverManager.getConnection(URL, USER, PASS);
		}
		return con;
	}
	
}
