package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.validations.StudentValidator;

@RestController
@RequestMapping("demo")
@Validated
public interface DemoController {

	/**
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/student", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<Student>> getAllStudent(HttpServletRequest request);

	/**
	 * @param request
	 * @param rollNum
	 * @return
	 */
	@RequestMapping(value = "/student/{rollNum}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Student> getStudentByRollNum(HttpServletRequest request, @PathVariable("rollNum") String rollNum);

	/**
	 * 
	 * @param student
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/student", produces = { "application/json" })
	ResponseEntity<Student> addStudent(@StudentValidator @RequestBody Student student, HttpServletRequest request);

}
