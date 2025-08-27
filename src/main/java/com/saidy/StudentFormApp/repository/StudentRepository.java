package com.saidy.StudentFormApp.repository;

import com.saidy.StudentFormApp.entity.Student;
import org .springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface  StudentRepository  extends JpaRepository<Student,Long> {
	
	

	
	
	
}
