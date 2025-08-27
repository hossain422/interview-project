package com.saidy.StudentFormApp.service;

import com.saidy.StudentFormApp.dto.StudentDTO;
import java.util.List;

public interface StudentService {

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    void createStudent(StudentDTO studentDTO);

    void updateStudent(Long id, StudentDTO studentDTO);

    void activateStudent(Long id);

    void deactivateStudent(Long id);

    void deleteStudent(Long id);
}
	
	
	
