package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Stud {

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/javadb?autoReconnect=true&amp;relaxAutoCommit=true ";
		Class.forName("org.gjt.mm.mysql.Driver");

		return DriverManager.getConnection(url, "root", "thygu");

	}

}
