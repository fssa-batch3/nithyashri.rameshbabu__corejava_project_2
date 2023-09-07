package com.fssa.mgood.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private ConnectionUtil() {
		
	}
	public static Connection getConnection()  {
		String DBURL;
		String DBUSER;
		String DBPASSWORD;


//		dbUrl = System.getenv("DB_URL"); 
//		dbUser = System.getenv("DB_USER");
//		dbPassword = System.getenv("DB_PASSWORD");
		
		DBURL = "jdbc:mysql://localhost:3306/nithyashri_rameshbabu_corejava_project";;
		DBUSER = "root";
		DBPASSWORD = "12345678";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException("Unable to connect database", e);
		} catch (ClassNotFoundException e) {
			
			throw new RuntimeException("Database driver class not found", e);
		}

	}

}
