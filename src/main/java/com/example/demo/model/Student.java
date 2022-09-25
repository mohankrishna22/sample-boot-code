package com.example.demo.model;

import com.google.gson.Gson;

public class Student {

	public String name;

	public int age;

	public String studentClass;

	public String email;

	public String rollNum;

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

	public String getRollNum() {
		return rollNum;
	}

	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}

	public String toString() {
		return new Gson().toJson(this);
	}

}
