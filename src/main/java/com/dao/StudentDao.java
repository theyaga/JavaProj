package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.model.Stud;
import com.model.Student;
import com.mysql.jdbc.Statement;


@Repository 
public class StudentDao {
	public void createStudent( Student student) throws ClassNotFoundException, SQLException, InvalidMobileNumberException{
		 PreparedStatement stmt = null;
		 String regex = "\\d+";
		 if(!student.getMobile().matches(regex)){
			 throw new InvalidMobileNumberException("Mobile number should be numbers");
		 }
		Connection conn=new Stud().getConnection();
		
				System.out.println("Inserting records into the table...");
		
	      String sql = "INSERT INTO student(id,firstname,lastname,mobilenumber)VALUES(?, ?, ?, ?)";
	      stmt = conn.prepareStatement(sql); 
	      stmt.setInt(1,student.getId());
	      stmt.setString(2, student.getFirstName());
	      stmt.setString(3,student.getLastName());
	      stmt.setString(4, student.getMobile());
	      stmt.execute();
	      System.out.println("Records are inserted");
	
}
	public Student getId(int id) throws ClassNotFoundException, SQLException{
		
      java.sql.Statement statement=null;
	  Student student=new Student();
	  Connection conn=new Stud().getConnection();
	  String query="Select * from student where id= '"+id+"'";
	  
	 
	  
	  statement = conn.createStatement();
	  ResultSet rs = statement.executeQuery(query);
		
	  
	  while (rs.next()) {
		
		    
	  	student.setId(rs.getInt("id"));
	  	student.setFirstName(rs.getString("firstname"));
	  	student.setLastName(rs.getString("lastname"));
	  	student.setMobile(rs.getString("mobilenumber"));
	  
	  }
	return student;
	  
	  
	}
	
	
	}
