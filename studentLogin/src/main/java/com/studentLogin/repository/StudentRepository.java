package com.studentLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentLogin.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
