package com.example.demo.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.sms.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	

}
