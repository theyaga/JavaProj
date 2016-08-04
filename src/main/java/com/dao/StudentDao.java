package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Stud;
import com.model.Student;

@Repository
public class StudentDao {

	//Method to insert the values to database
	public void createStudent(Student student) throws ClassNotFoundException,
			SQLException, InvalidMobileNumberException {
		PreparedStatement stmt = null;
		String regex = "\\d+";
		if (!student.getMobile().matches(regex)) {
			throw new InvalidMobileNumberException(
					"Mobile number should be numbers");
		}
		Connection conn = new Stud().getConnection();

		System.out.println("Inserting records into the table...");

		String sql = "INSERT INTO student(id,firstname,lastname,mobilenumber)VALUES(?, ?, ?, ?)";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, student.getId());
		stmt.setString(2, student.getFirstName());
		stmt.setString(3, student.getLastName());
		stmt.setString(4, student.getMobile());
		stmt.execute();
		System.out.println("Records are inserted");

	}

	//To get the id and display its details
	public Student getId(int id) throws ClassNotFoundException, SQLException {

		java.sql.Statement statement = null;
		Student student = new Student();
		Connection conn = new Stud().getConnection();
		String query = "Select * from student where id= '" + id + "'";

		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(query);

		studentTranslator(student, rs);
        System.out.println(student);
		return student;

	}
	// Resultset 
	private Student studentTranslator(Student student, ResultSet rs)
			throws SQLException {
		while (rs.next()) {

			student.setId(rs.getInt("id"));
			student.setFirstName(rs.getString("firstname"));
			student.setLastName(rs.getString("lastname"));
			student.setMobile(rs.getString("mobilenumber"));
		}
		return student;
	}
	//Display the values in the database
	public List<Student> displayStudentName() throws ClassNotFoundException,
			SQLException {
		java.sql.Statement statement = null;
		List<Student> students = new ArrayList<Student>();
		Connection conn = new Stud().getConnection();
		String query = "Select * from student";
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(query);

		
		//Adding Resultset to list
		while (rs.next()) {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setFirstName(rs.getString("firstname"));
			student.setLastName(rs.getString("lastname"));
			student.setMobile(rs.getString("mobilenumber"));
			students.add(student);

		}

		return students;

	}

}
