package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.controller.DemoController;
import com.example.demo.entity.StudentEntity;
import com.example.demo.exceptions.StudentAlreadyExistsException;
import com.example.demo.exceptions.StudentNotFoundException;
import com.example.demo.mapper.DemoMapper;
import com.example.demo.model.Student;
import com.example.demo.repository.service.StudentEntityService;

@Service
public class DemoService implements DemoController {

	@Autowired
	StudentEntityService studentEntityService;

	@Autowired
	DemoMapper demoMapper;

	@Override
	public ResponseEntity<List<Student>> getAllStudent(HttpServletRequest request) {
		Student student = new Student();
		List<Student> studentList = new ArrayList<>();
		List<StudentEntity> sample = studentEntityService.getAllStudents();
		for (StudentEntity studentEntity : sample) {
			student = demoMapper.toStudent(studentEntity);
			studentList.add(student);
		}

		return new ResponseEntity<>(studentList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> getStudentByRollNum(HttpServletRequest request, String rollNum) {
		Student student = new Student();
		StudentEntity entity = studentEntityService.getById(rollNum);
		if (null != entity) {
			student = demoMapper.toStudent(entity);

		} else {
			throw new StudentNotFoundException("user not found");
		}
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> addStudent(Student student, HttpServletRequest request) {
		try {
			studentEntityService.createUser(demoMapper.toStudentEntity(student));
		} catch (Exception e) {
			if(e.getMessage().contains("roll_number_UNIQUE")) {
				throw new StudentAlreadyExistsException("Student with same roll number already exists");
			}
		}
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

}
