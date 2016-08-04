package com.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.InvalidMobileNumberException;
import com.model.Student;
import com.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	//Display values in the Database
	@RequestMapping(value = "/create", params = "Display", method = RequestMethod.POST)
	public String Display(@ModelAttribute("student") Student student,
			BindingResult result, Map<String, Object> model)
			throws ClassNotFoundException, SQLException {
		
		// System.out.println("****");
		model.put("student", studentService.getStudentList());
		// System.out.println("****"+studentService.getStudentList().get(1).getFirstName());

		return "DisplayStudentName";
	}
	//Inserting Student data into database
	@RequestMapping(value = "/create", params = "Submit", method = RequestMethod.GET)
	public String createStudent(@ModelAttribute("student") Student student,
			BindingResult result, ModelMap model)
			throws ClassNotFoundException, SQLException,
			InvalidMobileNumberException {

		 //System.out.println("Student Create ");

		studentService.createStudent(student);
		if (result.hasErrors()) {
			return "error";
		}
		model.addAttribute("id", student.getId());
		model.addAttribute("firstName", student.getFirstName());
		model.addAttribute("lastName", student.getLastName());
		model.addAttribute("mobile", student.getMobile());
		return "display";
	}
	//To load the Index page
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String FormStart(Model model) {
		model.addAttribute("student", new Student());
		return "index";
	}
	//Gets id on clicking the table and display the selected details
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getid(@RequestParam(value = "Id") int id,Student student,
			ModelMap model) throws ClassNotFoundException, SQLException,
			InvalidMobileNumberException {

		//System.out.println(id);
	    student = studentService.Getid(id);
	    System.out.println(student.getMobile());
		model.addAttribute("id", student.getId());
		model.addAttribute("firstName", student.getFirstName());
		model.addAttribute("lastName", student.getLastName());
		model.addAttribute("mobile", student.getMobile());
		return new ModelAndView("display",model);

	}
	
}
