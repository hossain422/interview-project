package com.saidy.StudentFormApp.serviceImpl;

import com.saidy.StudentFormApp.dto.StudentDTO;

import com.saidy.StudentFormApp.entity.Student;

import com.saidy.StudentFormApp.repository.StudentRepository;

import com.saidy.StudentFormApp.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private StudentDTO mapToDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getRoll(),
                student.getStudentClass(),
                student.getDepartment(),
                student.isActive()
        );
    }

    private Student mapToEntity(StudentDTO dto) {
        Student s = new Student();
        s.setId(dto.getId());
        s.setName(dto.getName());
        s.setRoll(dto.getRoll());
        s.setStudentClass(dto.getStudentClass());
        s.setDepartment(dto.getDepartment());
        s.setActive(dto.isActive());
        return s;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student s = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return mapToDTO(s);
    }

    @Override
    public void createStudent(StudentDTO studentDTO) {
        Student s = mapToEntity(studentDTO);
        studentRepository.save(s);
    }

    @Override
    public void updateStudent(Long id, StudentDTO studentDTO) {
        Student s = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        s.setName(studentDTO.getName());
        s.setRoll(studentDTO.getRoll());
        s.setStudentClass(studentDTO.getStudentClass());
        s.setDepartment(studentDTO.getDepartment());
        studentRepository.save(s);
    }

    @Override
    public void activateStudent(Long id) {
        Student s = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        s.setActive(true);
        studentRepository.save(s);
    }

    @Override
    public void deactivateStudent(Long id) {
        Student s = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        s.setActive(false);
        studentRepository.save(s);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}