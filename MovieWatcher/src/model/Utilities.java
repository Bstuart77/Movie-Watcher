package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Utilities {

	@SuppressWarnings("resource")
	public static Connection connect() throws ClassNotFoundException, SQLException, FileNotFoundException {

		File file = new File("info/pw.txt");
		Scanner input = new Scanner(file);

		String pw = input.nextLine();

		file = new File("info/user.txt");
		input = new Scanner(file);

		String user = input.nextLine();

		file = new File("info/connect.txt");
		input = new Scanner(file);

		String connection = input.nextLine();

		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection(connection, user, pw);
			return conn;

		} catch (Exception e) {
			e.printStackTrace();
		}

		input.close();

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
