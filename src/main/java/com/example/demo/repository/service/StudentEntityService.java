package com.example.demo.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentEntityService {

	@Autowired
	StudentRepository studentRepository;

	public List<StudentEntity> getAllStudents() {
		return studentRepository.findAll();
	}

	public StudentEntity getById(String rollNum) {
		return studentRepository.findById(rollNum);
	}

	// Just adding flexibility if 2 transactions from the service layer and made one
	// is succeeded
	// and other is failed you want to revert old transaction
	/*
	 * @param student
	 * 
	 * @return
	 */
	public StudentEntity createUser(StudentEntity student) throws Exception {
		StudentEntity studentEntity = null;
		try {
			studentEntity = studentRepository.save(student);
		} catch (Exception dIViolation) {
			throw new Exception(dIViolation);
		}
		return studentEntity;
	}

}
