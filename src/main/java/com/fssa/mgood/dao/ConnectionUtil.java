package com.fssa.mgood.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {

		Connection con = null;
		String url = "jdbc:mysql://localhost/mgood";
		String userName = "root";
		String passWord = "12345678";
		con = DriverManager.getConnection(url, userName, passWord);

		return con;

	}

}
