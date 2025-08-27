package com.saidy.StudentFormApp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String roll;

    @Column(name = "student_class")  // 'class' keyword এর ঝামেলা এড়াতে
    private String studentClass;

    private String department;

    private boolean active = true; // default value

    // ✅ No-args constructor (Hibernate এর জন্য দরকারি)
    public Student() {
    }

    // ✅ Parameterized constructor (নিজে object বানানোর সুবিধার জন্য)
    public Student(String name, String roll, String studentClass, String department) {
        this.name = name;
        this.roll = roll;
        this.studentClass = studentClass;
        this.department = department;
        this.active = true; // default
    }

    // --------- Getters & Setters ----------
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }
    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getStudentClass() {
        return studentClass;
    }
    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    // ✅ Debugging এর জন্য toString()
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roll='" + roll + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", department='" + department + '\'' +
                ", active=" + active +
                '}';
    }
}