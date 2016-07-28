package com.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;






import com.model.Student;
import com.service.StudentService;

@Controller

public class StudentController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String FormDisplay(Model model) {
	    model.addAttribute("student", new Student()); // the Category object is used as a template to generate the form
	    return "index"; 
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String createStudent( @ModelAttribute("student") Student student,
			 BindingResult result, ModelMap model
            ) throws ClassNotFoundException, SQLException{
		
		System.out.println("Student : "+student.getFirstName());
		
			studentService.createStudent(student);
		  if (result.hasErrors()) {
	            return "error";
	        }
	        model.addAttribute("id", student.getId());
	        model.addAttribute("firstName",student.getFirstName());
	        model.addAttribute("lastName", student.getLastName());
	        model.addAttribute("mobile", student.getMobile());
	        return "display";
	}
}
