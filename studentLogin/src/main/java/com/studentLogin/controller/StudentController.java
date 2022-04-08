package com.studentLogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.studentLogin.exception.ResourceNotFoundException;
import com.studentLogin.entity.Student;
import com.studentLogin.service.StudentService;



//@CrossOrigin(value = "/")
@RestController
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RequestMapping(value = "/api/v1/")
public class StudentController {

	
	@Autowired
	StudentService studentService;
	
	@GetMapping(value = "/students")
	public List<Student> getallStudents(){
		return this.studentService.getallStudents();
	}
	
	 @RequestMapping(value = "/students", method = RequestMethod.POST,
			   consumes = MediaType.APPLICATION_JSON_VALUE,
			   produces = MediaType.APPLICATION_JSON_VALUE )
	public Student createStudent(@RequestBody Student students){
	   return this.studentService.createStudent(students);
	}
	
	 @GetMapping(value = "/students/{id}")
		public Optional<Student> getStudentById(@PathVariable Long id){
			return this.studentService.getStudentById(id);
	 }	
	 
	 @PutMapping(value = "/students/{id}")
		public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long id,
				@RequestBody Student studentDetails) throws ResourceNotFoundException
		{
			Student student = this.studentService.getStudentById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Student does not exist of this ID ::" + id));
			student.setFirstName(studentDetails.getFirstName());
			student.setLastName(studentDetails.getLastName());
			student.setEmailId(studentDetails.getEmailId());
			student.setMobileNumber(studentDetails.getMobileNumber());
			final Student updatedStudent = studentService.updateStudent(student);
			return ResponseEntity.ok().body(updatedStudent);
		}
	 
	 @DeleteMapping(value = "/students/{id}")
		public Map<String, Boolean> deteleStudent(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
		   	
			Student student = this.studentService.getStudentById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Student does not exist of this ID ::" + id));
			
			this.studentService.delete(student);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}
		
	 @DeleteMapping(value = "/deleteall")
		public void deleteallStudent(){
			this.studentService.deleteallStudents();
		}
}
