package com.example.demo.validations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD, PARAMETER, METHOD, ANNOTATION_TYPE, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StudentValidatorImpl.class)
public @interface StudentValidator {
	String message() default "blank message";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};

}
