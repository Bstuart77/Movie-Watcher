package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utilities {

	public static Connection connect() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/moviesandshows", "root","Mydickisitchy12");
			return conn;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean closeConnection(Connection conn) {
		if (conn != null) { // there IS a connection
			try {
				conn.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return false;
		}
		return false;
	}
}
