package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;


@Entity
@Table(name = "StudentEntity")
public class StudentEntity {

	@Id
	@GeneratedValue
	@Column(name = "studentId")
	private int studentId;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "class")
	private String studentClass;

	@Column(name = "email")
	private String email;

	@Column(name = "rollNumber")
	private String rollNumber;
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
	
}
