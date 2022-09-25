package com.example.demo.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import com.example.demo.model.Student;

public class StudentValidatorImpl implements ConstraintValidator<StudentValidator, Student> {

	@Override
	public boolean isValid(Student student, ConstraintValidatorContext context) {
		HibernateConstraintValidatorContext hibernateContext = context
				.unwrap(HibernateConstraintValidatorContext.class);
		if (student != null) {
			if (!validateName(student, hibernateContext)) {
				return false;
			}
			if (!validateEmail(student, hibernateContext)) {
				return false;
			}
			if (!validateRollNum(student, hibernateContext)) {
				return false;
			}
			if (!validateClass(student, hibernateContext)) {
				return false;
			}
			if (!validateAge(student, hibernateContext)) {
				return false;
			}
		}
		return true;
	}

	private boolean validateAge(Student student, HibernateConstraintValidatorContext hibernateContext) {
		if (student.getAge() == 0) {
			hibernateContext.addMessageParameter("0", student.getAge());
			addConstraintViolation(hibernateContext, "Name is mandatory");
			return false;
		}
		return true;
	}

	private boolean validateClass(Student student, HibernateConstraintValidatorContext hibernateContext) {
		if (student.getStudentClass() == null) {
			hibernateContext.addMessageParameter("0", student.getStudentClass());
			addConstraintViolation(hibernateContext, "Class number is mandatory");
			return false;
		}
		return true;
	}

	private boolean validateRollNum(Student student, HibernateConstraintValidatorContext hibernateContext) {
		if (student.getRollNum() == null) {
			hibernateContext.addMessageParameter("0", student.getRollNum());
			addConstraintViolation(hibernateContext, "Roll Number is mandatory");
			return false;
		}
		return true;
	}

	private boolean validateEmail(Student student, HibernateConstraintValidatorContext hibernateContext) {
		if (student.getEmail() == null) {
			hibernateContext.addMessageParameter("0", student.getEmail());
			addConstraintViolation(hibernateContext, "Name is mandatory");
			return false;
		}
		return true;
	}

	private boolean validateName(Student student, HibernateConstraintValidatorContext hibernateContext) {
		if (student.getName() == null) {
			hibernateContext.addMessageParameter("0", student.getName());
			addConstraintViolation(hibernateContext, "Name is mandatory");
			return false;
		}
		return true;
	}

	private static void addConstraintViolation(HibernateConstraintValidatorContext hibernateContext, String errorCode) {
		hibernateContext.disableDefaultConstraintViolation();
		hibernateContext.buildConstraintViolationWithTemplate(errorCode).addConstraintViolation();
	}

}
