package com.jsp.student_crud_with_prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.student_crud_with_prepared.connection.StudentConnection;
import com.jsp.student_crud_with_prepared.dto.Student;

public class StudentDao {
	Connection connection =StudentConnection.getStudentConnection();

/*
 * insert method for student
 */
	public Student insertStudent(Student student) {
		String insertQuery ="insert into student values(?,?,?,?)";
		
		try {
			PreparedStatement preparedstatement=connection.prepareStatement(insertQuery);
			
			preparedstatement.setInt(1, student.getStudentId());
			preparedstatement.setString(2, student.getStudentName());
			preparedstatement.setString(3, student.getStudentEmail());
			preparedstatement.setLong(4, student.getStudentPhone());
			preparedstatement.execute();
			
			System.out.println("Data Inserted");
			return student;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}/*Method insert ended*/
	/*
	 * update student data methods
	 */
	public int updateStudentName(int studentId, String studentName) {

		String updateStudentNameQuery = "update student set name=? where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateStudentNameQuery);

			preparedStatement.setInt(2, studentId);
			preparedStatement.setString(1, studentName);

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public void displayStudentDetails() {
		
		String displayStudentQuery = "SELECT * FROM student";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(displayStudentQuery);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				
				int id=resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				long phone = resultSet.getLong("phone");
				
				System.out.println("id = "+id);
				System.out.println("name = "+name);
				System.out.println("email = "+email);
				System.out.println("phone = "+phone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * delete method
	 */
	public int deleteStduentById(int studentId) {
		
		return 0;
	}
}









