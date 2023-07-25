package com.jsp.student_crud_with_prepared.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentConnection {
	public static Connection getStudentConnection() {
		try {
			// step-1 load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 create connection
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "RootPassword";

			Connection connection = DriverManager.getConnection(url, user, pass);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
