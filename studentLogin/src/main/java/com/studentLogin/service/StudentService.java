package com.studentLogin.service;

import java.util.List;
import java.util.Optional;

import com.studentLogin.entity.Student;

public interface StudentService {

List<Student> getallStudents();
	
	Optional<Student> getStudentById(long id);
	
	Student createStudent(Student student);
	
	Student updateStudent(Student student);
	
	/* void deleteEmployeeById(long id); */
	
	void delete(Student student);
	
    void deleteallStudents();
	
	
}
