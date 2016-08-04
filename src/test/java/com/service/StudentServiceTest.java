package com.service;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Random;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.dao.StudentDao;
import com.model.Student;

public class StudentServiceTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createStudentAllValueTest() throws ClassNotFoundException,
			SQLException {

		try {
			StudentDao studentDao = new StudentDao();

			// creating Student with all required values

			Student student = new Student();
			student.setId(new Random().nextInt(100) + 50);
			student.setFirstName("rajan");
			student.setLastName("rajan");
			student.setMobile("9012897632");

			studentDao.createStudent(student);

		} catch (Exception e) {
			System.out.println(e.getClass());
			fail();

		}

	}
}
