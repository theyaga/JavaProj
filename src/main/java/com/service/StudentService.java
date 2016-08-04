package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.InvalidMobileNumberException;
import com.dao.StudentDao;
import com.model.Student;


@Service
public class StudentService {
@Autowired
StudentDao dao;
	public void createStudent( Student student) throws ClassNotFoundException, SQLException, InvalidMobileNumberException{
		 
		 
		 dao.createStudent(student);

	}
	
	public List<Student> getStudentList() throws ClassNotFoundException, SQLException
	{
				return dao.displayStudentName();
		
	}
	
	public Student Getid( int id) throws ClassNotFoundException, SQLException, InvalidMobileNumberException{
		 
		// System.out.println("Service:"+id);
		
		return dao.getId(id);

	}

}
