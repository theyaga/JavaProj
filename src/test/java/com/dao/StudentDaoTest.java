package com.dao;

import java.sql.SQLException;
import java.util.Random;

import junit.framework.Assert;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.FailingInstantiator;

import com.model.Student;
import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;



public class StudentDaoTest {
	 @Rule
     public ExpectedException thrown= ExpectedException.none();
	@Test
	public void createStudentAllValueTest() throws ClassNotFoundException, SQLException{
		
		try{
		StudentDao studentDao=new StudentDao();
		
		//creating Student with all required values 
		
		Student student =new Student();
		student.setId(new Random().nextInt(100) + 50);
		student.setFirstName("rajan");
		student.setLastName("rajan");
		student.setMobile("9012897632");
		
		
		studentDao.createStudent(student);
		Student dbStudent = null ;
		dbStudent=studentDao.getId(student.getId());
		 Assert.assertEquals(student.getFirstName(),dbStudent.getFirstName());
	        Assert.assertEquals(student.getLastName(), dbStudent.getLastName() );
	        Assert.assertEquals(student.getMobile(),dbStudent.getMobile());

		}
		catch(Exception e){
			System.out.println(e.getClass());
			fail();
			
			
		}
		
		
		
	}
	@Test
public void createStudentNotNullTest() throws ClassNotFoundException, SQLException, InvalidMobileNumberException{
		
		thrown.expect(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException.class);
		StudentDao stu=new StudentDao();
		//Student without Required Fields
		Student student =new Student();

		student.setMobile("9012897632");
		stu.createStudent(student);
		fail();
		}
		
	
	@Test
	public void createStudentMobileNumSizeTest() throws ClassNotFoundException, SQLException, InvalidMobileNumberException{
			
			thrown.expect(MysqlDataTruncation.class);
			StudentDao stu=new StudentDao();
			//Student Mobile Number Size Mismatch
			Student student =new Student();
		
			student.setId(new Random().nextInt(100) + 50);
			student.setFirstName("Stepehen ");
			student.setLastName("Jeyaraj  ");
			student.setMobile("901289763211111111");
			
			stu.createStudent(student);
			
			fail();
			
		}
	@Test
	public void createStudentPrimaryKeyTest() throws ClassNotFoundException, SQLException, InvalidMobileNumberException{
			
			thrown.expect(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException.class);
			StudentDao stu=new StudentDao();
			//Student with same id
			Student student =new Student();


			
			student.setId(100);
			student.setFirstName("Stepehen ");
			student.setLastName("Jeyaraj  ");
			student.setMobile("9012897632");
			
			stu.createStudent(student);
			fail();
			
		}
	
	@Test
	public void createStudentMobileValidationTest() throws ClassNotFoundException, SQLException, InvalidMobileNumberException{
			
			thrown.expect(InvalidMobileNumberException.class);
			StudentDao stu=new StudentDao();
			//Student mobile validation
			Student student =new Student();


			
			student.setId(new Random().nextInt(100) + 50);
			student.setFirstName("Stepehen ");
			student.setLastName("Jeyaraj  ");
			student.setMobile("9012897a32");
			
			stu.createStudent(student);
			fail();
			
		}
	
	
}
