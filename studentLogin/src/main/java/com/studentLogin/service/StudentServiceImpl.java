package com.studentLogin.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentLogin.entity.Student;
import com.studentLogin.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	
	@Override
	@Transactional
	public List<Student> getallStudents() {
		return studentRepository.findAll();
	}
	
	@Override
	@Transactional
	public Optional<Student> getStudentById(long id) {
	
		return studentRepository.findById(id);
	}
	
	@Override
	@Transactional
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	@Override
	@Transactional
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	@Override
	@Transactional
	public void delete(Student student) {
		studentRepository.delete(student);
		
	}
	
	@Override
	@Transactional
	public void deleteallStudents() {
		studentRepository.deleteAll();
		
	}

	
	
}
