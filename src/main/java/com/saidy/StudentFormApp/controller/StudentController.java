package com.saidy.StudentFormApp.controller;

import com.saidy.StudentFormApp.dto.StudentDTO;
import com.saidy.StudentFormApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public String studentList(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "list";
    }

   
    @GetMapping("/students/new")
    public String studentForm(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "form";
    }

 
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
        return "redirect:/students";
    }

  
    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "form";
    }

    
    @PostMapping("/students/update/{id}")
    
    public String updateStudent(@PathVariable Long id, @ModelAttribute StudentDTO studentDTO) {
        studentService.updateStudent(id, studentDTO);
        
        return "redirect:/students";
    }

 
    @GetMapping("/students/activate/{id}")
    public String activateStudent(@PathVariable Long id) {
        studentService.activateStudent(id);
        
        return "redirect:/students";
    }

    @GetMapping("/students/deactivate/{id}")
    
    public String deactivateStudent(@PathVariable Long id) {
        studentService.deactivateStudent(id);
        
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}