package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.example.demo.entity.StudentEntity;
import com.example.demo.model.Student;


@Mapper(componentModel = "spring", unmappedTargetPolicy= ReportingPolicy.WARN)
public interface DemoMapper {
	
	@Mapping(target = "rollNum", source = "rollNumber")
	Student toStudent(StudentEntity studentEntity);
	
	@Mapping(target = "rollNumber", source = "rollNum")
	StudentEntity toStudentEntity(Student student);
	
	
}
