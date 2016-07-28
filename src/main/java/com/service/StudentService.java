package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.model.Stud;
import com.model.Student;


@Service
public class StudentService {
@Autowired
StudentDao dao;
	public void createStudent( Student student) throws ClassNotFoundException, SQLException{
		 
		 
		 dao.createStudent(student);

	}
	
	
	
}
